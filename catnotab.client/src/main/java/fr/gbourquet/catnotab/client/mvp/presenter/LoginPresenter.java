package fr.gbourquet.catnotab.client.mvp.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;

import fr.gbourquet.catnotab.client.event.LoginEvent;
import fr.gbourquet.catnotab.client.mvp.ClientFactory;
import fr.gbourquet.catnotab.serveur.metier.Personne;
import fr.gbourquet.catnotab.service.in.LoginAction;
import fr.gbourquet.catnotab.service.out.LoginResult;

/**
 * Presenter de la vue de login.
 * 
 * @author guillaume
 */
public class LoginPresenter extends AbstractActivity {

	/**
	 * Contrat echange avec la vue.
	 * 
	 * @author guillaume
	 */
	public interface View extends IsWidget {

		/**
		 * Methode pour afficher la vue.
		 */
		void show();

		/**
		 * Methode pour cacher la vue.
		 */
		void hide();

		/**
		 * Methode d'acces à la valeur du champ id.
		 * 
		 * @return String le contenu du champ id
		 */
		String getId();

		/**
		 * Methode d'acces à la valeur du champ passwd.
		 * 
		 * @return String le contenu du champ passwd
		 */
		String getPasswd();

		/**
		 * Methode d'acces au bouton login.
		 * 
		 * @return Button le bouton login
		 */
		Button getLogin();

		/**
		 * Methode d'acces en écriture à la valeur du champ login.
		 * 
		 * @param login
		 *            valeur à mettre à jour
		 */
		void setId(String id);

		/**
		 * Methode d'acces en écriture à la valeur du champ passwd.
		 * 
		 * @param passwd
		 *            valeur à mettre à jour
		 */
		void setPasswd(String passwd);

		/**
		 * Methode d'ecriture d'un message d'erreur.
		 * 
		 */
		void errorLogin();

	}

	/**
	 * Dispatcher pour appeler les services.
	 */
	private DispatchAsync dispatcher;

	private View view;
	private final EventBus eventBus;
	
	/**
	 * Constructeur.
	 * 
	 * @param display
	 *            Class implementant la vue
	 * @param eventBus
	 *            bus des messages
	 */
	public LoginPresenter(ClientFactory factory) {
		this.dispatcher = factory.getDistpatcher();
		this.view = factory.getLoginView();
		this.eventBus = factory.getEventBus();
	}

	@Override
	public void start(AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBusBidon) {
		
		view.getLogin().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				/*
				 * On appelle le service de login.Si Ok, on ferme la fenetre,
				 * sinon on affiche un message d'erreur
				 */
				dispatcher.execute(new LoginAction(view.getId(),
						view.getPasswd()),
						new AsyncCallback<LoginResult>() {
							public void onSuccess(final LoginResult result) {
								Personne utilisateur = result
										.getUtilisateur();
								if (utilisateur != null) {
									// On envoie un message dans le bus
									eventBus.fireEvent(new LoginEvent(
											utilisateur));
									// On ferme la fenetre de login
									view.hide();
								} else {
									view.errorLogin();
									view.setId("");
									view.setPasswd("");
								}
							}

							public void onFailure(final Throwable e) {
								e.printStackTrace();
								view.errorLogin();
								view.setId("");
								view.setPasswd("");
							}
						});
			}
		});
		view.show();
	}

	public void setLogin(String login) {
		view.setId(login);
	}
}

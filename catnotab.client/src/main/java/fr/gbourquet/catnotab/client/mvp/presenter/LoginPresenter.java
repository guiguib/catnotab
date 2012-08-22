package fr.gbourquet.catnotab.client.mvp.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
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
		 * Methode d'acces à la valeur du champ id.
		 * 
		 * @return String le contenu du champ id
		 */
		String getLoginText();

		/**
		 * Methode d'acces à la valeur du champ passwd.
		 * 
		 * @return String le contenu du champ passwd
		 */
		String getPasswdText();

		HasKeyPressHandlers getLoginKeyPress();
		HasKeyPressHandlers getPasswdKeyPress();
		
		/**
		 * Methode d'acces au bouton login.
		 * 
		 * @return Button le bouton login
		 */
		HasClickHandlers getLoginButton();

		/**
		 * Methode d'acces en écriture à la valeur du champ login.
		 * 
		 * @param login
		 *            valeur à mettre à jour
		 */
		void setLoginText(String loginText);

		/**
		 * Methode d'acces en écriture à la valeur du champ passwd.
		 * 
		 * @param passwd
		 *            valeur à mettre à jour
		 */
		void setPasswdText(String passwdText);

		/**
		 * Methode d'ecriture d'un message d'erreur.
		 * 
		 */
		void errorLogin(String message);
		
		/**
		 * Methode d'affichage de la popup
		 * 
		 */
		void setVisible(boolean visible);

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
	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBusBidon) {

		view.getLoginButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				login();
			}
		});

		view.getLoginKeyPress().addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
					login();
				}

			}
		});

		view.getPasswdKeyPress().addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
					login();
				}

			}
		});
		
		view.setVisible(true);
		
	}

	public void setLogin(String login) {
		view.setLoginText(login);
	}

	private void login() {
		/*
		 * On appelle le service de login.Si Ok, on ferme la fenetre, sinon on
		 * affiche un message d'erreur
		 */
		dispatcher.execute(new LoginAction(view.getLoginText(), view.getPasswdText()),
				new AsyncCallback<LoginResult>() {
					public void onSuccess(final LoginResult result) {
						Personne utilisateur = result.getUtilisateur();
						if (utilisateur != null) {
							// On envoie un message dans le bus
							eventBus.fireEvent(new LoginEvent(utilisateur));
							// On ferme la fenetre de login
							view.setVisible(false);
						} else {
							view.errorLogin("Erreur de connexion");
							view.setLoginText("");
							view.setPasswdText("");
						}
					}

					public void onFailure(final Throwable e) {
						e.printStackTrace();
						view.errorLogin(e.getMessage());
						view.setLoginText("");
						view.setPasswdText("");
					}
				});
	}
}

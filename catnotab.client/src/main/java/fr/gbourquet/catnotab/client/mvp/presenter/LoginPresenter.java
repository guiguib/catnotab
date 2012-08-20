package fr.gbourquet.catnotab.client.mvp.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
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
		TextBox getLogin();

		/**
		 * Methode d'acces à la valeur du champ passwd.
		 * 
		 * @return String le contenu du champ passwd
		 */
		TextBox getPasswd();

		/**
		 * Methode d'acces au bouton login.
		 * 
		 * @return Button le bouton login
		 */
		Button getLoginButton();

		/**
		 * Methode d'acces en écriture à la valeur du champ login.
		 * 
		 * @param login
		 *            valeur à mettre à jour
		 */
		void setLogin(TextBox login);

		/**
		 * Methode d'acces en écriture à la valeur du champ passwd.
		 * 
		 * @param passwd
		 *            valeur à mettre à jour
		 */
		void setPasswd(PasswordTextBox passwd);

		/**
		 * Methode d'ecriture d'un message d'erreur.
		 * 
		 */
		void errorLogin(String message);

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

		final DialogBox popup = new DialogBox();
		popup.add(view);
		popup.setText("Connexion au site");
		popup.setPopupPosition(200, 0);
		popup.show();
		view.getLoginButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				login(popup);
			}
		});

		view.getLogin().addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
					login(popup);
				}

			}
		});

		view.getPasswd().addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
					login(popup);
				}

			}
		});
	}

	public void setLogin(String login) {
		view.getLogin().setText(login);
	}

	private void login(final DialogBox popup) {
		/*
		 * On appelle le service de login.Si Ok, on ferme la fenetre, sinon on
		 * affiche un message d'erreur
		 */
		dispatcher.execute(new LoginAction(view.getLogin().getText(), view.getPasswd().getText()),
				new AsyncCallback<LoginResult>() {
					public void onSuccess(final LoginResult result) {
						Personne utilisateur = result.getUtilisateur();
						if (utilisateur != null) {
							// On envoie un message dans le bus
							eventBus.fireEvent(new LoginEvent(utilisateur));
							// On ferme la fenetre de login
							popup.hide();
						} else {
							view.errorLogin("Erreur de connexion");
							view.getLogin().setText("");
							view.getPasswd().setText("");
						}
					}

					public void onFailure(final Throwable e) {
						e.printStackTrace();
						view.errorLogin(e.getMessage());
						view.getLogin().setText("");
						view.getPasswd().setText("");
					}
				});
	}
}

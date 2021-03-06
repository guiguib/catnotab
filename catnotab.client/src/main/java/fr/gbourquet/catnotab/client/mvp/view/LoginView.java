package fr.gbourquet.catnotab.client.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import fr.gbourquet.catnotab.client.mvp.presenter.LoginPresenter;

public class LoginView extends Composite implements LoginPresenter.View  {

	private static LoginViewUiBinder uiBinder = GWT
			.create(LoginViewUiBinder.class);

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}

	@UiField
	DialogBox popup;
	
	@UiField
	Button buttonLogin;

	@UiField
	TextBox login;

	@UiField
	PasswordTextBox passwd;

	@UiField
	Label error;
	
	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
		buttonLogin.setText("Login");
		error.setText("Veuillez entrer vos identifiants de connexion");
		error.removeStyleName("error");
		popup.setText("Connexion au site");
		popup.setPopupPosition(300, 200);
		popup.setSize("400px","200px");
	}

	@Override
	public String getLoginText() {
		return login.getText();
	}

	@Override
	public String getPasswdText() {
		return passwd.getText();
	}

	@Override
	public HasKeyPressHandlers getLoginKeyPress() {
		return login;
	}

	@Override
	public HasKeyPressHandlers getPasswdKeyPress() {
		return passwd;
	}

	@Override
	public HasClickHandlers getLoginButton() {
		return buttonLogin;
	}

	@Override
	public void setLoginText(String loginText) {
		login.setText(loginText);
		
	}

	@Override
	public void setPasswdText(String passwdText) {
		passwd.setText(passwdText);
	}

	@Override
	public void errorLogin(String message) {
		error.setText(message);
		error.addStyleName("error");
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible)
			popup.show();
		else 
			popup.hide();
	}

	

}

package fr.gbourquet.catnotab.client.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
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
	}

	@Override
	public TextBox getPasswd() {
		// TODO Auto-generated method stub
		return passwd;
	}

	@Override
	public void setPasswd(PasswordTextBox passwd) {
		this.passwd = passwd;
		
	}

	@Override
	public void errorLogin(String message) {
		this.error.setText(message);
	}

	@Override
	public Button getLoginButton() {
		return buttonLogin;
	}

	@Override
	public void setLogin(TextBox login) {
		this.login = login;
		
	}

	@Override
	public TextBox getLogin() {
		return this.login;
	}

}

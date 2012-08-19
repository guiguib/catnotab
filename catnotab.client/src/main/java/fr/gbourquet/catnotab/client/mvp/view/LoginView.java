package fr.gbourquet.catnotab.client.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
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
	TextBox passwd;

	@UiField
	Label error;
	
	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
		buttonLogin.setText("Login");
	}

	@Override
	public String getPasswd() {
		// TODO Auto-generated method stub
		return passwd.getText();
	}

	@Override
	public void setPasswd(String passwd) {
		this.passwd.setText(passwd);
		
	}

	@Override
	public void errorLogin(String message) {
		this.error.setText(message);
		
	}

	@Override
	public Button getLoginButton() {
		// TODO Auto-generated method stub
		return buttonLogin;
	}

	@Override
	public void setLogin(String login) {
		this.login.setText(login);
		
	}

	@Override
	public String getLogin() {
		return this.login.getText();
	}

}

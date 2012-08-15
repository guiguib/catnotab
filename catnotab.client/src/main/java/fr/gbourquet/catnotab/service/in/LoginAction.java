package fr.gbourquet.catnotab.service.in;

import net.customware.gwt.dispatch.shared.Action;
import fr.gbourquet.catnotab.service.out.LoginResult;

public class LoginAction implements Action<LoginResult> {
    
	private String login;
	private String passwd;

    /** For serialization only. */
    LoginAction() {
    }

    public LoginAction(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    public String getLogin() {
        return this.login;
    }
    
    public String getPasswd() {
        return this.passwd;
    }
}
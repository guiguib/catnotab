package fr.gbourquet.catnotab.service.handler;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import fr.gbourquet.catnotab.serveur.metier.Personne;
import fr.gbourquet.catnotab.serveur.service.login.LoginService;
import fr.gbourquet.catnotab.serveur.util.BeanFactory;
import fr.gbourquet.catnotab.service.in.LoginAction;
import fr.gbourquet.catnotab.service.out.LoginResult;

public class LoginHandler implements ActionHandler<LoginAction, LoginResult> {
	
	@Override
	public LoginResult execute(final LoginAction in,
					  final ExecutionContext context) throws ActionException {
		final String login = in.getLogin();
		final String passwd = in.getPasswd();
		
		Personne utilisateur=null;
		LoginService service = (LoginService) BeanFactory.getInstance().getService("loginService");
				
		utilisateur = service.login(login,passwd);
		return new LoginResult(utilisateur);

	}

	@Override
	public void rollback(final LoginAction action,
			     final LoginResult result,
			     final ExecutionContext context) throws ActionException {
		// Nothing to do here
	}
	
	@Override
	public Class<LoginAction> getActionType() {
		return LoginAction.class;
	}
}
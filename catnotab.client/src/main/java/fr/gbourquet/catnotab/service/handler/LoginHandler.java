package fr.gbourquet.catnotab.service.handler;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import fr.gbourquet.catnotab.serveur.metier.auto.DroitPersonneKey;
import fr.gbourquet.catnotab.serveur.service.LoginService;
import fr.gbourquet.catnotab.serveur.service.exception.ServiceException;
import fr.gbourquet.catnotab.serveur.util.BeanFactory;
import fr.gbourquet.catnotab.service.in.LoginAction;
import fr.gbourquet.catnotab.service.out.LoginResult;

public class LoginHandler implements ActionHandler<LoginAction, LoginResult> {

	public LoginResult execute(LoginAction in, ExecutionContext context)
			throws ActionException {

		final String login = in.getLogin();
		final String passwd = in.getPasswd();

		fr.gbourquet.catnotab.serveur.metier.auto.Personne utilisateur = null;
		List<DroitPersonneKey> droits = null;
		LoginService service = (LoginService) BeanFactory.getInstance()
				.getService("loginService");
		try {

			utilisateur = service.login(login, passwd);
		} catch (ServiceException e) {
			throw new ActionException(e.getMessage());
		}

		try {

			droits = service.getDroits(utilisateur);
		} catch (ServiceException e) {
			throw new ActionException(e.getMessage());
		}

		session().setAttribute("utilisateur", utilisateur);
		session().setAttribute("droits", droits);
		session().setAttribute("token", generateToken());
		return new LoginResult(utilisateur);

	}

	@Override
	public void rollback(final LoginAction action, final LoginResult result,
			final ExecutionContext context) throws ActionException {
		// Nothing to do here
	}

	@Override
	public Class<LoginAction> getActionType() {
		return LoginAction.class;
	}

	final static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}

	private final static String encrypt(String plaintext) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA"); // step 2
		} catch (NoSuchAlgorithmException e) {
			return "cryptage impossible";
		}
		try {
			md.update(plaintext.getBytes("UTF-8")); // step 3
		} catch (UnsupportedEncodingException e) {
			return "cryptage impossible";
		}
		byte raw[] = md.digest(); // step 4
		byte[] hash = (new Base64()).encode(raw); // step 5
		return new String(hash); // step 6
	}

	private final static String generateToken() {
		return encrypt(Math.random() + "");
	}

}
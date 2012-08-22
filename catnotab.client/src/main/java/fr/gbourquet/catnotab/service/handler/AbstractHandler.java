package fr.gbourquet.catnotab.service.handler;

import javax.servlet.http.HttpSession;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.ActionException;
import net.customware.gwt.dispatch.shared.Result;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


//abstract class AbstractGeneric1<T extends MyObject> implements IGeneric<T> { }

public abstract class AbstractHandler<A extends Action<R>, R extends Result> implements ActionHandler<A, R>{
	
	final static HttpSession session() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); // true == allow create
	}
	
	public final R execute(A action, ExecutionContext context) throws ActionException {
		//TODO : Gestion des droits
		//Personne utilisateur = (Personne) session().getAttribute("utilisateur");
		
		return exec(action, context);
	}
		
	public abstract R exec(A action, ExecutionContext context) throws ActionException;

}

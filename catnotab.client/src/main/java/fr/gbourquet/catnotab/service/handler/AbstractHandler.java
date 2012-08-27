package fr.gbourquet.catnotab.service.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import net.customware.gwt.dispatch.shared.Result;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import fr.gbourquet.catnotab.serveur.metier.auto.DroitPersonneKey;
import fr.gbourquet.catnotab.service.exceptions.IllegalUserException;
import fr.gbourquet.catnotab.service.in.AbstractAction;


//abstract class AbstractGeneric1<T extends MyObject> implements IGeneric<T> { }

public abstract class AbstractHandler<A extends AbstractAction<R>, R extends Result> implements ActionHandler<A, R>{
	
	final static HttpSession session() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); // true == allow create
	}
	
	public final R execute(A action, ExecutionContext context) throws ActionException {
		//TODO : Gestion des droits
		HttpSession session = session();
		@SuppressWarnings("unchecked")
		List<DroitPersonneKey> droits = (List<DroitPersonneKey>) session.getAttribute("droits"); 
		String token = (String) session.getAttribute("token");
		
		if (!token.equals(action.getToken()))
			throw new IllegalUserException();
		
		String codeDroit = action.getCodeDroit();
		boolean present=false;
		for(DroitPersonneKey droit:droits)
		{
			present = (droit.getCodedroit().equals(codeDroit));
			if (present)
				break;
		}
        if (!present)
        	throw new IllegalUserException();
		
		return exec(action, context);
	}
		
	public abstract R exec(A action, ExecutionContext context) throws ActionException;

}

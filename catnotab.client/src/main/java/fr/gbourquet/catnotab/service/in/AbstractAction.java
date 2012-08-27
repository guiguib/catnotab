package fr.gbourquet.catnotab.service.in;

import fr.gbourquet.catnotab.client.LocalSession;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

public abstract class AbstractAction<R extends Result> implements Action<R> {
	
	private String token;
	
    /** For serialization only. */
    AbstractAction() {
    	//On récupère le token pour vérification côté serveur
    	this.token = (String) LocalSession.getInstance().getAttribute("token");
    }
 
    public final String getToken() {
        return this.token;
    }
    
    public final void setToken(String token) {
    	this.token = token;
    }
    
    public abstract String getCodeDroit();
}
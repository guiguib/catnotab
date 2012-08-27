package fr.gbourquet.catnotab.service.in;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

public abstract class AbstractAction<R extends Result> implements Action<R> {
	
	private String token;
	
    /** For serialization only. */
    AbstractAction() {
    }
 
    public final String getToken() {
        return this.token;
    }
    
    public final void setToken(String token) {
    	this.token = token;
    }
    
    public abstract String getCodeDroit();
}
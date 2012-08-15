package fr.gbourquet.catnotab.service.dispatch;

import net.customware.gwt.dispatch.client.standard.StandardDispatchService;
import net.customware.gwt.dispatch.server.DefaultActionHandlerRegistry;
import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.server.InstanceActionHandlerRegistry;
import net.customware.gwt.dispatch.server.SimpleDispatch;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.DispatchException;
import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.gbourquet.catnotab.service.handler.LoginHandler;

public class DispatchServlet extends RemoteServiceServlet implements StandardDispatchService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1501013756598962446L;
	private Dispatch dispatch;

    public DispatchServlet() {

        InstanceActionHandlerRegistry registry = new DefaultActionHandlerRegistry();
        registry.addHandler(new LoginHandler());
        dispatch = new SimpleDispatch(registry);
    }

    public Result execute(Action<?> action) throws DispatchException {

        try {
            return dispatch.execute(action);
        } catch ( RuntimeException e) {
        	log( "Exception while executing " + action.getClass().getName() + ": " + e.getMessage(), e );
        	throw e;
        }
    }

}
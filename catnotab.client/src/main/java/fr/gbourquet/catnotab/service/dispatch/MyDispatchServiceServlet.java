package fr.gbourquet.catnotab.service.dispatch;

import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.server.standard.AbstractStandardDispatchServlet;

public class MyDispatchServiceServlet extends AbstractStandardDispatchServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2451605923654590519L;

	public MyDispatchServiceServlet() {
		super();
	}

	@Override
	protected Dispatch getDispatch() {
		return DispatchUtil.getDispatch();
	}
}

package fr.gbourquet.catnotab.service.dispatch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import fr.gbourquet.catnotab.service.handler.LoginHandler;

public class MyActionHandlersConfig implements ServletContextListener {
	  public void contextInitialized( ServletContextEvent evt ) {
	      DispatchUtil.registerHandler( new LoginHandler() );
	        // Etc.
	  }

	  public void contextDestroyed( ServletContextEvent evt ) {
	    // Do nothing...
	  }
	}

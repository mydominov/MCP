package com.calango.MCP.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.calango.MCP.db.factory.DefaultPool;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        super();
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		DefaultPool.dispose();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		//final ServletContext servletContext = arg0.getServletContext();
		//final String poolPath = "com/calango/MCP/properties/config/MySqlDbConnection";
		final String poolPath = "MySqlDbConnection";
		final String pack = poolPath;
		DefaultPool.init(pack);
	}
	
}

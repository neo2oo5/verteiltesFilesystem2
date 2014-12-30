/**
 * 
 */
package com.vs2.origin;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.JOptionPane;

/**
 * @author xoxoxo
 *
 */
public class OriginStarter implements ServletContextListener{
	


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		DisplayStarter dstarter = new DisplayStarter();
        Thread t = new Thread(dstarter);
        t.start();
	}
	

}



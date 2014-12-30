package com.vs2.origin;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

import com.vs2.network.crudPost.CrudPostList;

public class DisplayStarter implements Runnable{

	Output out = Output.getInstance();
	
	@Override
	public void run() {
		/**
         * Singelton Klasse Im gesamten Projekt benutzbar aufruf ueber folgenden
         * ein Zeiler Output out = Output.getInstance(); out.print(Object
         * msg, int modelevel) Level: 0) None 1) Information (Default) 2)
         * Warning 3) Error
         *
         * Wird Standart maeßig in log.txt geschrieben Kann in config.properties
         * den modelevel geaendert werden
         *
         * 
         */
		CrudPostList pList = CrudPostList.getInstance();
        
     		pList.create(2, 3, "test inhalt2", "lisa", "test title");
			pList.create(1, 2, "test inhalt", "kevin", "title");
			pList.create(2, 3, "test inhalt2", "lisa", "test title");
			
			
		out.print("Programm gestartet");
		
		/*
		 * Oeffnet View in Browser
		 */
		try {
	        openWebpage(new URI("http://localhost:8080/verteilteSysteme2-0.0.1-SNAPSHOT/"));
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
		
		GuiPromptHelper Gui = new GuiPromptHelper();
		
		
		if(Gui.showQuestion("Server Beenden? \nOS: " + PathHelper.getOSName() , "Wirklich Beenden") == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
		
		
	}
	
	public static void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	

}

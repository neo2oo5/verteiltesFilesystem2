package com.vs2.origin;



import com.vs2.origin.*;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Ein wenig Farbe fuer den Terminal
 *
 * @author Kevin Bonner  - kevin.bonner@gmx.de
 */
public class Output
{

    /**
     *
     */
    protected String Logfile = "log.txt";

    /**
     *
     */
    protected PrintStream orig = System.out;
    
    private List<String> log
    = Collections.synchronizedList(new ArrayList<String>());

    /*
    protected static final String ANSI_BLACK = "\u001B[30m";
    protected static final String ANSI_WHITE = "\u001B[37m";
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_GREEN = "\u001B[32m";
	protected static final String ANSI_YELLOW = "\u001B[33m";
     */
    
    protected static final String ANSI_BLACK = "#000";
    protected static final String ANSI_WHITE = "#fff";
    protected static final String ANSI_RED = "#ff0000";
    protected static final String ANSI_GREEN = "#00ff00";
	protected static final String ANSI_YELLOW = "#ffff00";
    
	/**
	 * Funktion welche die einigartige Instanz generiert.
	 */
    private static class OutputHolder
    {

        /** The instance. */
        private static Output INSTANCE = new Output();
    }

    /**
     * Lazy Loading mit unsynchronisierter getinstance()-Methode aber mit
     * synchronisierter Instanzierung und doppeltem Null-Check.
     *
     * @return Output Instanz zurueck
     */
    public static Output getInstance()
    {
        if (OutputHolder.INSTANCE == null)
        {
            synchronized (OutputHolder.INSTANCE)
            {
                if (OutputHolder.INSTANCE == null)
                {
                    OutputHolder.INSTANCE = new Output();
                }
            }
        }
        return OutputHolder.INSTANCE;
    }
    
    private Output()
    {

    }

    /**
     *
     * @param msg
     */
    private Output(Object msg)
    {
        setLogfile();
        print(msg);

        setStdout();
        print(msg);
    }

    /**
     *
     * @param msg
     * @param modelevel
     */
    private Output(Object msg, int modelevel)
    {
        setLogfile();
        print(msg, modelevel);

        setStdout();
        print(msg, modelevel);
    }

    /**
     *
     */
    protected void setStdout()
    {
        System.setOut(orig);
    }

    /**
     *
     */
    protected void setLogfile()
    {
        try
        {
            System.setOut(new PrintStream(PathHelper.getFile(Logfile)));
        } catch (Exception ex)
        {
            new GuiPromptHelper(GuiPromptHelper.showError, ex.toString());
        }
    }

    /**
     * Gibt eine Nachricht aus als Information
     * @param msg
     */
    public void print(Object msg)
    {
    	setLogfile();
        print(msg, 1);
    }

    /**
     * Gibt eine Nachricht aus entsprechend dem Modelevel
     * @param msg
     * @param modelevel
     */
    public void print(Object msg, int modelevel)
    {
        int debug = 0;
        Properties prop = new Properties();
        InputStream input = null;

        /*Liest aus Datei den ModeLevel
         * Level: 
         * 0) None
         * 1) Information (Default)
         * 2) Warning
         * 3) Error
         */
        try
        {

            try
            {
                // load a properties file
                prop.load(new FileReader(PathHelper.getFile("debug.properties")));
            } catch (fileSystemException ex)
            {
                Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
            }

            // get the property value and print it out
            try
            {
                debug = Integer.parseInt(prop.getProperty("MODE"));
            } catch (Exception e)
            {
                new GuiPromptHelper(GuiPromptHelper.showWarning, "Output: Modelevel konnte nicht gelesen werden " + e);
            }

        } catch (FileNotFoundException e)
        {
            new GuiPromptHelper(GuiPromptHelper.showWarning, "Output: Debug File konnte nicht geladen werden " + e);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        out(msg, modelevel, debug);

    }

    /**
     * Coloriert den Übergebenen Text
     * @param msg
     * @param mode
     * @param debug
     */
    public void out(Object msg, int mode, int debug)
    {
        String print = "<div style='color:";

        if (debug >= 3 && mode == 3)
        {
            print += ANSI_RED + "'>ERROR: ";
        } else if (debug >= 2 && mode == 2)
        {
            print += ANSI_YELLOW + "'>WARNING: ";
        } else if (debug >= 1 && mode == 1)
        {
            print += ANSI_GREEN + "'>INFORMATION: ";
        }

        if (mode != 0)
        {
            System.out.println(print + msg + "</div>");
        }
    }
    
    private void readLogfile()
    {
        try
        {
            BufferedReader in
                    = new BufferedReader(new FileReader(PathHelper.getFile(Logfile)));
            String line = new String();

            while ((line = in.readLine()) != null)
            {
                log.add(line);
            }
        } catch (Exception e)
        {
            new GuiPromptHelper(GuiPromptHelper.showWarning,
                    "GUIOutput: Es gab ein Fehler beim lesen des Logfiles. "
                    + e.toString());
        }
    }
    
    @Override
    public String toString()
    {
    	String retString = "";
    	readLogfile();
    	
    	synchronized (log)
        {
            for (int i = 0; i < log.size(); i++)
            {
            	retString += log.get(i);
            }
        }
    	
    	return retString;
    }

}

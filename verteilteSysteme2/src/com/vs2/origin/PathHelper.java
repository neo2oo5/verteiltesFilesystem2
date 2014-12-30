package com.vs2.origin;

import com.vs2.origin.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Gibt OS Name zurueck und gibt Pfad zu Dateien und Ordnern im System ordner OS
 * formatiert zurueck
 *
 * @author Kevin Bonner  - kevin.bonner@gmx.de
 */
public class PathHelper
{

    static Output out = Output.getInstance();
    private static String SysDir = System.getProperty("user.dir") + File.separator + "System" + File.separator;

    /**
     * Gibt den Namen des Betriebssystemes zurück
     * @return Name des OS
     */
    public static String getOSName()
    {
        String os = System.getProperty("os.name");

        if (os.contains("Linux"))
        {
            return "Linux";
        } else if (os.contains("Mac"))
        {

            return "Mac";
        } else if (os.contains("Windows"))
        {
            return "Windows";
        }

        return null;
    }

    private static String setPath(String Node)
    {
        if (getOSName().equals("Linux"))
        {
            return SysDir + Node;
        } else if (getOSName().equals("Mac"))
        {

            return SysDir + Node;
        } else if (getOSName().equals("Windows"))
        {
            return SysDir + Node;
        }
        return null;
    }

    /**
     * Gibt den vollen Pfad des Files entsprechend dem OS zurück
     * @param file 
     * @return vollen Pfad des Files
     * @throws fileSystemException falls Datei nicht gefunden wird
     */
    public static String getFile(String file) throws fileSystemException
    {
        Path fPath;

        if (file.length() > 0)
        {
            fPath = Paths.get(setPath(file) + File.separator);
        } else
        {
            fPath = Paths.get(setPath(file));
        }

        if (Files.exists(fPath))
        {
            return setPath(file);
        } else
        {
            throw new fileSystemException("File not Found. Path:" + file);
        }

    }

    /**
     * Gibt den vollen Pfad des Folders entsprechend dem OS zurück
     * @param folder
     * @return vollen Pfad des Folder
     * @throws fileSystemException falls Folder nicht gefunden wird
     */
    public static String getFolder(String folder) throws fileSystemException
    {
        Path fPath;

        if (folder.length() > 0)
        {
            fPath = Paths.get(setPath(folder) + File.separator);
        } else
        {
            fPath = Paths.get(setPath(folder));
        }

        if (Files.exists(fPath))
        {
            return setPath(folder) + File.separator;
        } else
        {
            throw new fileSystemException("File not Found. Path:" + folder);
        }
    }

}

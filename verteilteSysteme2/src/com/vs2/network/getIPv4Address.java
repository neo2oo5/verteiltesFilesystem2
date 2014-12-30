/**
 * Package
 */
package com.vs2.network;

/**
 * Imports
 */

import java.util.ArrayList;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Enumeration;
import com.vs2.origin.*;
import java.net.SocketException;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/**
 * Klasse getIPv4Address
 * 
 * Klasse dient dazu, alle Aktuellen und in verwendung stehenden (W)LAN Ports zu erkennen
 * - die IP und den Adapter Name zu holen und in die ArrayListe bzw in die IPs.txt einzutragen
 * 
 * @author David Lampa
 * @version 1.0
 */
public class getIPv4Address
{
    /**
     * Variablen Initialisieren
     */
    static Output outMsg = Output.getInstance();

    

    /**
     * Funktion getIPv4Address
     * 
     * Diese Funktion dient dazu, alle Aktuellen und in verwendung stehenden (W)LAN Ports zu erkennen
     * - diese als verwendete IP zu setzen
     * - setzt die IP für den Programmstart
     *
     * @throws java.net.UnknownHostException
     */
    public static ArrayList<String> getIPv4Address() throws UnknownHostException
    {
        /**
         * Variablen Initialisieren
         * Nächste Element von netInter holen
         */
        int n = 0;
        String ip = null;
        ArrayList<String> adapter = new ArrayList<String>();
        Enumeration<NetworkInterface> netInter = null;
        
        try
        {
            /**
             * Hole alle Netzwerkadapter und trage diese in netInter ein
             */
            netInter = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex)
        {
            /**
             * Fehler abfangen und ausgeben
             */
            outMsg.print("(getIPv4Address - setIPv4Address) : " + ex.toString(), 2);
        }
        
        /**
         * Solange weitere Adapter in der netInter Liste eingetragen sind
         */
        while (netInter.hasMoreElements())
        {
            /**
             * Variablen Initialisieren
             * Nächste Element von netInter holen
             */
            int finder = 0;
            NetworkInterface ni = netInter.nextElement();
            
            /**
             * Hole die Netzwerk Adressen (Name + IP) solange noch welche in der Liste sind
             */
            for (InetAddress iaddress : Collections.list(ni.getInetAddresses()))
            {
                /**
                 * Überprüfe ob der Netzwerk Adapter verwendet werden kann
                 * - Loopback Adresse auf false prüfen
                 * - Local Adresse auf true prüfen
                 * - wenn dies der Fall ist, Adaptername und IP in die IPListe eintragen
                 *   & als Aktuelle IP setzen
                 */
            	
                if (iaddress.isLoopbackAddress() == false && iaddress.isSiteLocalAddress() == true)
                {
                    adapter.add(iaddress.getHostAddress());
                    
                }
            }
        }
        
        return adapter;
    }
}

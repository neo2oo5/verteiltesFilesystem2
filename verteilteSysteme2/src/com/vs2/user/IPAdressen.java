package com.vs2.user;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class IPAdressen {
    InputStream in;
    String htmlResponse;
    String publicIP;
    
    
    public String getPublicIP() throws IOException
    {
        in = urlOpen();
        htmlResponse = copyStream(in);
        publicIP = filterIPAdresse(htmlResponse);
        return publicIP;
    }
    
    private InputStream urlOpen() throws IOException 
    {
        URL url = new URL("http://checkip.dyndns.org/");
        in = url.openStream();
        return in;
    }
    
   
    private String copyStream(InputStream in) throws IOException 
    {
        String inhalt= "";
        BufferedInputStream bin = new BufferedInputStream(in);
       
        int c = bin.read();
        while (c != -1) 
        {
            inhalt = inhalt + (char) c;
            c = bin.read();
        }
        return inhalt;
    }
    
     private String filterIPAdresse(String htmlResponse)
     {
         String ip;               
            System.out.println("Ausgabe 1: "+htmlResponse);
            
            String[] Teile = htmlResponse.split(":");
            String teil1 = Teile[0]; 
            String teil2 = Teile[1]; 
            System.out.println("Teilausgabe 1: "+teil1);
            System.out.println("Teilausgabe 2: "+teil2);
            
            String[] TeileIP = teil2.split("<");
            ip = TeileIP[0].trim();
            return ip;
     }
   
    public static void main (String[] args) throws MalformedURLException, IOException 
    { 
        IPAdressen test = new IPAdressen();
        System.out.println("DIe oeffentliche IP lautet: "+test.getPublicIP());
    }
}

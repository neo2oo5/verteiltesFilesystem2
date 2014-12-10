package com.vs2.user;

/**
 * VS2-Projekt
 * @author Alexander Mohr, Timo Zimmer, Lukas Becker, Andreas Paul
 */

import java.util.ArrayList;
import java.util.List;

public class BenutzerListe {
    
    private List<Benutzer> benutzerListe;
    
    /*
        Konstruktor
        Initialisiert die Benutzerliste.
    */
    public BenutzerListe()
    {
        benutzerListe = new ArrayList<>();       
    }
    
    //-------------- Benutzer in Liste einfuegen bzw. loeschen ---------------
    
    /*
      Fuegt einen Benutzer, falls nicht schon in der Liste vorhanden, 
      in die Liste ein.
    
      @param bn     Benutzer, der eingefuegt werden soll.
    */
    public void addBenutzer(Benutzer bn)
    {
        if(!containsUser(bn))
        {
            benutzerListe.add(bn);
        }
    }
    
    /*
      Fuegt einen Benutzer, falls nicht schon in der Liste vorhanden, 
      an eine bestimmte Stelle in die Liste ein.
    
      @param stelle     Index, an die der Benutzer eingefuegt werden soll.
      @param bn         Benutzer, der eingefuegt werden soll.
    */
    public void addBenutzerByIndex(int stelle, Benutzer bn)
    {
        if(!containsUser(bn))
        {
            benutzerListe.add(stelle, bn);
        }
    }
    
    /*
      Loescht einen Benutzer an einer bestimmten Stelle.
    
      @param stelle     Stelle, an der der Benutzer geloescht werden soll.
    */
    public void deleteBenutzerByIndex(int stelle)
    {
        benutzerListe.remove(stelle);
    }
    
    /*
      Loescht einen Benutzer.
    
      @param bn     Benutzer, der geloescht werden soll.
    */
    public void deleteBenutzer(Benutzer bn)
    {
        int del = searchUser(bn);
        
        if(del > -1)
        {
            benutzerListe.remove(del);
        }
    }
    
    /*
      Gesamte Liste wird geloescht.
    */
    public void clearList(){
        
        benutzerListe.clear();
    }
    
    //---------------- Methoden zum finden eines Benutzers ---------------
    
    /*
      Prueft ob ein Benutzer bereits in der Liste vorhanden ist.
    
      @param bn     Benutzer, der gesucht wird.
      @return       true oder false
    */
    public boolean containsUser(Benutzer bn)
    {
        if (searchUser(bn) < 0) {
                return false;
        } else {
                return true;
        }
    }
    
    /*
      Sucht einen Benutzer in der Liste.
    
      @param bn     Der zu suchende Benutzer.
      @return       Index, an dem der Benutzer gefunden wurde, ansonsten -1.
    */
    private int searchUser(Benutzer bn)
    {
        for(int i = 0; i < benutzerListe.size(); i++)
        {
            if(bn.equals(benutzerListe.get(i))){
                return i;
            }
        }
        
        return -1;
    }
    
    /*
      Prueft anhand des Namens, ob ein Benutzer bereits in der Liste vorhanden ist.
    
      @param benutzerName   Name des Benutzers.
      @return               true oder false
    */
    public boolean containsUserName(String benutzerName) 
    {
        if (searchByName(benutzerName) < 0) {
                return false;
        } else {
                return true;
        }
    }
    
    /*
      Sucht einen Benutzer, anhand seines Names.
    
      @param benutzerName   Name des Benutzers.
      @return               Index, an dem der Benutzer gefunden wurde, ansonsten -1.
    */
    private int searchByName(String benutzerName)
    {
        
        for (int i = 0; i < benutzerListe.size(); i++) {
            
            if (
                benutzerListe.get(i).getEigenerBenutzerName().
                        equals(benutzerName)) 
            {
                    return i;
            }
        }
        
        return -1;  
    }
    
    /*
      Prueft anhand der IP, ob ein Benutzer bereits in der Liste vorhanden ist.
    
      @param ip   IP-Adresse des Benutzers.
      @return     true oder false
    */
    public boolean containsUserIP(String ip) 
    {
        if (searchByIp(ip) < 0) {
                return false;
        } else {
                return true;
        }
    }
    
    /*
      Sucht einen Benutzer, anhand seiner IP-Adresse.
    
      @param ip   IP-Adresse des Benutzers.
      @return     Index, an dem der Benutzer gefunden wurde, ansonsten -1.
    */
    private int searchByIp(String ip) 
    {
 
        for (int i = 0; i < benutzerListe.size(); i++) {
            
            if (benutzerListe.get(i).getEigeneLANIP().equals(ip)) {
                    return i;
            }
        }
        
        return -1;
    }
    
    /*
        @return Anzahl der Benutzer in der Liste.
    */
    public int getSize()
    {
        return benutzerListe.size();
    }

}

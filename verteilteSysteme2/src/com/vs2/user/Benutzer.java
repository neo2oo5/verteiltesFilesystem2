package com.vs2.user;

/*
VS2-Projekt
@Author: Alexander Mohr, Timo Zimmer
@Author: Andreas Paul, Lukas Becker
*/

public class Benutzer 
{
    private String eigeneLANIP = "";
    private String eigenePUBLICIP = "";
    private String eigenerBenutzerName = "";
    private int gruppenID = 0;
    private boolean istAdmin = false;
    
    private static final String DEFAULTHOSTNAME = "localhost";
    private static final String DEFAULTLANIP = "127.0.0.1";
    private static final String DEFAULTPUBLICIP = "0.0.0.0";
    private static final int DEFAULTGRUPPENID = 1;
    
    private String fehlermeldung = "";
    
    //Fehlermeldungskonstanten
    private static final String ERROR_NOUSERNAME = "Es wurde kein Benutzername uebergeben\n";
    private static final String ERROR_NOIP = "Es wurde keine LAN-IP uebergebenn\n";
    private static final String ERROR_GRUPPENID = "Wertebereich der Gruppen-ID muss zwischen 1 und 10 liegen!\n";
	
    
    //-----------------------Konstruktoren----------------------------------
    
    /*
    Default-Konstruktor
    */
    public Benutzer() throws BenutzerException {
            this(DEFAULTHOSTNAME, DEFAULTLANIP, DEFAULTPUBLICIP, DEFAULTGRUPPENID , false);
    }
    
    /*
    Voll-Konstruktor
    
    @param eigenerBenutzerName  Name des Benutzers
    @param eigeneLANIP          LAN-IP-Adresse des Benutzers
    @param gruppenID            Zugehoerige Gruppen-ID
    @param istAdmin             Erweiterte Rechte auf Anzeigetafeln
    */
    public Benutzer(String eigenerBenutzerName, String eigeneLANIP, String eigenePUBLICIP, int gruppenID, boolean istAdmin) throws BenutzerException
    {
        if (eigenerBenutzerName.trim().isEmpty() || eigenerBenutzerName == null) {
                fehlermeldung += ERROR_NOUSERNAME;
        }
        
        if (eigeneLANIP.trim().isEmpty() || eigeneLANIP == null) {
                fehlermeldung += ERROR_NOIP;
        }
        
        /* Extra keine Abfangmethode fuer eigenePUBLICIP erstellt, da Anwendung
        auch ohne Internetanschluss im LAN ohne Fehler funktionieren soll. */
           
        if( ( gruppenID <= 0 ) || ( gruppenID > 10 ) )
        {
            fehlermeldung += ERROR_GRUPPENID;
        }

        if(fehlermeldung.length() != 0) {
            throw new BenutzerException(fehlermeldung);
        }         
            this.eigenerBenutzerName = eigenerBenutzerName;
            this.eigeneLANIP = eigeneLANIP;
            this.gruppenID = gruppenID;
            this.istAdmin = istAdmin;
        
    }
    
    //---------------------(David) getter und setter-Methoden----------------
    
    /*
    R�ckgabe der eigenen IP-Adresse
    @return eigeneLANIP
    */
    public String getEigeneLANIP()
    {
        return this.eigeneLANIP;        
    }
        
    /*
    R�ckgabe des eigenen Benutzernamen
    @return eigenerBenutzername
    */
    public String getEigenerBenutzerName()
    {
        return this.eigenerBenutzerName;        
    }
    
    /*
    Setzen des eignen Benutzernames 
    @param eigenerBenutzerName  Name des Benutzers
    */   
    public void setEigenerBenutzerName(String eigenerBenutzerName) throws BenutzerException
    {
        if (eigenerBenutzerName.trim().isEmpty())
        {
              throw new BenutzerException(ERROR_NOUSERNAME);
        }
        this.eigenerBenutzerName = eigenerBenutzerName;
    }
    
    /*
    Setzen der mir zugeh�rigen Gruppen-ID
    @param GruppenID    Zugehoerige Gruppen-ID
    */   
    public void setGruppenID(int gruppenID) throws BenutzerException
    {
        
        if( ( gruppenID <= 0 ) || ( gruppenID > 10 ) )
        {
           throw new BenutzerException(ERROR_GRUPPENID);
        }
        
        this.gruppenID = gruppenID;
        
    }
    
    /*
    R�ckgabe der eigenen Gruppen-ID
    @return gruppenID
    */
    public int getGruppenID()
    {
        return this.gruppenID;
    }
    
    /*
    Setzen des Admin-Rechtes
    @param istAdmin Schlater des Rechtes
    */ 
    public void setAdmin(boolean istAdmin)
    {
        this.istAdmin = istAdmin;
    }
    
    /*
    R�ckgabe ob Benutzer Admin-Rechte hat
    @return istAdmin
    */
    public boolean getAdmin()
    {
        return istAdmin;
    }

}

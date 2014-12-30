package com.vs2.user;

/*
VS2-Projekt
@Author: Alexander Mohr, Timo Zimmer
@Author: Andreas Paul, Lukas Becker
*/

public class BenutzerException extends Exception{
    
    public BenutzerException(){
        super();
    }
    
    public BenutzerException(String meldung){
        super("Fehler Benutzerverwaltung:\n" + meldung);
    }
    
}
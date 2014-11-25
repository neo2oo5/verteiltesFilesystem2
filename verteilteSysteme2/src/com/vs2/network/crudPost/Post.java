package com.vs2.network.crudPost;

import java.lang.*;

public class Post {
	
    //-----------------------Instanz Variabeln----------------------
	private int		id;					//user  identifier
	private int  	gid;				//group identifier
	private int 	lastModified;		//timestamp
	private String 	inhalt;				
	private String 	author;				
	private String 	modifiedBy;	
	private String 	createTime;			//Erstelldatum timestamp
	private String  title;
	//--------------------------------------------------------------
	
    /** 
     * Konstruktor fuer Objekte der Klasse Post
     * 
     * @param  id     
     * @param  gid      
     * @param  lastModified           
     * @param  inhalt
     * @param  author
     * @param  modifiedBy
     * @param  createTime
     * @param  title            
     */
    public Post(int id, int gid, int lastModified, String inhalt,
    		String author, String modifiedBy, String createTime, String title) 
    { 
        //--------initialisiere Instanz Variabeln Argumenten--------       
        this.id 			= id;  
        this.gid 			= gid;     
        this.lastModified   = lastModified;            
        this.inhalt         = inhalt; 
        this.author 		= author;
        this.createTime 	= createTime;
        this.title 			= title;
    }
	
	//-----------------------Getter und Setetr----------------------
    /** 
     * Get-Methode fuer die User-ID
     * 
     * @return  
     */
	public int getId() {
		return id;
	}
	
    /** 
     * Get-Methode fuer die Gruppen-ID 
     * 
     * @return 
     */
	public int getGid() {
		return gid;
	}
	
    /** 
     * Get-Methode fuer das Datum, an dem zuletzt 
     * was am Post geaendert wurde 
     * 
     * @return  
     */
	public int getLastModified() {
		return lastModified;
	}
	
    /** 
     * Set-Methode fuer das Datum, an dem zuletzt 
     * was am Post geaendert wurde 
     * 
     * @param lastModified
     */
	public void setLastModified(int lastModified) {
		this.lastModified = lastModified;
	}
	
    /** 
     * Get-Methode fuer den Post-Inhalt 
     * 
     * @return  
     */
	public String getInhalt() {
		return inhalt;
	}
	
    /** 
     * Set-Methode fuer den Inhalt 
     * 
     * @param inhalt
     */
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	
    /** 
     * Get-Methode fuer den Post-Author 
     * 
     * @return 
     */
	public String getAuthor() {
		return author;
	}
	
    /** 
     * Get-Methode fuer die id die zueletz an den Post
     * was veraendert hat
     * 
     * @return  
     */
	public String getModifiedBy() {
		return modifiedBy;
	}
	
    /** 
     * Set-Methode fuer den die id die zueletz an den Post
     * was veraendert hat 
     * 
     * @param modifiedBy
     */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
    /** 
     * Get-Methode fuer das Erstelldatum 
     * 
     * @return  
     */
	public String getCreateTime() {
		return createTime;
	}
	
    /** 
     * Get-Methode fuer den Post-Titel 
     * 
     * @return  
     */
	public String getTitle() {
		return title;
	}
	
    /** 
     * Set-Methode fuer den Titel 
     * 
     * @param title
     */
	public void setTitle(String title) {
		this.title = title;
	}
	
}

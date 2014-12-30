package com.vs2.network.crudPost;

import java.lang.*;

public class Post {
	
    //-----------------------Instanz Variabeln----------------------
	private int		id;					//user  identifier
	private String	uip;	
	private int  	gid;				//group identifier
	private long 	lastModified;		//timestamp
	private String 	content;				
	private String 	author;				
	private String 	modifiedBy;	
	private long 	createTime;			//Erstelldatum timestamp
	private String  title;
	private boolean isPublic;

	//--------------------------------------------------------------
	
    /** 
     * Konstruktor fuer Objekte der Klasse Post
     * 
     * @param  id     
     * @param  gid      
     * @param  lastModified           
     * @param  content
     * @param  author
     * @param  modifiedBy
     * @param  createTime
     * @param  title            
     */
    public Post(int id, int gid, long lastModified, String content,
    		String author, String modifiedBy, long createTime, String title) 
    { 
        //--------initialisiere Instanz Variabeln Argumenten--------       
        this.id 			= id;  
        this.gid 			= gid;     
        this.lastModified   = lastModified;            
        this.content        = content; 
        this.author 		= author;
        this.createTime 	= createTime;
        this.title 			= title;
        this.isPublic		= false;

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
	public long getLastModified() {
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
     * Get-Methode fuer den Post-content 
     * 
     * @return  
     */
	public String getContent() {
		return content;
	}
	
    /** 
     * Set-Methode fuer den content 
     * 
     * @param content
     */
	public void setContent(String content) {
		this.content = content;
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
	public long getCreateTime() {
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
	
	public boolean getisPublic()
	{
		return isPublic;
	}
	
	public void isPublic(boolean ispublic)
	{
		this.isPublic = ispublic;
	}

	@Override
    public String toString() {
		String out = "";
		
		out += "ID:				" + this.getId() + "\n";
		out += "GID:			" + this.getGid() + "\n";
		out += "UIP:			" + this.getUIP() + "\n";
		out += "Author:			" + this.getAuthor() + "\n";
		out += "Title:			" + this.getTitle() + "\n";
		out += "Content:		" + this.getContent() + "\n";
		out += "Create Time:	" + this.getCreateTime() + "\n";
		out += "Modified By:	" + this.getModifiedBy() + "\n";
		out += "Last Modified:	" + this.getLastModified() + "\n";
		out += "isPublic:		" + this.getisPublic() + "\n";
		
		return out;
	}


	/**
	 * @return the uid
	 */
	public String getUIP() {
		return uip;
	}


	/**
	 * @param uid the uid to set
	 */
	private void setUIP(String uip) {
		this.uip = uip;
	}
	
}

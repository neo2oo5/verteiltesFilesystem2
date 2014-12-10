package com.vs2.network.crudPostWebservice;

import com.vs2.network.crudPost.*;

import java.lang.*;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class crudPostWebservice.
 */
public class crudPostWebservice {
	
	/** The p list. */
	private CrudPostList pList = CrudPostList.getInstance();

	
	
	
	
	/**
	 * Creates the.
	 *
	 * @param inhalt the inhalt
	 * @param author the author
	 * @param title the title
	 */
	public void create(String inhalt,
    		String author, String title)
	{
		pList.create(id, gid, inhalt, author, title);
	}
	
	/**
	 * Read.
	 *
	 * @param id the id
	 * @return the post
	 */
	public Post read(int id)
	{
		return pList.read(id);
	}
	
	/**
	 * Read all.
	 *
	 * @return the array list
	 */
	public ArrayList<Post> readAll()
	{
		return pList.getPostList();
	}
	
	/**
	 * Update.
	 *
	 * @param id the id
	 * @param gid the gid
	 * @param lastModified the last modified
	 * @param inhalt the inhalt
	 * @param author the author
	 * @param modifiedBy the modified by
	 * @param createTime the create time
	 * @param title the title
	 */
	public void update(int id, int gid, int lastModified, String inhalt,
    		String author, String modifiedBy, String createTime, String title)
	{
		
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(int id)
	{
		
	}
}

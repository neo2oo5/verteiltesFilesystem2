/**
 * 
 */
package com.vs2.network.crudPost;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudPostList.
 *
 * @author golli
 */
/**
 * @author xoxoxo
 * wird fuer Webservices gebraucht
 */

/**
 * @author xoxoxo
 *
 */
public class CrudPostList extends PostList {
	
	
	/**
	 * Funktion welche die einigartige Instanz generiert.
	 */
    private static class CrudPostListHolder
    {

        /** The instance. */
        private static CrudPostList INSTANCE = new CrudPostList();
    }

    /**
     * Lazy Loading mit unsynchronisierter getinstance()-Methode aber mit
     * synchronisierter Instanzierung und doppeltem Null-Check.
     *
     * @return CrudPostList Instanz zurueck
     */
    public static CrudPostList getInstance()
    {
        if (CrudPostListHolder.INSTANCE == null)
        {
            synchronized (CrudPostListHolder.INSTANCE)
            {
                if (CrudPostListHolder.INSTANCE == null)
                {
                    CrudPostListHolder.INSTANCE = new CrudPostList();
                }
            }
        }
        return CrudPostListHolder.INSTANCE;
    }
    
    /**
     * Gets the post list.
     *
     * @return the post list
     */
	public ArrayList<Post> readPostList()
	{
		return this.getAllElements();
	}
    
    /**
     * Gets the post list.
     *
     * @param gid the gid
     * @return the post list
     */
	public ArrayList<Post> readPostList(int gid)
	{
		return this.getElementByGroup(gid);
	}
	
	/**
	 * Creates the.
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
	public void create(int id, int gid, String inhalt,
    		String author, String title)
	{
		add(new Post(id, gid, 0, inhalt, author, "NOBODY", getTimestamp(), title));
	}
	


	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(int id)
	{
		delete(id , "id");
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @param specifier the specifier
	 */
	public void delete(int id, String specifier)
	{
		if(specifier == "id")
		{
			removeById(id);
		}
		else if(specifier == "gid")
		{
			removeByGid(id);
		}
	}
	
	private long getTimestamp()
	{
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new Timestamp(calendar.getTime().getTime());
		
		return currentTimestamp.getTime();
		
	}
	
}

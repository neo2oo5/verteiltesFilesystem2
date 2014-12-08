/**
 * 
 */
package com.vs2.network.crudPost;

import java.util.ArrayList;

/**
 * @author golli
 *
 */
/**
 * @author xoxoxo
 * wird fuer Webservices gebraucht
 */

public class CrudPostList extends PostList {
	
	
	/**
     * Funktion welche die einigartige Instanz generiert
     */
    private static class CrudPostListHolder
    {

        private static CrudPostList INSTANCE = new CrudPostList();
    }

    /**
     * Lazy Loading mit unsynchronisierter getinstance()-Methode aber mit
     * synchronisierter Instanzierung und doppeltem Null-Check
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
     * 
     * @return
     */
	public ArrayList<Post> getPostList()
	{
		return this.PostArray;
	}
	
	public int getCount()
	{
		return getCount();
	}
	
	public void create(int id, int gid, int lastModified, String inhalt,
    		String author, String modifiedBy, String createTime, String title)
	{
		add(new Post(id, gid, lastModified, inhalt, author, modifiedBy, createTime, title));
	}
	
	public void add(Post e)
	{
		add(e);
	}
	
	public void read(int id)
	{
		read(id, "id");
	}
	
	public void read(int id, String specifier)
	{
		if(specifier == "id")
		{
			searchById(id);
		}
		else if(specifier == "gid")
		{
			searchByGid(id);
		}
	}
	
	public void update(Post e)
	{
		
	}
	
	/**
	 * 
	 */
	public void delete(int id)
	{
		delete(id , "id");
	}
	
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
	
}

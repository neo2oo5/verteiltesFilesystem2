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
		return this.PostArray.size();
	}
	
	public void create(Post el)
	{
		PostArray.add(el);
	}
	
	public void read()
	{
		
	}
	
	public void update()
	{
		
	}
	
	/**
	 * 
	 */
	public void delete()
	{
		
	}
	
}

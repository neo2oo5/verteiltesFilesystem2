/**
 * 
 */
package com.vs2.network.crudPost;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class PostList.
 *
 * @author golli
 */
abstract class PostList {
	
	/** The Post array. */
	private ArrayList<Post> PostArray = new ArrayList<Post>();
	private int lastId = 0;

	/**
	 * Search by id.
	 *
	 * @param id the id
	 * @return the int
	 */
	public int searchById(int id)
	{
		int ret = -1;
		for(Post post: PostArray)
		{
			if(post.getId() == id)
			{
				ret = PostArray.indexOf(post);
			}
		}	
		return ret;
	}
	
	/**
	 * Search by gid.
	 *
	 * @param gid the gid
	 * @return the int
	 */
	public int searchByGid(int gid)
	{
		int ret = -1;
		for(Post post: PostArray)
		{
			if(post.getGid() == gid)
			{
				ret = PostArray.indexOf(post);
			}
		}	
		return ret;
	}
	
	/**
	 * Adds the.
	 *
	 * @param element the element
	 */
	public void add(Post element)
	{
		if(PostArray.add(element))
		{
			this.lastId = element.getId();
		}
	}
	
	/**
	 * Update.
	 *
	 * @param element the element
	 * @param index the index
	 */
	protected void update(Post element)
	{
		PostArray.add(this.searchById(element.getId()), element);
	}
	
	/**
	 * Removes the by id.
	 *
	 * @param id the id
	 */
	protected void removeById(int id)
	{
		PostArray.remove(this.searchById(id));
	}
	
	/**
	 * Removes the by gid.
	 *
	 * @param id the id
	 */
	protected void removeByGid(int id)
	{
		PostArray.remove(this.searchByGid(id));
	}
	
	/**
	 * Gets the element.
	 *
	 * @param index the index
	 * @return the element
	 */
	public Post getElement(int index)
	{
		return	PostArray.get(index);
	}
	
	
	protected ArrayList<Post> getAllElements()
	{
		return	PostArray;
	}
	
	protected ArrayList<Post> getElementByGroup(int gid)
	{
		ArrayList<Post> tmp = new ArrayList<Post>();
		
		for(Post el : PostArray)
		{
			if(el.getGid() == gid)
			{
				tmp.add(el);
			}
			else if(el.getisPublic() == true)
			{
				tmp.add(el);
			}
			
			
		}
		
		return tmp;
		
	}
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	protected int getSize()
	{
		return PostArray.size();
	}
	
	protected int getLastId()
	{
		this.lastId++;
		return this.lastId;
	}
	
	public void mergeList(ArrayList<Post> updateList)
	{
		for(Post e: updateList)
		{
			if(e.getLastModified() == 0)
			{
				
			}
		}
	}
	
	public String toString()
	{
		String out = "";
		int count  = 1;  
		
		for(Post e: PostArray)
		{
			out += "Element: " + count + "\n";
			out += "<---------------------------------------------->\n";
			out += e.toString();
			out += e.hashCode();
			out += "\n\n\n";
			
			count++;
			
		}
		
		
		return out;
	}

	
	
}



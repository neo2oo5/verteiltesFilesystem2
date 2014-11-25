/**
 * 
 */
package com.vs2.network.crudPost;

import java.util.ArrayList;

/**
 * @author golli
 *
 */
abstract class PostList {
	
	ArrayList<Post> PostArray = new ArrayList<Post>();

	/**
	 * @param id
	 * @return
	 */
	protected int searchById(int id)
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
	
	protected int searchByGid(int gid)
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
	
	protected void add(Post element)
	{
		PostArray.add(element);
	}
	
	/**
	 * @param element
	 */
	protected void update(Post element, int index)
	{
		PostArray.add(index, element);
	}
	
	/**
	 * @param id
	 */
	protected void removeById(int id)
	{
		PostArray.remove(this.searchById(id));
	}
	
	/**
	 * @return
	 */
	protected Post getElement(int index)
	{
		return	PostArray.get(index);
	}

	
	
}



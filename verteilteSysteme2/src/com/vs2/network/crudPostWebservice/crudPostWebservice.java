package com.vs2.network.crudPostWebservice;

import com.vs2.network.crudPost.*;

public class crudPostWebservice {
	
	private CrudPostList pList = null;
	
	
	public crudPostWebservice()
	{
		pList = CrudPostList.getInstance();
	}
	
	
	public void create(int id, int gid, int lastModified, String inhalt,
    		String author, String modifiedBy, String createTime, String title)
	{
		
	}
	
	public Post read(int id)
	{
		return pList.read(id);
	}
	
	public ArrayList<Post> readAll()
	{
		
	}
	
	public void update(int id, int gid, int lastModified, String inhalt,
    		String author, String modifiedBy, String createTime, String title)
	{
		
	}
	
	public void delete(int id)
	{
		
	}
}

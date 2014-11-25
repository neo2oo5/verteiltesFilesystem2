package com.vs2.network.PostWebservice;


import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

import com.vs2.network.crudPost.*;


import java.lang.String;

public class PostWallWebservices {
	
	private CrudPostList pList = null;
	
	
	public PostWallWebservices()
	{
		pList = CrudPostList.getInstance();
		Post post = new Post( 1, 2, 4,  "testinhalt", "kevin",  "geändert durch mich",  "vorgestern", "test title");

		
		pList.create(post);
	}
	
	
	public OMElement getPostList()
	{
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace ns = fac.createOMNamespace("http://PostWebservice.network.vs2.com", "PWW");
		
		OMElement responseEl = fac.createOMElement("getPostList", ns);
		//responseEl.setText(String.valueOf(pList.getCount()));
		
		int x = 0;
		for(Post post: pList.getPostList())
		{
			OMElement postEl = fac.createOMElement("post", null, responseEl);
			postEl.addAttribute(fac.createOMAttribute("index", null, String.valueOf(x)));
			
			OMElement id = fac.createOMElement("id", null, postEl);
			id.setText(String.valueOf(post.getId()));
			
			OMElement gid = fac.createOMElement("gid", null, postEl);
			gid.setText(String.valueOf(post.getGid()));
			
			OMElement lastModified = fac.createOMElement("lastModified", null, postEl);
			lastModified.setText(String.valueOf(post.getLastModified()));
			
			OMElement content = fac.createOMElement("content", null, postEl);
			content.setText(String.valueOf(post.getInhalt()));
			
			OMElement author = fac.createOMElement("author", null, postEl);
			author.setText(String.valueOf(post.getAuthor()));
			
			OMElement modifiedBy = fac.createOMElement("modifiedBy", null, postEl);
			modifiedBy.setText(String.valueOf(post.getModifiedBy()));
			
			OMElement createTime = fac.createOMElement("createTime", null, postEl);
			createTime.setText(String.valueOf(post.getCreateTime()));
			
			OMElement title = fac.createOMElement("title", null, postEl);
			title.setText(String.valueOf(post.getTitle()));
			
			
			postEl.addChild(id);
			postEl.addChild(gid);
			postEl.addChild(lastModified);
			postEl.addChild(content);
			postEl.addChild(author);
			postEl.addChild(modifiedBy);
			postEl.addChild(createTime);
			postEl.addChild(title);
		
			x++;
		}
		
		
		return responseEl;
	}
}

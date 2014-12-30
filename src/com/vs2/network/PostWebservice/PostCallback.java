package com.vs2.network.PostWebservice;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMContainer;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.util.*;

public  class PostCallback implements AxisCallback {
	private boolean complete;
	

	
	public synchronized boolean isComplete()
	{
		return complete;
	}
	
	public synchronized void setComplete(boolean complete)
	{
		this.complete = complete;
	}
	
	
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}
	
	public void onComplete(AxisCallback result) {
		// TODO Auto-generated method stub
		
		
	}

	
	public void onFault(MessageContext messageContext) {
		// TODO Auto-generated method stub
		messageContext.getFailureReason().printStackTrace(); 
	}

	
	public void onMessage(MessageContext messageContext) {
		// TODO Auto-generated method stub
		String id 			= "";
		String gid 			= "";
		String lastModified = "";
		String content		= "";
		String author 		= "";
		String modifiedBy	= "";
		String createTime	= "";
		String title		= "";
		
		
		
		OMElement fac = messageContext.getEnvelope().getBody().getFirstElement();
		OMElement method = fac.getFirstElement();
		
		OMElement test= method.getFirstElement();
		
		
		
		Iterator posts = test.getChildren();
		
		
		      
		 while(posts.hasNext())
		{
			 OMElement post = (OMElement) posts.next();

			 //Iterator postel = post.getChildElements();
			//System.out.println(post.getFirstChildWithName(new QName("author")).getText() +  "\n");
		
			
			id 			= post.getFirstChildWithName(new QName("id")).getText();
			gid 		= post.getFirstChildWithName(new QName("gid")).getText();
			lastModified = post.getFirstChildWithName(new QName("lastModified")).getText();
			content		= post.getFirstChildWithName(new QName("content")).getText();
			author 		= String.valueOf(post.getFirstChildWithName(new QName("author")).getText());
			modifiedBy	= post.getFirstChildWithName(new QName("modfiedBy")).getText();
			createTime	= post.getFirstChildWithName(new QName("createTime")).getText();
			title		= post.getFirstChildWithName(new QName("title")).getText();
			
			
			//System.out.println(author);
		}
		    
		 //hier kommt der postlist sync hin
		 
		 
		
	}

	
	public void onError(Exception e) {
		// TODO Auto-generated method stub
		System.err.println(e.getMessage()); 
		
	}
}

package com.vs2.network.PostWebservice;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
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
		OMElement doc = messageContext.getEnvelope().getBody().getFirstElement();
		
		OMElement method = doc.getFirstElement();
		
		Iterator posts = method.getFirstElement().getChildElements();
		
		//System.out.print(post.getText() + "\n");
		      
		 while(posts.hasNext())
		{
			OMElement post = (OMElement) posts.next();
			Iterator postel = post.getChildElements();
			
			String id 			= post.getFirstChildWithName(new QName("id")).getText();
			String gid 			= post.getFirstChildWithName(new QName("gid")).getText();
			String lastModified = post.getFirstChildWithName(new QName("lastModified")).getText();
			String content		= post.getFirstChildWithName(new QName("content")).getText();
			String author 		= post.getFirstChildWithName(new QName("author")).getText();
			String modifiedBy	= post.getFirstChildWithName(new QName("modfiedBy")).getText();
			String createTime	= post.getFirstChildWithName(new QName("createTime")).getText();
			String title		= post.getFirstChildWithName(new QName("title")).getText();
			

		}
		    
		 //hier kommt der postlist sync hin
		 
		
	}

	
	public void onError(Exception e) {
		// TODO Auto-generated method stub
		System.err.println(e.getMessage()); 
		
	}
}

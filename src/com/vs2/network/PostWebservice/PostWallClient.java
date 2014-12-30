/**
 * 
 */
package com.vs2.network.PostWebservice;

import java.lang.*;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.*;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.MessageContext;
import org.apache.axiom.soap.SOAPBody;
//import org.apache.axis2.databinding.types.soapencoding.QName;


import com.vs2.network.crudPost.CrudPostList;
import com.vs2.network.crudPost.Post;


// TODO: Auto-generated Javadoc
/**
 * The Class PostWallClient.
 *
 * @author xoxoxo
 */
public class PostWallClient {
	
	/** The p list. */
	private static CrudPostList pList = CrudPostList.getInstance();
	
	/** The target epr. */
	private static EndpointReference targetEPR = 
	        new EndpointReference("http://localhost:8080/verteilteSysteme2/services/PostWallWebservices");
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
			
		//main nur fuer Tests
		doSync();

			
    }
	
	/**
	 * Do sync.
	 */
	public static void doSync()
	{
		pList.create(2, 3, "test inhalt2", "lisa", "test title");
		pList.create(1, 2, "test inhalt", "kevin", "title");
		pList.create(2, 3, "test inhalt2", "lisa", "test title");
		
        try {
            OMElement getPostListPayload = creategetPostListPayload();
            
            Options options = new Options();
            options.setTo(targetEPR);
          //  options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
            options.setAction("urn:getPostList");

            ServiceClient sender = new ServiceClient();
            sender.setOptions(options);

       
             
           
            sender.sendReceiveNonBlocking(getPostListPayload, new PostCallback());
            System.out.println("send the message");
            
            while (true) { 
            	Thread.sleep(100); 
            } 
	

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	

	/**
	 * Createget post list payload.
	 *
	 * @return the OM element
	 */
	private static OMElement creategetPostListPayload()
	{
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace ns = fac.createOMNamespace("http://PostWebservice.network.vs2.com", "PWW");
		
		OMElement requestEl = fac.createOMElement("getPostListRequest", ns);
		

		int x = 0;
		for(Post post: pList.readPostList())
		{
			OMElement postEl = fac.createOMElement("post", null, requestEl);
			postEl.addAttribute(fac.createOMAttribute("index", null, String.valueOf(x)));
			
			OMElement id = fac.createOMElement("id", null, postEl);
			id.setText(String.valueOf(post.getId()));
			
			OMElement gid = fac.createOMElement("gid", null, postEl);
			gid.setText(String.valueOf(post.getGid()));
			
			OMElement lastModified = fac.createOMElement("lastModified", null, postEl);
			lastModified.setText(String.valueOf(post.getLastModified()));
			
			OMElement createTime = fac.createOMElement("createTime", null, postEl);
			createTime.setText(String.valueOf(post.getCreateTime()));
			

			
			postEl.addChild(id);
			postEl.addChild(gid);
			postEl.addChild(lastModified);
			postEl.addChild(createTime);
			x++;
		}
		
		
		return requestEl;
		
		
	}
}



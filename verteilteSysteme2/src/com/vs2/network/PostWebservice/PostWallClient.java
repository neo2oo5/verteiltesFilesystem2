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
import org.apache.axis2.databinding.types.soapencoding.QName;
import org.apache.axiom.soap.SOAPBody; 

/**
 * @author xoxoxo
 *
 */
public class PostWallClient {
	
	private static EndpointReference targetEPR = 
	        new EndpointReference("http://localhost:8080/vs2/services/PostWallWebservices");
	
	
	public static void main(String[] args) {
        try {
            OMElement getPostListPayload = creategetPostListPayload();
            
            Options options = new Options();
            options.setTo(targetEPR);
            options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
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
	

	public static OMElement creategetPostListPayload()
	{
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace ns = fac.createOMNamespace("http://PostWebservice.network.vs2.com", "PWW");
		
		OMElement getPostList = fac.createOMElement("getPostList", ns);
		
		//OMElement count = fac.createOMElement("id", ns);
		
		return getPostList;
	}
}



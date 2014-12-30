<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vs2.user.*,java.net.*,com.vs2.network.*"%>

<jsp:include page="/soapview-web/include/header-inc.jsp" />

<%
	
	if(	request.getParameter("sent") != null && 
		request.getParameter("role") != null &&
		request.getParameter("ip") != null &&
		request.getParameter("userName") != null && request.getParameter("sent").equals("Senden"))
	{
	//	out.print(request.getParameter("userName"));
	out.print(request.getParameter("ip"));
		BenutzerListe.addBenutzer(new Benutzer(request.getParameter("userName"), 
										request.getParameter("ip"),
										"",
										1,
										Boolean.valueOf(request.getParameter("role"))
										));

	%> <jsp:forward page="soapview-web/defaultpage.jsp" />  <%	
		
 } %>

	 
	<form action="login" method="POST">
	  	<table border="1" align="center" width="40%">
	  		
		        <tr>
		          <td>
		            <center> <b>SOAP LOGIN</b><br>
		          
		             <br>Username:
		                <input type="text" name="userName" size="25" class="" />
		                <input type="submit" name="sent" value="Senden" />
		              
		           </center>
		            <br>
		          </td>
		          <td width="30%">
		            
		             	<input type="radio" name="role" value="true">ADMIN</input>
		                <br>
		                <input type="radio" name="role" value="false">USER</input>
		                <br>
		                
		                <%
						for(String ad : getIPv4Address.getIPv4Address())
						{ %>
						<input type="radio" name="ip" value="<%=ad %>">	<%=ad %> </input> <br>
					<%	} %>
		                
		            
		          </td>
		        </tr>
	        
	    </table>
	</form>

<jsp:include page="/soapview-web/include/footer-inc.jsp" />


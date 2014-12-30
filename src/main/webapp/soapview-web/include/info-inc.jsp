<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vs2.user.*,com.vs2.network.*"%>


<div id="info" class="white-popup">
    	<div id="info_inner">   	
    	
    		
    	
	    	<%
	    		Benutzer thatsme = BenutzerListe.getLocalUser();
	    	
	    		if(thatsme != null){
	    	%>
	    	<br>
	    	<br>
	    	IP: <%=thatsme.getEigeneLANIP() %><br>
	    	<br>
	    	Benutzername: <%=thatsme.getEigenerBenutzerName() %><br>
	    	<br>
	    	Gruppe: <%=thatsme.getGruppenID() %><br>
	    	<br>
	    	Admin: <%=thatsme.getAdmin() %>
	    	
	    	<% } %>
	    
    	</div>	
    </div>
    
    

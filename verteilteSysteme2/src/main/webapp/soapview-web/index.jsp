<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="com.vs2.user.*,java.net.*,com.vs2.network.*"%>




<%!


	public String getPage()
	{
		try {
			if(BenutzerListe.getLocalUser() != null)
			{ 
				return "defaultpage.jsp";
			}
			else
			{ 
				return "login.jsp";
		 	}
		} catch (Exception e) {
             
            return "error.jsp?param1=" + e.getMessage();
        }
		
	}

%>

<jsp:forward page="<%= getPage() %>" />




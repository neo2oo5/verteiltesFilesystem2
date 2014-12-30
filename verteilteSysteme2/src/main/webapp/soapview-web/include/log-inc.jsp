<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.vs2.origin.*"%>
				 
    <div id="log" class="white-popup">
    	<div id="log_inner">   	
	    	<%
	    		Output outp = Output.getInstance();
	    	
	    		out.print(outp.toString());
	    	
	    	
	    	%>
    	</div>	
    </div>
    
    
    

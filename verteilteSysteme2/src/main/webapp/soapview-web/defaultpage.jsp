<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.vs2.user.*,java.net.*,
				 com.vs2.network.crudPost.*,
				 com.vs2.origin.*,java.util.*,
				 java.sql.*,
				 java.util.Date,
				 java.text.SimpleDateFormat"%>
				 
<jsp:include page="/soapview-web/include/header-inc.jsp" />
			
				 
	<%!
	
	private String getFormattedDate(long input){
        Date date = new Date(input);
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss z");
        sdf.setCalendar(cal);
        cal.setTime(date);
        return sdf.format(date);
 
    }
	
	
	
	%>

	<table border="1"  id="content">
      <tbody>
        <tr>
          <td width="20%">
          
          	<div id="gHead">Gruppen</div>
            
            <form action="input_radio.htm">
              
              <ul id="gBody">
              		<li><input type="radio" name="GRP" value="grp1">Gruppe 1</input></li>
              		<li><input type="radio" name="GRP" value="grp1">Gruppe 2</input></li>
              		<li><input type="radio" name="GRP" value="grp1">Gruppe 3</input></li>
              		<li><input type="radio" name="GRP" value="grp1">Gruppe 4</input></li>
              
              </ul>
              
              
  			   <input type="button" style="height: 30px; width: 100px;" value="Login" onclick="logingrp()">
            </form>
          </td>
          <td>
            <div id="mainContent">Nachrichten
              <br>
              <br>
              <a href="#"  class="menuButtons logb" rel="log" ><button>Log</button></a>
              <a href="#"  class="menuButtons infob" rel="info" ><button>Info</button></a>
              
                <p>
                  <div name="user_eingabe" id="msgWindow">
                  
                  <%
                  
                   CrudPostList pList = CrudPostList.getInstance();
                   ArrayList<Post>  posts = pList.readPostList();
              		int i = 0;
              		for(Post p: posts)
              		{ 
              			i++;
              		%>
              		
              		
              			<div  class="post">
              		
	              			<div class="pid_<%=i%> gid" rel="<%=p.getGid() %>">Gruppe: <%=p.getGid() %></div>
	              			<div class="pid_<%=i%> public" rel="<%=p.getisPublic() %>">&Ouml;ffentlich: <%=p.getisPublic() %></div>
	              		
	              			<div class="pid_<%=i%> author" rel="<%=p.getAuthor() %>">Author: <%=p.getAuthor() %></div>
	              			<div class="pid_<%=i%> ctime" rel="<%=p.getCreateTime()%>">Erstellungsdatum: <%= getFormattedDate( p.getCreateTime() ) %></div>
	              			
	              			<% if(p.getModifiedBy() != null){ %>
	              			<div class="pid_<%=i%> mauthor" rel="<%=p.getModifiedBy() %>">Bearbeitet von: <%=p.getModifiedBy() %></div>
	              			<div class="pid_<%=i%> mtime" rel="<%=p.getLastModified() %>">um: <%= getFormattedDate( p.getLastModified() ) %></div>
	              			<% } %>
	              			
	              			<div class="pid_<%=i%> title" rel="<%=p.getTitle() %>">Titel: <%=p.getTitle() %></div>
	              			<div class="pid_<%=i%> content" rel="<%=p.getContent() %>">Nachricht: <%=p.getContent() %></div>
	              			
	              			<a href="CrudPostServlet?action1=do&id=<%=p.getId()%>">Ver&ouml;ffentlichen</a>
	              			<a href="#" name="<%=i%>" rel="input" class="edit menuButtons">Bearbeiten</a>
	              			<a href="CrudPostServlet?action3=do&id=<%=p.getId()%>">Löschen</a>
	              			
							<hr>	              			
	              			<br>
	              			<br>
	              			<br>
              			
              			</div>
              	<%	}   %>
                  
                  
                  
                  
                  </div>
                  
                  
                  <a href="#"  class="menuButtons create" rel="input" ><button>Anzeige verfassen</button></a>
                  <br>
                  
              
            </div>
          </td>
        </tr>
      </tbody>
    </table>
    
    
    
    <jsp:include page="/soapview-web/include/log-inc.jsp" />
    
    <jsp:include page="/soapview-web/include/info-inc.jsp" />

	<jsp:include page="/soapview-web/include/inputform-inc.jsp" />

<jsp:include page="/soapview-web/include/footer-inc.jsp" />


<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vs2.user.*,com.vs2.network.*"%>


<div id="input" class="white-popup">
    	<div class="popup_inner">   	
    	
    		
    	
	    	<form id="inputForm" action="/" method="post">
	    	
	    		<!-- wird mit js gefuellt -->
	    		
	    	</form>
	    
    	</div>	
    </div>
    
    <script>
    
 
    
    
    var opt = {
    		type: 'element',
    		caption: false
    };
    
    opt.api = {
	    start: function(obj){},
	    beginLoad: function(obj){},
	    afterLoad: function(obj){
	    	
			$("#inputForm").submit(function( event ) {
							
							// Stop form from submitting normally
							event.preventDefault();
							// Get some values from elements on the page:
							var gid = $( "#gid" ).attr("value"),
								id = $( "#id" ).attr("value"),
								title = $( "#title" ).attr("value"),
								msg = $( "#msg" ).attr("value"),
								url = $( "#url" ).attr("value");
							alert(id);
							// Send the data using post
							var posting = $.post( url, { "gid": gid, "id": id } );
							// Put the results in a div
							posting.done(function( data ) {
								
								alert(data);
							});
		
			});
	    	
	    	tinymce.init({
	    		mode : "textareas",
				width: "100%",
				plugins : "pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template",
				
				
				// Theme options
				//bold,italic,underline,strikethrough,|,
				theme_advanced_buttons1: "bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,formatselect,fontselect,fontsizeselect",
				theme_advanced_buttons2: "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
				theme_advanced_buttons3: "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
				theme_advanced_buttons4: "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak",
				theme_advanced_toolbar_location: "top",
				theme_advanced_toolbar_align: "left",
				theme_advanced_statusbar_location: "bottom",
				theme_advanced_resizing: false,
				formats: {
				underline: {inline: 'u', exact: true}
				} 
			});
	    	
	    	
	    },
	    closed: function(obj){
	    	
	    	
	    }
    }
    $('.edit').divbox(opt);
    $('.create').divbox(opt);
  </script>
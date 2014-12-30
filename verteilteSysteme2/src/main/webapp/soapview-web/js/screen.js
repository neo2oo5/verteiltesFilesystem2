var  content = "";


$(document).ready(function() {
	content = "";
	
	

	$(".create").click(function(){
		
		
		
		$("#inputForm").html('<input type="hidden" id="id" name="id" value="0"/> \
    			<input type="hidden" id="gid" name="gid" value="0"/> \
				<input type="hidden" id="url" name="url" value="CrudPostServlet?action3=do" /> \
	    		<div id="inputTitle">Title:</div> \
	    		<input type="text" id="title" name="title"  /> \
	    		<div id="inputMsg">Nachricht:</div>\
	    		<textarea name="msg" id="msg" ></textarea>\
	    		<br>\
				<input type="submit" value="Absenden">');
		
	});
	
	
	$(".edit").click(function callMe(event){

		var  gid 		= $(".pid_" + $(this).attr('name') + ".gid").attr('rel');
		var  isPublic 	= $(".pid_" + $(this).attr('name') + ".public").attr('rel');
		var  author 	= $(".pid_" + $(this).attr('name') + ".author").attr('rel');
		var  ctime 		= $(".pid_" + $(this).attr('name') + ".ctime").attr('rel');
		var  mauthor 	= $(".pid_" + $(this).attr('name') + ".mauthor").attr('rel');
		var  mtime 		= $(".pid_" + $(this).attr('name') + ".mtime").attr('rel');
		var  title 		= $(".pid_" + $(this).attr('name') + ".title").attr('rel');
			 content	= $(".pid_" + $(this).attr('name') + ".content").attr('rel');
				
		
	
		
		
		$("#inputForm").html('<input type="hidden" id="id" name="id" /> \
    			<input type="hidden" id="gid" name="gid" /> \
				<input type="hidden" id="url" name="url" value="CrudPostServlet?action4=do" /> \
	    		<div id="inputTitle">Title:</div> \
	    		<input type="text" name="title" id="title" value="'+title+'" /> \
	    		<div id="inputMsg">Nachricht:</div>\
	    		<textarea name="msg" id="msg" >'+content+'</textarea>\
	    		<br>\
	    		<input type="submit" value="Absenden">');
		
		
	});
	
	
	
	

});



function customTinyMceInit(inst) {
    tinymce.activeEditor.setContent(content);
}
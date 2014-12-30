package com.vs2.network;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vs2.network.crudPost.CrudPostList;
import com.vs2.network.crudPost.Post;
import com.vs2.origin.Output;
import com.vs2.user.Benutzer;
import com.vs2.user.BenutzerListe;

/**
 * Servlet implementation class CrudPostServlet
 */
public class CrudPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CrudPostList pList = CrudPostList.getInstance();
	private Output		outp	= Output.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	    
		
		
		if (request.getParameter("action1") != null &&
			request.getParameter("id") != null) {
			
		    //publish post
			int			id		= Integer.parseInt(request.getParameter("id"));
			Benutzer 	thatsme = BenutzerListe.getLocalUser();
			Post		post	= pList.getElement(pList.searchById(id));
			
			if(thatsme.getAdmin())
			{
				pList.delete(id);
				outp.print("Post mit der ID " + id + "wurde veroeffentlicht");
			}
			else
			{
				outp.print("Post mit der ID " + id + "konnte nicht veroeffentlicht werden. Da sie kein Admin sind");
			}
		}
		else if (request.getParameter("action2") != null &&
				 request.getParameter("id") != null) {
		    	// delete post
			
			int			id		= Integer.parseInt(request.getParameter("id"));
			Benutzer 	thatsme = BenutzerListe.getLocalUser();
			Post		post	= pList.getElement(pList.searchById(id));
			
			if(thatsme.getEigeneLANIP() == post.getUIP())
			{
				pList.delete(id);
				outp.print("Post mit der ID " + id + "wurde geloescht");
			}
			else if(thatsme.getAdmin())
			{
				pList.delete(id);
				outp.print("Post mit der ID " + id + "wurde geloescht");
			}
			else
			{
				outp.print("Post mit der ID " + id + "konnte nicht gelöscht werden. Da es nicht ihr Post ist und sie kein Admin sind");
			}
		}else if (request.getParameter("action3") != null &&
				 request.getParameter("id") != null) {
			out.print(request.getParameter("id"));
		}
		else if (request.getParameter("action4") != null &&
				 request.getParameter("id") != null) {
			out.print(request.getParameter("id"));
		}
		
		/*
		try 
		{
		  request.getRequestDispatcher("/").forward(request, response);
		}
		catch (ServletException e)
		{
		  e.printStackTrace();
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package com.yenterprise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yenterprise.model.PostBean;
import com.yenterprise.svc.PostService;

/**
 * Servlet implementation class PostDeleteServlet
 */
@WebServlet("/delete")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService service;  


    public PostDeleteServlet() {
    	service = new PostService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostBean curPost = new PostBean();
		HttpSession session = request.getSession(false);
		
		if (session.getAttribute("user")!=null){
		
			try{
				int requestedPostId = Integer.parseInt(request.getParameter("postId"));
			
				boolean result=service.deletePost(requestedPostId);
				//should redirect errors if there are any . . .
		
			}catch (Exception ex){
				//if there is not a post id set, send  to the main page
				
				response.sendRedirect("./posts");
			}
		}	
			//after the delete, send back to the main page as well
			response.sendRedirect("./posts");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

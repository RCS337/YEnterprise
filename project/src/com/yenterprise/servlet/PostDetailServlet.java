package com.yenterprise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yenterprise.model.PostBean;
import com.yenterprise.svc.PostService;

/**
 * Servlet implementation class PostDetailServlet
 */
@WebServlet("/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService service;
	
	
	
    public PostDetailServlet() {
       service = new PostService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostBean curPost = new PostBean();
		try{
		int requestedPostId = Integer.parseInt(request.getParameter("postId"));
		
		curPost=service.getPost(requestedPostId);
		request.setAttribute("post",  curPost);
		
		request.getRequestDispatcher("WEB-INF/jsp/detail.jsp").forward(request,  response);
		}catch (Exception ex){
			//if there is not a post id set send  to the main page
			
			response.sendRedirect("./posts");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

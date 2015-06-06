package com.yenterprise.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yenterprise.svc.PostService;

/**
 * Servlet implementation class PostsServlet
 */
@WebServlet(description = "Product Comments and Observation posts", urlPatterns = { "/posts" })
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService service;
       
  
    public PostsServlet() {
        //super();
    	 service = new PostService();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("post", "active");
		request.setAttribute("posts",  service.getAllPosts());
		request.getRequestDispatcher("WEB-INF/jsp/landing.jsp").forward(request,  response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}






}
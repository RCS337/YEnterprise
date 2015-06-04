package com.yenterprise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yenterprise.model.PostBean;
import com.yenterprise.svc.PostService;

/**
 * Servlet implementation class PostsServlet
 */
@WebServlet(description = "Product Comments and Observation posts", urlPatterns = { "/a" })
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
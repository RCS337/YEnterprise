package com.yenterprise.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yenterprise.model.PostBean;
import com.yenterprise.svc.PostService;

/**
 * Servlet implementation class PostEditServlet
 */
@WebServlet("/edit")
public class PostEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService service;
	
    public PostEditServlet() {
    	service = new PostService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostBean curPost = new PostBean();
		HttpSession session = request.getSession(false);
		
		if (session.getAttribute("user")!=null){
		
			try{
			int requestedPostId = Integer.parseInt(request.getParameter("postId"));
			
			curPost=service.getPost(requestedPostId);
			request.setAttribute("post",  curPost);
			
			request.getRequestDispatcher("WEB-INF/jsp/edit.jsp").forward(request,  response);
			}catch (Exception ex){
				//if there is not a post id set send  to the main page
				
				response.sendRedirect("./posts");
			}
		}else{
			response.sendRedirect("./posts");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//need to add check to this code 1. make sure that it is coming from edit, that the params are set, user logged in via a session
		HttpSession session = request.getSession(false);
		
		if(request.getParameter("postId")!=null && session.getAttribute("user")!=null){
			
			
			Date date=new Date();
			PostBean editPost = new PostBean();
			editPost.setPostId(Integer.parseInt(request.getParameter("postId")));
			editPost.setTitle(request.getParameter("title"));
			editPost.setShortDesc(request.getParameter("shortComment"));
			editPost.setLongDesc(request.getParameter("detailComment"));
			editPost.setUpdateDate(new java.sql.Timestamp(date.getTime()));
			
			editPost.setUpdatedBy("test user"); //need to pull this from the session 
			
			boolean success = service.updatePost(editPost);
		
			
			if(success){
				response.sendRedirect("./detail?postId="+editPost.getPostId());

				} else {
					request.setAttribute("errorMessage",  "System error");
					doGet(request, response);
				}
		}
		else{

			response.sendRedirect("./posts");
		}
		
		
	}

}

package com.yenterprise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yenterprise.model.PostBean;
import com.yenterprise.model.UserBean;
import com.yenterprise.svc.PostService;


@WebServlet("/PostNewServlet")
public class PostNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService service;

    public PostNewServlet() {
    	service = new PostService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// need to make sure that the user is logged in . . .  .
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("user")==null){
			response.sendRedirect("./posts");
		}else{
				
			request.setAttribute("comment", "active");
			request.getRequestDispatcher("WEB-INF/jsp/newComment.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostBean newPost = new PostBean();
		UserBean user = new UserBean();
		HttpSession session = request.getSession(false);
		
		
		if(session.getAttribute("user")==null){
			response.sendRedirect("./posts");
		}else{
		
			user = (UserBean)session.getAttribute("user");
			java.util.Date date = new java.util.Date();
			
			
			//need to make sure that the information is coming from the correct place/exists
			
			newPost.setTitle(request.getParameter("title"));
			newPost.setShortDesc(request.getParameter("shortComment"));
			newPost.setLongDesc(request.getParameter("detailComment"));
			
			newPost.setCreatedBy(user.getUserName());
			newPost.setUpdatedBy(user.getUserName());
			
			newPost.setCreateDate(new java.sql.Timestamp(date.getTime()));
			newPost.setUpdateDate(new java.sql.Timestamp(date.getTime()));
			
			Boolean success = service.newPost(newPost);
			if(success){
				//response.sendRedirect("./detail?postId="+newPost.getPostId());
				response.sendRedirect("./posts");
	
				} else {
					request.setAttribute("errorMessage",  "System error");
					doGet(request, response);
				}
		}
	}

}

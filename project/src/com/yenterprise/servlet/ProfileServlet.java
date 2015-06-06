package com.yenterprise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yenterprise.model.UserBean;
import com.yenterprise.svc.PostService;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService service;
	

    public ProfileServlet() {
    	service = new PostService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session.getAttribute("user")!=null){
			request.setAttribute("profile", "active");
			request.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(request,  response);
			
		}else{
			response.sendRedirect("./posts");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		UserBean origUser = (UserBean)session.getAttribute("user");
		UserBean updatedUser = new UserBean();
		
		
		updatedUser.setUserId(origUser.getUserId());
		updatedUser.setCreateDate(origUser.getCreateDate());
		updatedUser.setFirstName(request.getParameter("firstName"));
		updatedUser.setLastName(request.getParameter("lastName"));
		updatedUser.setUserName(request.getParameter("userName"));
		updatedUser.setPassword(request.getParameter("password"));
		updatedUser.setEmail(request.getParameter("email"));
		
		
		String errorMessage = service.userUpdate(updatedUser);
		
		if(errorMessage==""){
			session.setAttribute("user", updatedUser);
			response.sendRedirect("./posts");
		}else{//-1
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(request, response);
		}
	}

}

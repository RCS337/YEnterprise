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


@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService service;   
   
    public RegisterUserServlet() {
    	 service = new PostService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("user")!=null){
				
			response.sendRedirect("./posts");
		}
		
		
		try{
						
				request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request,  response);
			}catch (Exception ex){
				ex.printStackTrace();
			}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = new UserBean();
		
		
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		java.util.Date date = new java.util.Date();
		user.setCreateDate(new java.sql.Timestamp(date.getTime()));
		
		UserBean retUser = service.userRegister(user);
		
		if(retUser!=null){
			HttpSession session=request.getSession(true);
			session.setAttribute("user", retUser);
			response.sendRedirect("./posts");
		}else{
			request.setAttribute("errorMessage", "Username is already in use");
			user.setPassword(null);
			user.setUserName(null);
			request.setAttribute("retryUser", user);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		
	}

  }
}

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private PostService service;

    public LoginServlet() {
        service = new PostService();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("user")!=null){
			//add a logout confirmation page . . . . 
			session.invalidate();
			
			response.sendRedirect("./posts");
		}
		
		
		try{
						
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,  response);
			}catch (Exception ex){
				ex.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = new UserBean();
		
		boolean passValidation=validateLogin(request,response);
		
		if(passValidation){
			user.setUserName(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			
			user=service.userLogin(user);
			
			if(user!=null){
				
				HttpSession session=request.getSession(true);
				session.setAttribute("user", user);
				response.sendRedirect("./posts");
				
			}else{
				request.setAttribute("errorMessage", "Invalid username and/or password");
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}
		}
	}
	
	
	
	
	
	
	private boolean validateLogin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String errorMessage = "";
		
		if(userName.trim().length()==0||userName==null){
			errorMessage = "User Name is";
		}
		if(password.trim().length()==0||password==null){
			errorMessage = errorMessage.replace("is", "");
			errorMessage +=(errorMessage!="" ? " and Password are" : "Password is");
		}
		if(errorMessage!=""){
			errorMessage+=" required";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return false;
		}
		
			return true;
	}


}

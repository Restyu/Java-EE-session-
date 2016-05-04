package com.javi.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String usuario = "javi";
	private String password = "restyu";
	
	protected void doPost(HttpServletRequest req , HttpServletResponse rep) throws ServletException , IOException {
	
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		
		if(usuario.equals(user) && password.equals(pass)){
			
			HttpSession session = req.getSession();
			session.setAttribute("user","javi");
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30*60);
			rep.addCookie(userName);
			rep.sendRedirect("LoginSuccess.jsp");
			
		}else{
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= rep.getWriter();
	        out.println("<font color=red>El nombre de usuario o la contraseña es erroneo</font>");
	        rd.include(req, rep);
		}
	}
}
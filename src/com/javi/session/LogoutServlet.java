package com.javi.session;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req , HttpServletResponse rep) throws IOException{
		
		rep.setContentType("text/html");
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
	        for(Cookie cookie : cookies){
	            if(cookie.getName().equals("JSESSIONID")){
	                System.out.println("JSESSIONID="+cookie.getValue());
	            }
	            cookie.setMaxAge(0);
	            rep.addCookie(cookie);
	        }
	      }
	        HttpSession session = req.getSession(false);
	        System.out.println("User="+session.getAttribute("user"));
	        if(session != null){
	            session.invalidate();
	        }
	        rep.sendRedirect("login.html");
	    }
	}

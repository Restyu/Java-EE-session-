<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>HOME</title>
</head>
<body>
	<%	
		String user = null;
		if(session.getAttribute("user") == null){
	    	response.sendRedirect("login.html");
		}else user = (String) session.getAttribute("user");
				
			String userName = null;
			String sessionID = null;
			Cookie[] cookies = request.getCookies();
			
		if(cookies !=null){
			for(Cookie cookie : cookies){
	    		if(cookie.getName().equals("user")) userName = cookie.getValue();
	    		if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
			}
		}
	%>
	<h3>Inicio session <%=userName %>, ID DE SESSION <%=sessionID %></h3>
	<br>
	User=<%=user %>
	<br>
	<a href="CheckoutPage.jsp">Checkout Page</a>
	<form action="LogoutServlet" method="post">
	<input type="submit" value="Logout" >
	</form>
</body>
</html>
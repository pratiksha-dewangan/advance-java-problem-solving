<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="pojo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
HashMap<String,User> map = new HashMap<String, User>();
	map.put("ram", new User("ram", 20, "123"));
	map.put("sita", new User("sita", 21, "123"));
	map.put("laxman", new User("laxman", 21, "123"));
	map.put("joey", new User("joey", 22, "123"));
	map.put("mona", new User("mona", 23, "123"));
%>

<% 
String email = request.getParameter("em");
String pass = request.getParameter("pass");		
if(map.containsKey(email)){
	session.setAttribute("details", map.get(email));
	RequestDispatcher rd = request.getRequestDispatcher("details.jsp");	
	rd.forward(request, response);
%>
<h5>
<a href="details.jsp">Display validated user details..!!</a>
</h5>
	
<% 
	
}
else{
	%>
	<h5>Invalid credentials....
<a href="login.jsp">Please retry..!!</a>
</h5>
	<% 
}
%>
<hr>
	

</body>
</html>
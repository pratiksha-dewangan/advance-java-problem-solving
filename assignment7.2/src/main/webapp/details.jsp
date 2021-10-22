<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="pojo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>Details are....</h2>
	<%
	User usr = (User)session.getAttribute("details");
	out.print("<h3>"+usr+"</h3>");

	%>
	<hr>
	<a href = "logout.jsp">Log me out</a>
</body>
</html>
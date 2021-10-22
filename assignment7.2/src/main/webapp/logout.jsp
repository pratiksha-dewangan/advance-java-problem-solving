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
<%
	User usr = (User)session.getAttribute("details");
%>
	<h2>Hello,  <%=  usr.getUsername() %> </h2>
	
<% 
	session.invalidate();
%>
<h1>You have logged out....</h1>
<h2>
	<a href="index.jsp">Visit Again</a>
</h2>
</body>
</html>
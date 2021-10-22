<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<style>
		#demo {
	background: #D4EED1 none no-repeat scroll 0px 0px;
font-family: Georgia, serif;
font-size: 20px;
letter-spacing: 0.2px;
word-spacing: 0.2px;
color: #BAA1F5;
font-weight: 700;
text-decoration: none solid rgb(68, 68, 68);
font-style: italic;
font-variant: normal;
text-transform: none;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="demo">
<h1><a href="<spring:url value='user/login'/>">Welcome to Online Banking Site...</a></h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<style>
		#demo {
	background:#bbff33 none no-repeat scroll 0px 0px;
font-family: Georgia, serif;
font-size: 20px;
letter-spacing: 0.2px;
word-spacing: 0.2px;
color:  #0000e6 ;
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
<h1>Welcome to JumanJi</h1>
<h2><a href="<spring:url value='passenger/login'/>">Sign in</a></h2>
<h2><a href="<spring:url value='passenger/register'/>">Sign up</a></h2>
</body>
</html>
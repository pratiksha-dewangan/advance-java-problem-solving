<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
color: #000000;

	}
	
	.btn {
  background: #4343F5;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Georgia;
  color: #ffffff;
  font-size: 15px;
  padding: 7px 18px 7px 18px;
  text-decoration: none;
}

.btn:hover {
  text-decoration: none;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="demo">
<h5>${requestScope.message}</h5>
	<form method="post">
		<table style="background-color: #ffffff; margin: auto">
			<tr>
				<td>Enter User Email :</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password :</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"  class="btn"/></td>
				<td><a href='<spring:url value="/user/register"/>'><input type="button" value="Register" class="btn"/></a></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.btn1 {
  background: #e60000;
  background-image: -webkit-linear-gradient(top, #e60000, #e60000);
  background-image: -moz-linear-gradient(top, #e60000, #e60000);
  background-image: -ms-linear-gradient(top, #e60000, #e60000);
  background-image: -o-linear-gradient(top, #e60000, #e60000);
  background-image: linear-gradient(to bottom, #e60000, #e60000);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Georgia;
  color: #ffffff;
  font-size: 15px;
  padding: 7px 18px 7px 18px;
  text-decoration: none;
}

.btn1:hover {
  text-decoration: none;
}

.btn2 {
  background: #39e600
  background-image: -webkit-linear-gradient(top, #39e600, #39e600);
  background-image: -moz-linear-gradient(top, #39e600, #39e600);
  background-image: -ms-linear-gradient(top, #39e600, #39e600);
  background-image: -o-linear-gradient(top, #39e600, #39e600);
  background-image: linear-gradient(to bottom, #39e600, #39e600);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Georgia;
  color: #ffffff;
  font-size: 15px;
  padding: 7px 18px 7px 18px;
  text-decoration: none;
}

.btn2:hover {
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
				<td>Enter Passenger Email :</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password :</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
		
				<td><a href='<spring:url value="/passenger/login"/>'><input type="submit" value="Login" class="btn2"/></a></td>
				<td><a href='<spring:url value="/passenger/register"/>'><input type="button" value="Register" class="btn1"/></a></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
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

.demo {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center" style="color: red;">Hello , ${sessionScope.pass_details.name}</h2>
<h2 align="center" style="color: red;">Enter More Details :</h2>
<h3>${requestScope.message}</h3>

<form:form method="post" modelAttribute="card">
<table class ="demo">
    <tr>
    <td>Passenger Name :</td>
    <td><input name="name" type="text" placeholder="Enter Your Name" /> <br /></td>
    </tr>
  
    <tr>
    <td>Email :</td>
  	<td><input name="email" type="text" placeholder="Enter Your email" /> <br /></td>
    </tr>
    <tr>
    <td>Phone Number :</td>
  	<td><input name="phoneNum" type="text" placeholder="Enter Phone Number "/> <br /></td>
    </tr>
</table>
    <br>
    <br>
    <a href='<spring:url value="/passenger/card"/>'><input type="submit" value="Enter Details" class="btn1"/></a>
</form:form>
</body>
</html>
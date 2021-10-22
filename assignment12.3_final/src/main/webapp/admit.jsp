<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${applicationScope.course.mesg}</h2>
<jsp:setProperty property="*" name="course"/>
<form action="validate_student.jsp">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="mail" /></td>
			</tr>

			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td>CGPA</td>
				<td><input type="number" name="cgpa" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Admit Student" /></td>
				
			</tr>
		</table>
	</form>

</body>
</html>
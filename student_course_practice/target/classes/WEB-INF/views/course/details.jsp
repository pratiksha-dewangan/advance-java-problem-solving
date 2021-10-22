<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<h2>Course details...</h2>
	
	<table style="background-color: lightgrey;">
	<tr>
	<td>Course id:</td>
	<td>${course.id}</td>
	</tr>
	
	<tr>
	<td>Course title:</td>
	<td>${course.title}</td>
	</tr>
	
	<tr>
	<td>Course Registration Date:</td>
	<td>${course.regDate}</td>
	</tr>
	</table>

<h2>Student details...</h2>
<table style="background-color: lightgrey;">
<c:forEach var="student" items="${requestScope.student_list}">
	<tr>
		<td> Id</td>
		<td> Name</td>
		<td>Address</td>
		<td> CGPA</td>
		<td>Date-of-Birth</td>
	</tr>
	<tr>
		<td>${student.id}</td>
		<td>${student.name}</td>
		<td>${student.address}</td>
		<td>${student.cgpa}</td>
		<td>${student.dob}</td>
	</tr>
</c:forEach>
</table>

	


</body>
</html>
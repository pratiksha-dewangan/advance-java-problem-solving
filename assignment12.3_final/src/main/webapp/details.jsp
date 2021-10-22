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
<jsp:setProperty property="*" name="course"/>
<c:set var ="course" value="${applicationScope.course.courseDetails()}"/>
<div style="margin: auto;">
<h2>Course Details</h2>
<h3>ID : ${course.id}</h3>
<h3>Title : ${course.title}</h3>
<h3>Capacity : ${course.capacity}</h3>
<h3>Start Date : ${course.startDate}</h3>
<h3>End Date : ${course.endDate}</h3>
</div>
	<table style="background-color: lightgrey; margin: auto;">
		<tr>
			<td>Student ID</td>
			<td>Name</td>
			<td>Email Address</td>
		</tr>
		<c:forEach var="student"
			items="${applicationScope.course.courseDetails().students}">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
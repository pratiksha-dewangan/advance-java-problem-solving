<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Course List...</h1>
<h2>${requestScope.message}</h2>
<table style="background-color: lightgrey; margin: auto;">
<c:forEach var="course" items="${requestScope.course_list}">
	<tr>
	<td>${course.title}</td>
	<td><a href="<spring:url value='/course/delete?id=${course.id}'/>">Delete Course</a></td>
	<td><a href="<spring:url value= '/student/add?courseId=${course.id}'/>">Admit Student</a></td>
	<td><a href="<spring:url value='/course/details?id=${course.id}'/>">Details</a></td>	
	</tr>
</c:forEach>

</table>
</body>
</html>
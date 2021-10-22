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
<table style="background-color: lightgrey; margin: auto;">
<tr>
			<td>Course Title</td>
			<td>Delete</td>
			<td>Admission</td>
			<td>Details</td>
		</tr>
<c:forEach var="title" items="${applicationScope.course.fetchCourseTitle()}">
<tr>
<td style="text-transform: uppercase;">${title}</td>
<td>
<a href="delete_course.jsp?title=${title}">Delete</a>
</td>
<td>
<a href="admit.jsp?title=${title}">Admit Student</a>
</td>
<td>
<a href="details.jsp?title=${title}">Details</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>
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

<table style="background-color: lightgrey; margin: auto;">
<tr>
			<td>Course Title</td>
			<td>Delete</td>
			<td>Admission</td>
			<td>Details</td>
		</tr>
		
	<c:forEach	 var="title" items= "${applicationScope.course.fetchCourseTitle()}">
	
	<tr>
	<td>${title}</td>
	<td><a href= ""></a></td>
	<td><a></a></td>
	<td><a></a></td>
	<td><a></a></td>
	
	</tr>
	
	
	</c:forEach>
</table>
</body>
</html>
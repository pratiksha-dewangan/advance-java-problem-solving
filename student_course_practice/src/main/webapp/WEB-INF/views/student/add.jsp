<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table.comicGreen {
	font-family: "Comic Sans MS", cursive, sans-serif;
	border: 2px solid #4F7849;
	background-color: #EEEEEE;
	width: 100%;
	text-align: center;
	border-collapse: collapse;
}

table.comicGreen td, table.comicGreen th {
	border: 1px solid #4F7849;
	padding: 3px 2px;
}

table.comicGreen tbody td {
	font-size: 15px;
	font-weight: bold;
	color: #4F7849;
}

table.comicGreen tr:nth-child(even) {
	background: #CEE0CC;
}

table.comicGreen tfoot td {
	font-size: 21px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${requestScope.message}</h2>
	<form:form method="post" modelAttribute="student">
		<h2>Student Admission form</h2>

		<table class="comicGreen">
			<tbody>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" type="text" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" type="text" /></td>
				</tr>
				<tr>
					<td>Date-of-Birth:</td>
					<td><form:input path="dob" type="date" /></td>
				</tr>
				<tr>
					<td>CGPA:</td>
					<td><form:input path="cgpa" type="number" /></td>
				</tr>
			</tbody>
		</table>
		<br>
		<input type="submit" value="Admit Student" />
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Create Account...</h2>
<h1>Your id is : ${sessionScope.user_id}</h1>

<form action="post" model>
<table style='background-color: #5F9EA0; margin: auto; height: 99px; width= "363"'>
<tbody>
<tr>
<td>Account Type:</td>
<td><select>
<option value="saving">SAVING</option>
<option value="current">CURRENT</option>
</select>
</td>
</tr>
<tr>
<td>Opening Balance :</td>
<td><input name="balance" type="number" /></td>
</tr>
</tbody>
</table>
<br /> 
<br /> 
<a href="<spring:url value='/user/list'/>"><input type="button" value="Create Account"/></a>
</form>

</body>
</html>
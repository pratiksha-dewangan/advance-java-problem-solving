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

<c:set var="name" value="${param.name}"/>
<c:set var="dob" value="${param.dob}"/>
<c:set var="mail" value="${param.mail}"/>
<c:set var="cgpa" value="${param.cgpa}"/>
<c:redirect url="${applicationScope.course.admitStudent(name,mail,cgpa,dob)}.jsp"/>
</body>
</html>
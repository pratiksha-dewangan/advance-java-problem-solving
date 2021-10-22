<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<style>
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
<h2 align="center" style="color: red;">Available Flights</h2>
<h2></h2>

<table class="demo">


<tr>
<th>Flight ID</th>
<th>Airline Name</th>
<th>Departure City</th>
<th>Arrival City</th>
<th>Departure Date</th>
</tr>
<c:forEach var="flight" items="${sessionScope.flights}">
	<tr>
	<td>${flight.id}</td>
	<td>${flight.airlineName}</td>
	<td>${flight.depCity}</td>
	<td>${flight.arrivalCity}</td>
	<td>${flight.depDate}</td>
	<td><a href="<spring:url value='/passenger/details?id=${flight.id}'/>">Select</a></td>	
	</tr>
</c:forEach>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<style>
.btn {
  display: inline-block;
  padding: 10px 20px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
table.blueTable{
					  font-family: Georgia, serif;
					  border: 6px solid #24943A;
					  background-color: #D4EED1;
					  width: 100%;
					  text-align: center;
					}
					table.greenTable td, table.greenTable th {
					  border: 1px solid #24943A;
					  padding: 3px 2px;
					}
					table.greenTable tbody td {
					  font-size: 13px;
					}
					table.greenTable thead {
					  background: #24943A;
					  background: -moz-linear-gradient(top, #5baf6b 0%, #3a9e4d 66%, #24943A 100%);
					  background: -webkit-linear-gradient(top, #5baf6b 0%, #3a9e4d 66%, #24943A 100%);
					  background: linear-gradient(to bottom, #5baf6b 0%, #3a9e4d 66%, #24943A 100%);
					  border-bottom: 0px solid #444444;
					}
					table.greenTable thead th {
					  font-size: 19px;
					  font-weight: bold;
					  color: #F0F0F0;
					  text-align: left;
					  border-left: 2px solid #24943A;
					}
					table.greenTable thead th:first-child {
					  border-left: none;
					}
					
					table.greenTable tfoot {
					  font-size: 13px;
					  font-weight: bold;
					  color: #F0F0F0;
					  background: #24943A;
					  background: -moz-linear-gradient(top, #5baf6b 0%, #3a9e4d 66%, #24943A 100%);
					  background: -webkit-linear-gradient(top, #5baf6b 0%, #3a9e4d 66%, #24943A 100%);
					  background: linear-gradient(to bottom, #5baf6b 0%, #3a9e4d 66%, #24943A 100%);
					  border-top: 1px solid #24943A;
					}
					table.greenTable tfoot td {
					  font-size: 13px;
					}
					table.greenTable tfoot .links {
					  text-align: right;
					}
					table.greenTable tfoot .links a{
					  display: inline-block;
					  background: #FFFFFF;
					  color: #24943A;
					  padding: 2px 8px;
					  border-radius: 5px;
					}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${sessionScope.message}</h2>
<h2>Hello, ${sessionScope.user_detail.name}</h2>
<h3>${requestScope.msg}</h3>
<hr>
<table class="blueTable">
	<tr>
		<td>Select</td>
		<td>Account Id</td>
		<td>Account Number</td>
		<td>Account Type</td>
		<td>Account Balance</td>		
	</tr>	
<c:forEach var="acnt" items="${sessionScope.accnt_details}">	
	<tr>
		<td><input type="radio" name="id" value="<c:set var="acc_id" value="${acnt.id}"/>"/></td>
		<td>${acnt.id}</td>
		<td>${acnt.accountNum}</td>
		<td>${acnt.type}</td>
		<td>${acnt.balance}</td>	
	</tr>	
	</c:forEach>
</table>
<table>	
	<tr>
			<td><a href="<spring:url value='/acnt/withdraw?aId=${acc_id}'/>"><input type="button" value="Withdraw"  class="btn"/></a></td>
			<td><a href="<spring:url value='/acnt/deposit?aId=${acc_id}'/>"><input type="button" value="Deposit" class="btn"/></a></td>
			<td><a href="<spring:url value='/acnt/close?aId=${acc_id}'/>"><input type="button" value="Close A/C" class="btn"/></a></td>			
			<td><a href="<spring:url value='/acnt/create?userId=${sessionScope.user_detail.id}'/>"><input type="button" value="Create A/c" class="btn" name="create"/></a></td>
			<td><h3><a href="<spring:url value='/user/logout'/>">Click here to Log Out</a></h3></td>	
	</tr>
</table>
</body>
</html>
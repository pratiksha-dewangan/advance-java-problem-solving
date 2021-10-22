<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.btn1 {
  background: #e60000;
  background-image: -webkit-linear-gradient(top, #e60000, #e60000);
  background-image: -moz-linear-gradient(top, #e60000, #e60000);
  background-image: -ms-linear-gradient(top, #e60000, #e60000);
  background-image: -o-linear-gradient(top, #e60000, #e60000);
  background-image: linear-gradient(to bottom, #e60000, #e60000);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Georgia;
  color: #ffffff;
  font-size: 15px;
  padding: 7px 18px 7px 18px;
  text-decoration: none;
}

.btn1:hover {
  text-decoration: none;
}

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
<h3 align="center" style="color: red;">Enter Card Details :</h3>
<h4>${requestScope.message}</h4>

<form method="post">
<table class ="demo">
    <tr>
    <td>Card Number :</td>
    <td><input name="cardNum" type="text" placeholder="Enter card number" /> <br /></td>
    </tr>
  
    <tr>
    <td>Card Name :</td>
  	<td><input name="cardName" type="text" placeholder="Enter card name" /> <br /></td>
    </tr>
    
    <tr>
    <td>Expiry Date :</td>
  	<td><input name="expDate" type="date" placeholder="Enter expiry date"/> <br /></td>
    </tr>
    
    <tr>
    <td>CVV:</td>
  	<td><input name="cvv" type="text" placeholder="Enter cvv "/> <br /></td>
    </tr>
</table>
    <br>
    <br>
    <a href='<spring:url value="/passenger/status"/>'><input type="submit" value="Enter" class="btn1"/></a>
</form>
</body>
</html>
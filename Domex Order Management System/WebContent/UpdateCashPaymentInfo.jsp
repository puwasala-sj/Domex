<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.CashPayment" %>
<%@ page import="Service.IOrderPaymentService" %>
<%@ page import="Service.IOrderPaymentServiceImplement"%>    
<%@ page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Cash Payment</title>
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="CSS/Payment.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/Navigation.css">
</head>
<body style = "background-image:url('Images/i5.jpg');">
<div class="header">
	<img  alt="" src="Images/domex_logo.png" style="z-index = 1; position:absolute;  
	z-index:1;  
	right:125px;  
	top:0px; ">	
<div class="navigationbar">
  	<a href="HomePage.jsp">Home</a>
  	<a href="Admin.jsp">Admin Dashboard</a>
  	<a href="CashList.jsp">Cash List</a>
  	
</div>

<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="Orders.jsp">Order</a></li>
    <li class="breadcrumb-item"><a href="PaymentMethod.jsp">Payment method</a></li>
    <li class="breadcrumb-item active" aria-current="page">CashPayment</li>
  </ol>
</nav>

<form action="UpdateCashPaymentServlet" method="post">

		<p>
			</br>
		</p>
		<h1>Cash Payment</h1>
		<p></p>

		<fieldset>
			<% ArrayList<CashPayment> list1 = (ArrayList<CashPayment>)request.getAttribute("cashpayment");
					for(CashPayment c1: list1){
						%>	
			<p></p>
			
			<label for="name"> Amount: </label> 
			<input type="text" id="amount" name="amount" value="<%=c1.getAmount()%>" required> 
			
			<label for="name">Delivery Date:</label> 
			<input type="date" id="deliveryDate" name="deliveryDate" value="<%=c1.getDeliveryDate()%>" required>
			
			<label for="name">Delivery Address:</label> 
			<input type="text" id="deliveryAddress" name="deliveryAddress" value="<%=c1.getDeliveryAddress()%>" required>
	
		</fieldset>

			<button type="submit" name = "cashPID" value="<%=c1.getCashPID()%>">Update Details</button>
			<p></p>
	<% } %>
	</form>
</body>
</html>
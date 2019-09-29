<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.CardPayment" %>
<%@ page import="Service.IOrderPaymentService" %>
<%@ page import="Service.IOrderPaymentServiceImplement"%>    
<%@ page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Card Payment</title>
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
  	<a href="CardList.jsp">Card List</a>
  	 	
</div>

<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="Orders.jsp">Order</a></li>
    <li class="breadcrumb-item"><a href="PaymentMethod.jsp">Payment method</a></li>
    <li class="breadcrumb-item active" aria-current="page">CardPayment</li>
  </ol>
</nav>

<form action="UpdateCardPaymentServlet" method="post">

		<p>
			</br>
		</p>
		<h1>Card Payment</h1>
		<p></p>

		<fieldset>
			<% ArrayList<CardPayment> list1 = (ArrayList<CardPayment>)request.getAttribute("cardpayment");
					for(CardPayment ca1: list1){
						%>	
			<p></p>
			
			<label for="name"> Amount: </label> 
			<input type="text" id="amount" name="amount" value="<%=ca1.getAmount()%>" required> 
			
			<label for="name">Card Type:</label> 
			<input type="text" id="cardType" name="cardType" value="<%=ca1.getCardType()%>" required>
			
			<label for="name">Card Number:</label> 
			<input type="text" id="cardNumber" name="cardNumber" value="<%=ca1.getCardNumber()%>" required>
			
			<label for="name">Expiry Date: </label> 
			<input type="text" id="expiryDate" name="expiryDate" value="<%=ca1.getExpiryDate()%>" required> 
			
			<label for="name">Ccv:</label> 
			<input type="text" id="ccv" name="ccv" value="<%=ca1.getCcv()%>" required>
		</fieldset>

			<button type="submit" name = "cardPID" value="<%=ca1.getCardPID()%>">Update Details</button>
			<p></p>
	<% } %>
	</form>
</body>
</html>
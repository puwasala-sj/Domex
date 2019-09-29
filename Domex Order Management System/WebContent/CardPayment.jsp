<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Card Payment</title>
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
  	<a href="Orders.jsp">Order</a>
  	<a href="AddEmployee.jsp">Employee</a>
  	<a href="AddVehicle.jsp">Vehicle</a>
  	<a href="Customer.jsp">Clients</a>
  	<a href="PaymentMethod.jsp">Payment Method</a>
</div>

<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="Orders.jsp">Order</a></li>
    <li class="breadcrumb-item"><a href="PaymentMethod.jsp">Payment method</a></li>
    <li class="breadcrumb-item active" aria-current="page">CardPayment</li>
  </ol>
</nav>

<form action="AddCardPaymentServlet" method="post">

		<p>
			</br>
		</p>
		<h1>Card Payment</h1>
		<p></p>

		<fieldset>
			
			<p></p>
			<label for="name"> Amount: </label> 
			<input type="text" id="amount" name="amount" value="<%= session.getAttribute("order") %>"> 
			
			<label for="name">Card Type:</label> 
			<input type="text" id="cardType" name="cardType">
			
			<label for="name">Card Number:</label> 
			<input type="text" id="cardNumber" name="cardNumber">
			
			<label for="name">Expiry Date: </label> 
			<input type="date" id="expiryDate" name="expiryDate"> 
			
			<label for="name">Ccv:</label> 
			<input type="text" id="ccv" name="ccv">
		
		</fieldset>

			<button type="submit">Pay</button>
			<p></p>
			<button type="reset">Reset</button>
			<p></p>

		
	</form>
</body>
</html>
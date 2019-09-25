<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.ChequePayment" %>
<%@ page import="Service.IOrderPaymentService" %>
<%@ page import="Service.IOrderPaymentServiceImplement"%>    
<%@ page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Cheque Payment</title>
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
  	<a href="Home.jsp">Home</a>
  	<a href="Order.jsp">Order</a>
  	<a href="PaymentLists.jsp">Payment List</a>
  	
</div>

<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="Orders.jsp">Order</a></li>
    <li class="breadcrumb-item"><a href="PaymentMethod.jsp">Payment method</a></li>
    <li class="breadcrumb-item active" aria-current="page">ChequePayment</li>
  </ol>
</nav>

<form action="UpdateChequePaymentServlet" method="post">

		<p>
			</br>
		</p>
		<h1>Cheque Payment</h1>
		<p></p>

		<fieldset>
			<% ArrayList<ChequePayment> list1 = (ArrayList<ChequePayment>)request.getAttribute("chequepayment");
					for(ChequePayment ch1: list1){
						%>	
			<p></p>
			<label for="name"> Amount: </label> 
			<input type="text" id="amount" name="amount" value="<%=ch1.getAmount()%>"required> 
			
			<label for="name">Cheque Number:</label> 
			<input type="text" id="chequeNumber" name="chequeNumber" value="<%=ch1.getChequeNumber()%>"required>
			
			<label for="name">Bank:</label> 
			<input type="text" id="bank" name="bank" value="<%=ch1.getBank()%>"required>
		</fieldset>
			<button type="submit" name = "chequePID" value="<%=ch1.getChequePID()%>">Update Details</button>
			<p></p>
	<% } %>
	</form>
</body>
</html>
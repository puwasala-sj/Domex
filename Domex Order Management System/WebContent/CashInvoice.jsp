<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cash Invoice</title>
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="CSS/Invoice.css">
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
  	<a href="PaymentMethod.jsp">Payment Method</a>
  	
</div>

<br>
<form action="AddCashPaymentServlet" method="post">

		<p>
			</br>
		</p>
		<h1>Cash Invoice</h1>
		<p></p>
		<fieldset>
		<p>Domex Courier Service,<br>
		 511 10th Mile Post Rd,<br>
		Boralesgamuwa.<p>
			<table cellspacing = "3" cellpadding = "10">
			
			<tr>
			<th>Amount:</th>
			<th>Delivery Date:</th>
			<th>Delivery Address:</th>
			</tr>
			
			<tr>
			<td><%= session.getAttribute("order") %></td>
			<td><%= session.getAttribute("deliveryDate") %></td>
			<td><%= session.getAttribute("deliveryAddress") %></td>
			</tr>
			
			</table>
			<br>
			<p>Total Amount to be Paid: &nbsp Rs. <%= session.getAttribute("order") %></p>
			<br>
			<p>Thank You<br>
			Manager,<br><br>
			............................</p>
			
		</fieldset>
		
	</form>
	
	<button onclick="myFunction()" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;margin: 4px 2px;cursor: pointer;border-radius: 5%;font-weight:bold;"> PRINT </button>


		<script>
		function myFunction() {
			  window.print();
			}
		</script>
</body>
</html>
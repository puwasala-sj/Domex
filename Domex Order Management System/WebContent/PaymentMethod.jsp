<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Payment Method</title>
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="CSS/PaymentMethod.css">
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
	  	<a href="PaymentMethod.jsp">Payment Method</a>
	  	<a href="Customer.jsp">Client</a>
	</div>
</div>



<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePages.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="Orders.jsp">Order</a></li>
        <li class="breadcrumb-item active" aria-current="page">Payment Method</li>
  </ol>
</nav>
	
	<div id="box1" style = "background-image:url('Images/i9.jpg');padding-left:30px;"><br>
		<div id = "box2" style = "background: white;padding-left:10px;padding-right:5px;">
			<br><h2>Select Payment Method</h2>
  			<br>
			<a href="CashPayment.jsp" class="classred">Cash Payment</a><br><br>
			<a href = "ChequePayment.jsp" class = "classyellow">Cheque Payment</a><br><br>
			<a href = "CardPayment.jsp" class = "classgreen">Card Payment</a><br><br><br><br>
		</div>
     </div> 
     
     <br>
     <br>
     <br>
      
     
     
</body>
</html>
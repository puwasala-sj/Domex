<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Lists</title>
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
	  	<a href="Admin.jsp">Admin DashBorad</a>
	  	<a href="OrderList.jsp">Order List</a>
	  	<a href="EmployeeList.jsp">Employee List</a>
	  	<a href="VehicleList.jsp">Vehicle List</a>
	  	<a href="client_registration.jsp">Regular client list</a>
	  	<a href="CorporateClientRegistration.jsp">Corporate client list</a>
	  	
	</div>
</div>



<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Payment List</li>
     
  </ol>
</nav>
	
	<div id="box1" style = "background-image:url('Images/i9.jpg');padding-left:30px;"><br>
		<div id = "box2" style = "background: white;padding-left:10px;padding-right:5px;">
			<br><h2>Payment Lists</h2>
  
			<a href="CashList.jsp" class="classred">Cash Payment List</a><br><br>
			<a href = "ChequeList.jsp" class = "classyellow">Cheque Payment List</a><br><br>
			<a href = "CardList.jsp" class = "classgreen">Card Payment List</a><br><br><br><br>
		</div>
     </div> 
     
     <br>
     <br>
     <br>
      
     
</body>
</html>
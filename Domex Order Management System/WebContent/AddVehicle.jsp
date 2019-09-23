<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Vehicle</title>
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="CSS/AddVehicle.css">
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
	  	<a href="AddEmployee.jsp">Employees</a>
	  	<a href="AddVehicle.jsp">Vehicle</a>
	  	<a href="VehicleList.jsp">Vehicle List</a>
	  	<a href="client_registration.jsp">Client</a>
</div>
</div>
<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Add Vehicles</li>
  </ol>
</nav>

	<form action="AddVehicleServlet" method="post">

		<p>
			</br>
		</p>
		<h1>Add Vehicle Details</h1>
		<p></p>

		<fieldset>
			
			<p></p>
			
			
			<label for="name">Vehicle Number:</label> 
			<input type="text" id="vehicleNumber" name="vehicleNumber">
			
			<label for="name">Vehicle Model:</label> 
			<input type="text" id="vehicleModel" name="vehicleModel">
			
			<label for="name">Vehicle Brand:</label> 
			<input type="text" id="vehicleBrand" name="vehicleBrand">
			
			<label for="name">Vehicle Number:</label> 
			<input type="text" id="vehicleNumber" name="vehicleNumber" >
			
			<label for="name">Employee ID:</label> 
			<input type="text" id="eid" name="eid" required >
			
			
			
			

		</fieldset>

			<button type="submit">Submit</button>
			<p></p>
			<button type="reset">Reset</button>
			<p></p>

		
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Vehicle" %>
<%@ page import="Service.IVehicleService" %>
<%@ page import="Service.VehicleServiceImplement"%>    
<%@ page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Vehicle</title>
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
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
  	<a href="Admin.jsp">Admin Dashboard</a>
  	<a href="CashList.jsp">Cash List</a>
  	
</div>

<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Vehicle</li>
  </ol>
</nav>

<form action="UpdateVehicleServlet" method="post">

		<p>
			</br>
		</p>
		<h1>Update Vehicle</h1>
		<p></p>

		<fieldset>
			<% ArrayList<Vehicle> list1 = (ArrayList<Vehicle>)request.getAttribute("vehicle");
					for(Vehicle v1: list1){
						%>	
			<p></p>
			
			<label for="name">Vehicle Number:</label> 
			<input type="text" id="vehicleNumber" name="vehicleNumber" value="<%=v1.getVehicleNumber()%>" required>
			
			<label for="name">Vehicle Model:</label> 
			<input type="text" id="vehicleModel" name="vehicleModel" value="<%=v1.getVehicleModel()%>" required>
			
			<label for="name">Vehicle Brand:</label> 
			<input type="text" id="vehicleBrand" name="vehicleBrand" value="<%=v1.getVehicleBrand()%>" required>
			
			
			<label for="name">Employee ID:</label> 
			<input type="text" id="eid" name="eid" value="<%=v1.getEid()%>" required >
		</fieldset>

			<button type="submit" name = "vehicleID" value="<%=v1.getVehicleID()%>">Update Details</button>
			<p></p>
	<% } %>
	</form>
</body>
</html>
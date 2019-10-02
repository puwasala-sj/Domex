<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/Navigation.css">
<link rel="stylesheet" type="text/css" href="CSS/Registration_Form.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">

<title>System User Registration</title>

<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="CSS/Registration_Form.css">
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
	  	<a href="Orders.jsp">Orders</a>
	  	<a href="AddEmployee.jsp">Employees</a>
	  	<a href="AddVehicle.jsp">Vehicles</a>
	  	<a href="client_registration.jsp">Regular Clients</a>
	  	<a href="CorporateClientRegistration.jsp">Corporate Clients</a>
	</div>
</div>

<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">System User Registration</li>
  </ol>
</nav>

	<br>

<div class= "container">

<form action="AddUserServlet" method="post">
	<h1> Register System User </h1>
	<table>		
			<div class="form-group">
			<tr>
				<td><br><label for="username">Username</label></td>
				<td><input type="text" name="username" class="form-control" required/></td>
			</tr>
			</div>
			
			<br> <br>
			
			<tr>
				<td><label for="password">Password</label></td>
				<td><input type="text" name="password" class="form-control" required maxLength="20"/></td>
			</tr>
			
			<tr>
				<td><label for="role">Role</label></td>
				<td>
					
					<select class="browser-default custom-select" name="role" style="width:200px;">
						<option name="admin" value="admin"> Admin </option>
						<option name="supervisor" value="supervisor"> Supervisor</option>
						<option name="operator" value="operator" selected> Operator</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><label for="status">Status</label></td>
				<td>
					<div class="custom-control custom-radio">
				  <input type="radio" id="active" name="status" value="active" class="custom-control-input">
 			 <label class="custom-control-label" for="active">Activate</label>
			</div>
			<div class="custom-control custom-radio">
 			 <input type="radio" id="deactive" name="status" value="deactive" class="custom-control-input">
 			 <label class="custom-control-label" for="deactive">Deactivate</label>
			</div>
				</td>
			</tr>
			
			<tr><td><br></td></tr>
			<tr>
				<td><button id = button type="submit" class="btn btn-primary">Register User</button></td>
			</tr>
			
	</table>
</form>

</div>
	
</body>

</html>
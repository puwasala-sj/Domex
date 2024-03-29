<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/Navigation.css">
<link rel="stylesheet" type="text/css" href="CSS/Registration_Form.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Corporate Client Registration</title>
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
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
	  	<a href="Orders.jsp">Order</a>
	  	<a href="AddEmployee.jsp">Employees</a>
	  	<a href="Customer.jsp">Client</a>
	</div>
</div>

<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Corporate client</li>
  </ol>
</nav>

	<br>

<div class= "container">

<form action="addCorporateClient" method="post">
	<table>		
	
			<tr>
				<h1 for="title"> Corporate Client Registration </h1>
			</tr> 
	
			<div class="form-group">
			<tr>
				<td><br><label for="businessName">Business Name</label></td>
				<td><input type="text" name="Business_Name" class="form-control"  /></td>
			</tr>
			</div>
			
			<br> <br>
			
			<tr>
				<td><label for="houseNo">House No</label></td>
				<td><input type="text" name="H_Number" class="form-control"  /></td>
			</tr>
			
			<tr>
				<td><label for="lane">Lane</label></td>
				<td><input type="text" name="Lane" class="form-control" ></td>
			</tr>
			
			<tr>
				<td><label for="street">Street</label></td>
				<td><input type="text" name="Street" class="form-control" ></td>
			</tr>
									
			<tr>
				<td><label for="town">Town</label></td>
				<td><input type="text" name="Town" class="form-control" ></td>
			</tr>
			
			<tr>
				<td><label for="city">City</label></td>
				<td><input type="text" name="City" class="form-control" ></td>
			</tr>
			
			
			<tr>
				<td><label for="province">Province</label></td>
				<td>
					
					<select class="browser-default custom-select" name="Province" style="width:200px;">
						<option>Central Province </option>
						<option> Eastern Province</option>
						<option selected> Western Province</option>
						<option> Northern Province</option>
						<option> Southern Province</option>
						<option> North Western Province</option>
						<option> North Central Province</option>
						<option> Uva Province</option>
						<option> Sabaragamuwa Province</option>
					</select>
					
				</td>
			</tr>
			
			<tr>
				<td><label for="email">Email</label></td>
				<td><input type="text" name="Email" class="form-control" ></td>
			</tr>
			
			<tr>
				<td><label for="email">Other Email</label></td>
				<td><input type="text" name="Email_other" class="form-control" ></td>
			</tr>
			
			<tr>
				<td><label for="contact_no">Contact No</label></td>
				<td><input type="text" name="Contact_No" class="form-control" ></td>
			</tr>
			
			
			<tr><td><br></td></tr>
			<tr>
				<td><button id = button type="submit" class="btn btn-primary">Submit</button></td>
			</tr>
			
	</table>
</form>

</div>

<button onclick="autoFill()" style =" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;margin: 4px 2px;cursor: pointer;border-radius: 5%;font-weight:bold;"> PRINT </button> 
		<script type="text/javascript">
		
			function autoFill() { 
				document.getElementByName('Business_Name')[0].value = "";
				document.getElementByName('H_Number')[0].value = "";
				document.getElementByName('Lane')[0].value = "";
				document.getElementByName('Street')[0].value = "";
				document.getElementByName('Town')[0].value = "";
				document.getElementByName('City')[0].value = "";
				document.getElementByName('Email')[0].value = "";
				document.getElementByName('Email_other')[0].value = "";
				document.getElementByName('Contact_No')[0].value = "";
				
				
			
			} 
		
		</script>  
	
</body>

</html>
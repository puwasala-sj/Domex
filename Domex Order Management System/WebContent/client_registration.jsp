<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Client Registration</title>
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="CSS/Registration_Form.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/Navigation.css">
</head>

<body  style = "background-image:url('Images/i5.jpg');">
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
	  	<a href="CorporateClientRegistration.jsp">Corporate Clients</a>
	  	
	</div>
</div>



<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Regular Client</li>
  </ol>
</nav>

<form action="AddRegularClientServlet" method="post">
	<p>
	</p>
	<h1> Regular Client Registration </h1>
	<fieldset>	
			<label for="firstName">First Name</label>
			<input type="text" name="F_Name" /><br>
			
			<label for="lastName">Last Name</label>
			<input type="text" name="L_Name" required /><br>
			
			<label for="houseNo">House No</label>
			<input type="text" name="H_Number" required/><br>
			
			<label for="lane">Lane</label>
			<input type="text" name="Lane"  required><br>
			
		    <label for="street">Street</label>
			<input type="text" name="Street"required><br>
			
			<label for="town">Town</label>
			<input type="text" name="Town" required ><br>
			
			<label for="city">City</label>
			<input type="text" name="City" required><br>
			
				
		<!-- 	<td><label for="district">District</label></td> -->
			
<%-- 			<select name="vehicle" class="form-control" id="exampleFormControlSelect1">
   <%  
		
 		ArrayList <District> list = (ArrayList<District>) request.getAttribute("listDistrict");
	%>
	
	
	<%
		// print the information about every category of the list
		for(District district : list) { %>
			
			<option name = "district" value = <%= district.getName() %> > <%= district.getName() %></option>
	<% 	
	}
	%> --%>	
			
			<tr>
				<td><label for="Province">Province</label></td>  &nbsp; &nbsp;
				<td>
					
					<select class="browser-default custom-select" name="Province" style="width:200px;">
						<option value="Central Province">Central Province </option>
						<option value= "Eastern Province"> Eastern Province</option>
						<option value= "Western Province" selected> Western Province</option>
						<option value= "Northern Province"> Northern Province</option>
						<option value="Southern Province"> Southern Province</option>
						<option value="North Western Province"> North Western Province</option>
						<option value="North Central Province"> North Central Province</option>
						<option value="Uva Province"> Uva Province</option>
						<option value="Sabaragamuwa Province"> Sabaragamuwa Province</option>
					</select>
					
				</td>
			</tr>
			
			<tr><td><br></td></tr><br><br>
			
			<label for="postCode">Postal Code</label>
			<input type="number" name="PostalCode" required><br>
			
			<label for="email">Email</label>
			<input type="text" name="Email"  required><br>
			
			<label for="contactNo">Contact No</label>
			<input type="text" name="contact_no"  maxlength = "10" required><br>
			
			<label for="nic">NIC No:</label>
			<input type="text" name="nic"  required /><br>
			
			</fieldset>

			<button type="submit">Submit</button>
			<p></p>
			<button type="reset">Reset</button>
			<p></p>
</form>

</body>
</html>
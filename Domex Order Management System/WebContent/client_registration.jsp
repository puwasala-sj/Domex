
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<% String message = (String)request.getAttribute("success");%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/Navigation.css">
<link rel="stylesheet" type="text/css" href="CSS/Registration_Form.css">

<style>

body{
	
	background-image:url('images/yellow.jpg');
	text-align: center;
	 
}
</style>
<meta charset="ISO-8859-1">

<title>Client Registration</title>

</head>

<body  style = "background-image:url('Images/i5.jpg');">
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
	  	<a href="CorporateClientRegistration.jsp">Corporate Client</a>
	  	
	</div>
</div>



<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Regular Client</li>
  </ol>
</nav>

	<br>
	<br>


<div class= "container">


<form action="AddRegularClientServlet" method="post">
	<p>
		</p>
	<table>		
	
			<tr>
				<td><label><h1 for="title"> Regular Client Registration </h1></label></td>
			</tr> 
	
			<div class="form-group">
			<tr>
				<td><label for="firstName">First Name</label></td>
				<td><input type="text" name="F_Name" class="form-control"/><br></td>
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><label for="lastName">Last Name</label></td>
				<td><input type="text" name="L_Name" class="form-control" required /><br></td>
			</tr>
			</div>			
			
			<tr>
				<td><label for="houseNo">House No</label></td>
				<td><input type="text" name="H_Number" class="form-control"  required/><br></td>
			</tr>	
			<tr>
				<td><label for="lane">Lane</label></td>
				<td><input type="text" name="Lane" class="form-control" ><br></td>
			</tr>
			
			<tr>
				<td><label for="street">Street</label></td>
				<td><input type="text" name="Street" class="form-control" ><br></td>
			</tr>
			
			<tr>
				<td><label for="town">Town</label></td>
				<td><input type="text" name="Town" class="form-control" ><br></td>
			</tr>
			
			<tr>
				<td><label for="city">City</label></td>
				<td><input type="text" name="City" class="form-control" required><br></td>
			</tr>
				
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
			</tr>	
			
			<tr>
				<td><label for="Province">Province</label></td>
				<td>
					
					<select class="browser-default custom-select" name="Province"	 style="width:200px;">
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
			
			<tr><td><br></td></tr>
			
			<tr>
				<td><label for="postCode">Postal Code</label></td>
				<td><input type="number" name="PostalCode" class="form-control" required><br></td>
			</tr>	
			
			<tr>
				<td><label for="email">Email</label></td>
				<td><input type="text" name="Email" class="form-control" required><br></td>
			</tr>
			
			<tr>
				<td><label for="contactNo">Contact No</label></td>
				<td><input type="text" name="contact_no" class="form-control" maxlength = "10" required><br></td>
			</tr>
			
			<tr>
			<div class="form-group">
			<tr>
				<td><label for="nic">NIC No:</label></td>
				<td><input type="text" name="nic" class="form-control" required /><br></td>
			</tr>
			</div>
			
			<tr><td><br></td></tr>
			<tr>
				<td><button id = button type="submit" class="btn btn-primary">Submit</button></td>
			</tr>
			
	</table>
</form>


</div>

</body>
</html>
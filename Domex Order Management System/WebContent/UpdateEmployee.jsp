<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Employee" %>
<%@ page import="Service.IEmployeeService" %>
<%@ page import="Service.EmployeeServiceImplement"%>    
<%@ page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Employee</title>
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="CSS/AddEmployee.css">
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
  	<a href="EmployeeList.jsp">Employee List</a>
  	
</div>

<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Employee</li>
  </ol>
</nav>

<form action="UpdateEmployeeServlet" method="post">

		<p>
			</br>
		</p>
		<h1>Add Employee</h1>
		<p></p>

		<fieldset>
			<% ArrayList<Employee> list1 = (ArrayList<Employee>)request.getAttribute("employee");
					for(Employee employee: list1){
						%>	
			<p></p>
			
			<label for="name">First Name:</label> 
			<input type="text" id="fname" name="fname" value="<%=employee.getFname()%>" required>
			
			<label for="name">Last Name:</label> 
			<input type="text" id="lname" name="lname" value="<%=employee.getLname()%>" required> 
			
			<label for="name">Address:</label> 
			<input type="text" id="address" name="address" value="<%=employee.getAddress()%>" required>
			
			<label for="name">Gender:</label> 
			<input type="radio"  value= "male" name="gender" checked>Male &nbsp; &nbsp;
			<input type="radio"  value= "female" name="gender" value="<%=employee.getGender()%>" required>Female <br><br>
			
			
			<label for="name">Date of Birth:</label> 
			<input type="date" id="dob" name="dob" value="<%=employee.getDob()%>" required>
			
			<label for="name">Contact Number:</label> 
			<input type="text" id="contactNo" name="contactNo" value="<%=employee.getContactNo()%>" required> 
			
			<label for="name">Email:</label>
			<input type="text" id="email" name="email" value="<%=employee.getEmail()%>" required>
			
			<label for="name">Qualifications:</label> 
			<input type="text" id="qualifications" name="qualifications" value="<%=employee.getQualifications()%>" required>
			
			<tr>
		
			
				<td><label for="name"> Employee Type: </label> </td>
		     	<td>
		     	
		     	<select class="browser-default customer-select" name="type" style="width:200px;" value="<%=employee.getType()%>" required>
		     		<option value="admin">Administrator</option>
		     		<option value="supervisor">Supervisor</option>
		     		<option value="operator">Operator</option>
		     		<option value="driver">Driver</option>
		     	</select>
		     	</td>
		     </tr>
		     </br></br></br></br>
			 
		</fieldset>

			<button type="submit" name = "employeeID" value="<%=employee.getEmployeeID()%>">Update Details</button>
			<p></p>
	<% } %>
	</form>
</body>
</html>
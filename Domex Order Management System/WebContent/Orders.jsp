<%@page import="Model.District"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="CSS/Navigation.css">
<style>

body{
	
	background-image:url('images/yellow.jpg');
	text-align: center;
	 
}

form{
	display: inline-block;
	border-radius: 5px;
    background-color: rgba(242,242,242,0.8);
    padding: 20px;
}

button {

	margin-left : 180px 
	
}

button:hover{
	box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

.container {
	resize: both;
  	overflow: auto;
}


</style>


<meta charset="ISO-8859-1">
<title>Order</title>
</head>
<body style = "background-image:url('Images/i5.jpg');">



<div class="header">
	<img  alt="" src="Images/domex_logo.png" style="z-index = 1; position:absolute;  
	z-index:1;  
	right:125px;  
	top:0px; ">	
	<div class="navigationbar">
		
	  	<a href="HomePage.jsp">Home</a>
	  	<a href="Customer.jsp">Clients</a>
	  	<a href="AddEmployee.jsp">Employees</a>
	  	<a href="AddVehicle.jsp">Vehicles</a>
	  	<a href="PaymentMethod.jsp">Payment Methods</a>
	  	
	  	
	</div>
</div>



<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Order</li>
  </ol>
</nav>


	<br>
	<br>
	<br>


<div class= "container">


<form action="<%=request.getContextPath()%>/AddOrderServlet" method="post">
	<table>		
	
			<tr>
				<td><h1 for="exampleFormControlInput1">Order Details</h1></td>
			</tr>
	
			
			<tr>
				<td><label for="exampleFormControlInput1">Customer Name</label></td>
				<td><input type="text" name="customer_Name" id="customer_Name" class="form-control" required/></td>
			</tr>
			
			
			
			<tr>
				<td><label for="exampleFormControlInput1">Package</label></td>
				<td><input type="radio" name="packages" value="Parcel"
					checked="checked" tabindex="1" class="form-check-input"  required /><label class="form-check-label" for="exampleRadios1"> Parcel</label> </td>
			</tr>
			
			
			<tr>
				<td></td>
				<td><input type="radio" name="packages" value="Document"
					tabindex="2" class="form-check-input" id="radio2" required/><label class="form-check-label" for="exampleRadios1"> Document</label></td>
			</tr>
			
			<tr>
				<td> <label for="exampleFormControlSelect1">Type</label></td>
				<td><select class="form-control" name="type" >
						<option  value="Lightweight"  >LW</option>
						<option  value="Heavyweight">HW</option>
					</select></td>
			</tr>
			
			<tr><td><br></td></tr>
			
			<tr>
				<td><label for="exampleFormControlSelect1">Weight</label></td>
				<td><input type="number" name="kilo" id="kilo" min="0" max="100" class="form-control" required style="width: 180px;"><label for="exampleFormControlSelect1">Kilograms</label></td>
				<td><input type="number" name="gram" id="gram" min="0" max="999" class="form-control" required style="width: 180px;"><label for="exampleFormControlSelect1">Grams</label></td>
			</tr>
			
			<tr>
				<td><label for="exampleFormControlSelect1">Receiver</label></td>
				<td><input type="text" name="receiver" id="receiver" class="form-control"  required/></td>
			</tr>
			
			<tr>
				<td><label for="exampleFormControlSelect1">Address</label></td>
				<td><input type="text" name="address" id="address" class="form-control" required></td>
			</tr>


			<tr>
				<td><label for="exampleFormControlSelect1">District</label></td>
				<td><input type="text" name="district" class="form-control" required></td>
			</tr>
			
			
			
			<tr>
				<td><label for="exampleFormControlSelect1">Town</label></td>
				<td><input type="text" name="town" class="form-control" required></td>
			</tr>
			
			<tr>
				<td><label for="exampleFormControlSelect1">PostCode</label></td>
				<td><input type="number" name="postCode" class="form-control" required></td>
			</tr>
			
			<tr><td><br></td></tr>
			<tr>
				<td><button id = button type="submit" class="btn btn-primary">Submit</button></td>
			</tr>
			
	</table>
</form>

</div>

<br>

		<button onclick="autoFill()" style =" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;margin: 4px 2px;cursor: pointer;border-radius: 5%;font-weight:bold;"> PRINT </button> 
		<script type="text/javascript">
		
			function autoFill() { 
			document.getElementById('customer_Name').value = "Rishikeish"; 
			document.getElementById('kilo').value = "27"; 
			document.getElementById('gram').value = "800"; 
			document.getElementById('receiver').value = "Johnson"; 
			document.getElementById('address').value = "110,centre road,mattakkuliya"; 
			document.getElementsByName('district')[0].value = "colombo";
			document.getElementsByName('town')[0].value = "modera";
			document.getElementsByName('postCode')[0].value = "15";
			
			} 
		
		</script> 
<br>
<br>



<footer><jsp:include page="META-INF/Views/Footer.jsp"></jsp:include></footer>

</body>
</html>






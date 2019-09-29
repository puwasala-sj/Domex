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
	  	<a href="Order.jsp">Order</a>
	  	<a href=#>Payment Method</a>
	  	<a href="OrderList.jsp">View Orders</a>
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


<form action="UpdateOrders" method="post">
	<table>		
	
			<tr>
				<td><h1 for="exampleFormControlInput1">Order Details</h1></td>
			</tr>
	
			
			<tr>
				<td><label for="exampleFormControlInput1">Customer Name</label></td>
				<td><input type="text" name="C_Name" class="form-control"  required/></td>
			</tr>
			
			
			
			<tr>
				<td><label for="exampleFormControlInput1">Package</label></td>
				<td><input type="radio" name="package" value="Parcel"
					checked="checked" tabindex="1" class="form-check-input" id="radio1" required /><label class="form-check-label" for="exampleRadios1"> Parcel</label> </td>
			</tr>
			
			
			<tr>
				<td></td>
				<td><input type="radio" name="package" value="Document"
					tabindex="2" class="form-check-input" id="radio2" required/><label class="form-check-label" for="exampleRadios1"> Document</label></td>
			</tr>
			
			<tr>
				<td> <label for="exampleFormControlSelect1">Type</label></td>
				<td><select class="form-control"  >
						<option name="Type" value="Lightweight"  >LW</option>
						<option name="Type" value="Heavyweight">HW</option>
					</select></td>
			</tr>
			
			<tr><td><br></td></tr>
			
			<tr>
				<td><label for="exampleFormControlSelect1">Weight</label></td>
				<td><input type="number" name="kilo" min="0" max="100" class="form-control" required style="width: 180px;"><label for="exampleFormControlSelect1">Kilograms</label></td>
				<td><input type="number" name="gram" min="0" max="999" class="form-control" required style="width: 180px;"><label for="exampleFormControlSelect1">Grams</label></td>
			</tr>
			
			<tr>
				<td><label for="exampleFormControlSelect1">Receiver</label></td>
				<td><input type="text" name="Receiver" class="form-control"  required/></td>
			</tr>
			
			<tr>
				<td><label for="exampleFormControlSelect1">Address</label></td>
				<td><input type="text" name="Address" class="form-control" required></td>
			</tr>

<%-- 			
			<tr>
			<td><label for="exampleFormControlSelect1">District</label></td>
			
			<select name="District" class="form-control" id="exampleFormControlSelect1">
			
   <%  
		
 		ArrayList <District> list = (ArrayList<District>) request.getAttribute("listDistrict");
	%>
	
	
	<%
		// print the information about every category of the list
		for(District district : list) { %>
			
			<option name = "district" value = <%= district.getName() %> > <%= district.getName() %></option>
	<% 	
	}
	%>
	
	
			</tr>
			
			--%>
			
			
			
			<tr>
				<td><label for="exampleFormControlSelect1">Town</label></td>
				<td><input type="text" name="Town" class="form-control" required></td>
			</tr>
			
			<tr>
				<td><label for="exampleFormControlSelect1">Date</label></td>
				<td><input type="Date" name="date" class="form-control" required></td>
			</tr>
			
			<tr>
				<td><label for="exampleFormControlSelect1">PostCode</label></td>
				<td><input type="number" name="Postcode" class="form-control" required></td>
			</tr>
			
			<tr><td><input type="hidden" name="updateOrder" value="<%=session.getAttribute("Id")%>"></td></tr>
			
			<tr><td><br></td></tr>
			<tr>
				<td><button id = button type="submit" class="btn btn-primary">Submit</button></td>
			</tr>
			
	</table>
</form>

</div>

<br>
<br>
<br>



<footer><jsp:include page="META-INF/Views/Footer.jsp"></jsp:include></footer>

</body>
</html>






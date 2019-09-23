<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Vehicle" %>
<%@ page import="Service.IVehicleService" %>
<%@ page import="Service.VehicleServiceImplement"%>
<%@ page import="java.util.ArrayList"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/Navigation.css">
<link rel="stylesheet" href="CSS/Lists.css">
<meta charset="ISO-8859-1">
<title>Vehicle List</title>
</head>
<body style = "background-image:url('Images/bg1.jpg'); position = fixed;">
<div class="header">
	<img  alt="" src="Images/domex_logo.png" style="z-index = 1; position:absolute;  
	z-index:1;  
	right:125px;  
	top:0px; ">	
	<div class="navigationbar">
		
	  	<a href="Home.jsp">Home</a>
	  	<a href="Orders.jsp">Order</a>
	  	<a href="AddEmployee.jsp">Employees</a>
	  	<a href="AddVehicle.jsp">Vehicle</a>
	  	<a href="Customer.jsp">Client</a>
	</div>
</div>
<br>
	<h1><center>Vehicle List</center></h1>
	<table cellpadding="20">
         <thead>
		                                 
		    <th><b>Vehicle ID</b></th>  
			<th><b>Vehicle Number</b></th>
			<th><b>Vehicle Model</b></th>
			<th><b>Vehicle Brand</b></th>
			<th><b>Employee ID</b></th>
			
			
										
            </thead>
              <tbody>
                 <%IVehicleService iVehicleService = new VehicleServiceImplement();
                  ArrayList<Vehicle> list = iVehicleService.getVehicle();
                                      
                  for(Vehicle v1 : list){
                  %>
                  <tr>
                      <td> <%=v1.getVehicleID() %> </td>
                      <td> <%=v1.getVehicleNumber() %> </td>
                      <td> <%=v1.getVehicleModel() %> </td>
                      <td> <%=v1.getVehicleBrand() %> </td>
                      <td> <%=v1.getEid() %> </td>
                      
                           
					<td>
					   <form action="DeleteVehicleServlet" method="post">
							<input type="hidden" name="deleteVehicle" value="<%=v1.getVehicleID()%>">
							<input type="submit" name="btnDelete" value="Delete" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;margin: 4px 2px;cursor: pointer;border-radius: 5%;font-weight:bold;">
						</form>
											
					</td>
				   </tr>
										
					<%
					 }
										
					%>                            
            </tbody>                         
      </table>
</body>
</html>
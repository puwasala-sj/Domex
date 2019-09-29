	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import = "Model.RegularClient" %> 
<%@page import = "Service.RegularClientService" %>
<%@page import = "Service.IRegularClientService" %>
<%@page import = "java.util.*" %>
<%@page import = "Servlets.DeleteRegularClientServlet" %>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="CSS/Navigation.css">
<link rel="stylesheet" href="CSS/Lists.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Regular Client List</title>

</head>

<body  style = "background-image:url('Images/bg1.jpg'); position = fixed;">

<div class="header">
	<img  alt="" src="Images/domex_logo.png" style="z-index = 1; position:absolute;  
	z-index:1;  
	right:125px;  
	top:0px; ">	
	<div class="navigationbar">
		
	    <a href="HomePage.jsp">Home</a>
	  	<a href="Admin.jsp">Admin DashBorad</a>
	  	<a href="OrderList.jsp">Order List</a>
	  	<a href="EmployeeList.jsp">Employee List</a>
	  	<a href="VehicleList.jsp">Vehicle List</a>
	  	<a href="CorporateClientRegistration.jsp">Corporate client list</a>
	  	<a href="CashList.jsp">Cash List</a>
	  	<a href="ChequeList.jsp">Cheque List</a>
	  	<a href="CardList.jsp">Card List</a>
	  	
	</div>
</div>



<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#">Home</a></li>
    <li class="breadcrumb-item"><a href="#"></a>Client Type</li>
        <li class="breadcrumb-item active" aria-current="page">Client List</li>
  </ol>
</nav>

	<center>
	<h3>  Regular Client Details </h3>

	<table cellpadding="10">
  <thead >
    <tr>
      <th scope="col">Client ID</th>
      <th scope="col">First Name</th>
      <th scope="col">Last name</th>
      <th scope="col">NIC</th>
      <th scope="col">Address</th>
      <th scope="col">Lane</th>
      <th scope="col">Street</th>
      <th scope="col">Town</th>
      <th scope="col">City</th>
      <th scope="col">Postal Code</th>
      <th scope="col">Province</th>
      <th scope="col">Email</th>
      <th scope="col">Contact No</th>
       <th scope="col">Remove Client</th> 
  </thead>
  <tbody>
  
  	<% 
  		IRegularClientService iRegClientService = new RegularClientService();
  		ArrayList<RegularClient> regList = (ArrayList<RegularClient>)iRegClientService.listRegularClients();
  		
  		//display each
  		for(RegularClient regularClient : regList) {
  	
  	%>
  
    <tr>
      <th scope="row"> <%=regularClient.getClientId() %> </th>
      <td><%=regularClient.getFirstName() %></td>
      <td><%=regularClient.getLastName() %></td>
      <td><%=regularClient.getNic() %></td>
     <td><%=regularClient.getAddressNo() %></td>
      <td><%=regularClient.getLane() %></td>
      <td><%=regularClient.getStreet() %></td>
      <td><%=regularClient.getTown() %></td>
      <td><%=regularClient.getCity() %></td>
      <td><%=regularClient.getPostalCode() %></td>
      <td><%=regularClient.getProvince() %></td>
      <td><%=regularClient.getEmail() %></td>
      <td><%=regularClient.getContactNo() %></td>
      
      <!-- delete buttons -->
      <td> 
      		<form action = "DeleteRegularClientServlet" method = "post">
      		<input type = "submit" name = "deleteClient" value = "Remove" class="btn btn-danger btn-rounded btn-sm my-0 waves-effect waves-light"> 
      		<input type= "hidden" name = "removeClient" value = <%=regularClient.getClientId()%>>
      	   </form> 
      
      </td>
      <!-- update buttons -->
      <td> 
      	<form action = "update" method = "post">
      		<input type = "submit" name = "updateClient" value = "Edit" class="class="btn btn-default"> <i class="fas fa-magic mr-1"> </i>Edit</input>
      		<input type= "hidden" name = "editClient" value = <%=regularClient.getClientId()%>>
      	 </form> 
      </td>
      
    </tr>
    
    <% } %>
    
  </tbody>
</table>
	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import = "Model.CorporateClient" %> 
<%@page import = "Service.CorporateClientService" %>
<%@page import = "Service.ICorporateClient" %>
<%@page import = "java.util.*" %>
<%@page import = "Servlets.DeleteCorporateClientServlet" %>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="CSS/Navigation.css">
<link rel="stylesheet" href="CSS/Lists.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Corporate Client List</title>

</head>

<body>

<body  style = "background-image:url('Images/bg1.jpg'); position = fixed;">

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
    <li class="breadcrumb-item"><a href="#"></a>Client Type</li>
        <li class="breadcrumb-item active" aria-current="page">Client List</li>
  </ol>
</nav>

	<center>
	<h3>  Corporate Client Details </h3>

	<table cellpadding="10">
  <thead >
    <tr>
      <th scope="col">Client ID</th>
      <th scope="col">Business Name</th>
      <th scope="col">Address</th>
      <th scope="col">Lane</th>
      <th scope="col">Street</th>
      <th scope="col">City</th>
      <th scope="col">Province</th>
      <th scope="col">Email</th>
      <th scope="col">Contact No</th>
       <th scope="col">Remove Client</th> 
  </thead>
  <tbody>
  
  	<% 
  		ICorporateClient iCorpClientService = new CorporateClientService();
  		ArrayList<CorporateClient> corpList = (ArrayList<CorporateClient>)iCorpClientService.listCorporateClients();
  		
  		//display each
  		for(CorporateClient corporateClient : corpList) {
  	
  	%>
  
    <tr>
      <th scope="row"> <%=corporateClient.getClientId() %> </th>
      <td><%=corporateClient.getBusinessName() %></td>
     <td><%=corporateClient.getAddressNo() %></td>
      <td><%=corporateClient.getLane() %></td>
      <td><%=corporateClient.getStreet() %></td>
      <td><%=corporateClient.getCity() %></td>
      <td><%=corporateClient.getProvince() %></td>
      <td><%=corporateClient.getEmail() %></td>
      <td><%=corporateClient.getExtraEmail() %></td>
      <td><%=corporateClient.getContactNo() %></td>
      
      <!-- delete buttons -->
      <td> 
      		<form action = "DeleteCorporateClientServlet" method = "post">
      		<input type = "submit" name = "deleteClient" value = "Remove" class="btn btn-danger btn-rounded btn-sm my-0 waves-effect waves-light"> 
      		<input type= "hidden" name = "removeClient" value = <%=corporateClient.getClientId()%>>
      	   </form> 
      
      </td>
      <!-- update buttons -->
      <td> 
      	<form action = "UpdateCorporateClientServlet" method = "post">
      		<input type = "submit" name = "updateClient" value = "Edit" class="class="btn btn-default"> <i class="fas fa-magic mr-1"> </i>Update</input>
      		<input type= "hidden" name = "editClient" value = <%=corporateClient.getClientId()%>>
      	 </form> 
      </td>
      
    </tr>
    
    <% } %>
    
  </tbody>
</table>
	</center>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "Model.User" %> 
<%@page import = "Service.UserService" %>
<%@page import = "Service.IUserService" %>
<%@page import = "java.util.*" %>
<%@page import = "Servlets.DeleteUserServlet" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/Navigation.css">
<link rel="stylesheet" href="CSS/Lists.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>System User List</title>
<body  style = "background-image:url('Images/bg1.jpg'); position = fixed;">

<div class="header">
	<img  alt="" src="Images/domex_logo.png" style="z-index = 1; position:absolute;  
	z-index:1;  
	right:125px;  
	top:0px; ">	
	<div class="navigationbar">
		
	    <a href="HomePage.jsp">Home</a>
	  	<a href="Admin.jsp">Admin DashBorad</a>
	  	
	</div>
<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="Admin.jsp">Admin DashBoard</a></li>
        <li class="breadcrumb-item active" aria-current="page">System User List</li>
  </ol>
</nav>
</div>
	<h3><center>System User Information</center></h3>

  <table cellpadding="10" id="user_table">
  <thead>
    <tr>
      <th scope="col">User ID</th>
      <th scope="col">Username</th>
      <th scope="col">Password</th>
      <th scope="col">Role</th>
      <th scope="col">Status</th>
  
  </thead>
  <tbody>
  
  	<% 
  		IUserService iuser = new UserService();
  		ArrayList<User> userList = (ArrayList<User>)iuser.listUser();
  		
  		//display each
  		for(User user : userList) {
  	
  	%>
  
    <tr>
      <th scope="row"> <%=user.getUserId() %> </th>
      <td><%=user.getUsername() %></td>
      <td><%=user.getPassword() %></td>
      <td><%=user.getRole() %></td>
       <td><%=user.getStatus() %></td>
     
      
      <!-- delete buttons -->
      <td> 
      		<form action = "DeleteUserServlet" method = "post">
      		<input type = "submit" name = "deleteUser" value = "Delete" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;cursor: pointer;border-radius: 5%;font-weight:bold;"> 
      		<input type= "hidden" name = "removeUser" value = <%=user.getUserId()%>>
      	   </form> 
      

      </td>
      <!-- update buttons -->
      <td> 
     	<!--  <form action = "UpdateUserServlet" method = "post"> -->
      		<!--  <input type = "submit" name = "updateUser" value = "Edit" class="class="btn btn-default"> <i class="fas fa-magic mr-1"> </i>Update</input> -->

      <!-- update buttons --> 
      	<form action = "UpdateUserServlet" method = "post">
      		<input type = "submit" name = "updateUser" value = "Update" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;cursor: pointer;border-radius: 5%;font-weight:bold;">
      		<input type= "hidden" name = "editUser" value = <%=user.getUserId()%>>
      	 </form> 
      </td>
      
    </tr>
    
    <% } %>
    
  </tbody>
</table>
</head>
<body>

</body>
</html>
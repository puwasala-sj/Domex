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
	  	
	</div>
<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="Admin.jsp">Admin DashBoard</a></li>
        <li class="breadcrumb-item active" aria-current="page">List Regular Clients</li>
  </ol>
</nav>
</div>
	<h3><center> Regular Client Details</center></h3>

  <table cellpadding="10" id="regularClientTable">
  <thead>
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
      		<input type = "submit" name = "deleteClient" value = "Delete" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;cursor: pointer;border-radius: 5%;font-weight:bold;"> 
      		<input type= "hidden" name = "removeClient" value = <%=regularClient.getClientId()%>>
      	   </form> 
      
      <!-- update buttons --> 
      	<form action = "update" method = "post">
      		<input type = "submit" name = "updateClient" value = "Update" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;cursor: pointer;border-radius: 5%;font-weight:bold;"> 
      		<input type= "hidden" name = "editClient" value = <%=regularClient.getClientId()%>>
      	 </form> 
      </td>
      
    </tr>
    
    <% } %>
    
  </tbody>
</table>
<button id="btnExport" onclick="fnExcelReport();" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;margin: 4px 2px;cursor: pointer;border-radius: 5%;font-weight:bold;"> EXPORT AS EXCEL DOCUMENT </button>
<button onclick="myFunction()" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;margin: 4px 2px;cursor: pointer;border-radius: 5%;font-weight:bold;"> PRINT </button>


		<script>
		function myFunction() {
			  window.print();
			}
		
		function fnExcelReport(){
			    var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
			    var textRange; var j=0;
			    tab = document.getElementById('regularClientTable'); // id of table

			    for(j = 0 ; j < tab.rows.length ; j++) 
			    {     
			        tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
			        //tab_text=tab_text+"</tr>";
			    }

			    tab_text=tab_text+"</table>";
			    tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");
			    tab_text= tab_text.replace(/<img[^>]*>/gi,""); 
			    tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); 

			    var ua = window.navigator.userAgent;
			    var msie = ua.indexOf("MSIE "); 

			    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      
			    {
			        txtArea1.document.open("txt/html","replace");
			        txtArea1.document.write(tab_text);
			        txtArea1.document.close();
			        txtArea1.focus(); 
			        sa=txtArea1.document.execCommand("SaveAs",true,"ListRegularClient.xls");
			    }  
			    else                 
			        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

			    return (sa);
			}
		</script>
</body>
</html>
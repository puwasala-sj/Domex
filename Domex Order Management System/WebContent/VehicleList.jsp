<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Vehicle" %>
<%@ page import="Service.IVehicleService" %>
<%@ page import="Service.VehicleServiceImplement"%>
<%@ page import="java.util.ArrayList"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
		
	  	<a href="HomePage.jsp">Home</a>
	  	<a href="Admin.jsp">Admin Dashboard</a>
	</div>
  <nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="Admin.jsp">Admin Dashborad</a></li>
        <li class="breadcrumb-item active" aria-current="page">List All Vehicles</li>
  </ol>
</nav>
</div>
<br>
	<h1><center>Vehicle List</center></h1>
	<table cellpadding="20" id = "vehicleTable">
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
							<input type="submit" name="btnDelete" value="Delete" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;cursor: pointer;border-radius: 5%;font-weight:bold;">
						</form>
											
					</td>
					
					<td>
					   <form action="GetVehicleServlet" method="post">
							<input type="hidden" name="updateVehicle" value="<%=v1.getVehicleID()%>">
							<input type="submit" name="btnUpdate" value="Update" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;cursor: pointer;border-radius: 5%;font-weight:bold;">
						</form>
											
					</td>
				   </tr>
										
					<%
					 }
										
					%>                            
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
			    tab = document.getElementById('vehicleTable'); // id of table

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
			        sa=txtArea1.document.execCommand("SaveAs",true,"VehicleList.xls");
			    }  
			    else                 
			        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

			    return (sa);
			}
		</script>
</body>
</html>
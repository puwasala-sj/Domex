<%@page import="Model.Order"%>
<%@page import="Service.IOrderServiceImplement"%>
<%@page import="Service.OrderService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/Lists.css">
<link rel="stylesheet" href="CSS/Navigation.css">
<meta charset="ISO-8859-1">
<title>OrderList</title>
</head>
<body style = "background-image:url('Images/bg1.jpg'); position = fixed;">

<div class="header">
	<img  alt="" src="Images/domex_logo.png" style="z-index = 1; position:absolute;  
	z-index:1;  
	right:125px;  
	top:0px; ">	
	<div class="navigationbar">
		
	  	<a href="Home.jsp">Home</a>
	  	<a href=Orders.jsp">Order</a>
	  	<a href="AddEmployee.jsp">Employees</a>
	  	<a href="Customer.jsp">Client</a>
	</div>
</div>

	<h1><center>Orders</center></h1>
	<table cellpadding="10" id="headerTable">
         <thead>
		                                   
			<th><b>Order ID</b></th>
			<th><b>Customer Name</b></th>
			<th><b>Package</b></th>
			<th><b>Type</b></th>
			<th><b>Weight</b></th>
			<th><b>Receiver</b></th>
			<th><b>district</b></th>
			<th><b>town</b></th>
			<th><b>Address</b></th>
			<th><b>Post Code</b></th> 
			<th><b>Charges</b></th> 
						
	
			
            </thead>
              <tbody>
                 <%
                 OrderService iOrderService = new IOrderServiceImplement();
                 ArrayList<Order> chlist = iOrderService.getOrders();
                 
          
                                      
                  for(Order o : chlist){
                  %>
                  <tr>
                      <td> <%=o.getOrderID()%> </td>
                      <td> <%=o.getCustomer_Name() %> </td>
                      <td> <%=o.getPackages() %> </td>
                      <td> <%=o.getType() %> </td>
                      <td> <%=o.getWeight() %> </td>
                      <td> <%=o.getReceiver() %> </td>
                      <td> <%=o.getDistrict()%> </td>
                      <td> <%=o.getTown() %> </td>
                      <td> <%=o.getAddress() %> </td>
                      <td> <%=o.getPostCode() %> </td>
                      <td> <%=o.getCharge() %> </td>
                      
             
					<td>
					   <form action="DeleteOrderServlet" method="post">
							<input type="hidden" name="deleteOrder" value="<%=o.getOrderID()%>">
							<input type="submit" name="btnDelete" value="Delete" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;margin: 4px 2px;cursor: pointer;border-radius: 5%;font-weight:bold;">
						</form>
						
						<form action="GetOrderUpdateServlet" method="post">
							<input type="hidden" name="updateOrder" value="<%=o.getOrderID()%>">
							<input type="submit" name="btnUpdate" value="update" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;margin: 4px 2px;cursor: pointer;border-radius: 5%;font-weight:bold;">
						</form>
											
					</td>
				   </tr>
										
					<%
					 }
										
					%> 
					
					                           
            </tbody>                         
      </table>
      
      

	<button id="btnExport" onclick="fnExcelReport();" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;margin: 4px 2px;cursor: pointer;border-radius: 5%;font-weight:bold;"> EXPORT </button>


		<script>
		
		function fnExcelReport(){
			    var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
			    var textRange; var j=0;
			    tab = document.getElementById('headerTable'); // id of table

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
			        sa=txtArea1.document.execCommand("SaveAs",true,"Orders.xls");
			    }  
			    else                 
			        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

			    return (sa);
			}
		</script>

</body>
</html>
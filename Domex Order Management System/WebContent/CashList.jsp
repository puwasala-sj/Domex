<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.CashPayment" %>
<%@ page import="Model.ChequePayment" %>
<%@ page import="Model.CardPayment" %>
<%@ page import="Service.IOrderPaymentService" %>
<%@ page import="Service.IOrderPaymentServiceImplement"%>
<%@ page import="java.util.ArrayList"%>   
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel="stylesheet" href="CSS/Navigation.css">
<link rel="stylesheet" href="CSS/Lists.css">
<meta charset="ISO-8859-1">
<title>Cash Payment List</title>
</head>
<body style = "background-image:url('Images/bg1.jpg'); position = fixed;">

<div class="header">
	<img  alt="" src="Images/domex_logo.png" style="z-index = 1; position:absolute;  
	z-index:1;  
	right:125px;  
	top:0px; ">	
	<div class="navigationbar">
		
	  	<a href="HomePage.jsp">Home</a>
	  	<a href="Admin.jsp">Admin DashBorad</a>
	  	
	</div>
</div>
<nav aria-label="breadcrumb" >
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="HomePage.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="PaymentMethod.jsp">Payment method</a></li>
    <li class="breadcrumb-item active" aria-current="page"><a href="CashList.jsp">CashList</a></li>
  </ol>
</nav>
	<br>
	<h1><center>Cash Payment List</center></h1>
	<table cellpadding="20">
         <thead>
		                                   
				<th>CashPID</th>
                <th>Amount</th>
                <th>Delivery Date</th> 
                <th>Delivery Address</th> 
										
            </thead>
              <tbody>
                 <%IOrderPaymentService iCashPaymentService = new IOrderPaymentServiceImplement();
                  ArrayList<CashPayment> list = iCashPaymentService.getCashPayments();
                                      
                  for(CashPayment c1 : list){
                  %>
                  <tr>
                      <td> <%=c1.getCashPID() %> </td>
                      <td> <%=c1.getAmount() %> </td>
                      <td> <%=c1.getDeliveryDate() %> </td>
                      <td> <%=c1.getDeliveryAddress() %></td>
             
					<td>
					   <form action="DeleteCashPaymentServlet" method="post">
							<input type="hidden" name="deletePayment" value="<%=c1.getCashPID()%>">
							<input type="submit" name="btnDelete" value="Delete" style=" background-color: purple;border: none;text-decoration: none; color: white;padding: 10px 32px;cursor: pointer;border-radius: 5%;font-weight:bold;">
						</form>
											
					</td>
					<td>
					   <form action="GetCashPaymentInfoServlet" method="post">
							<input type="hidden" name="updateCash" value="<%=c1.getCashPID()%>">
							<input type="submit" name="btnDelete" value="Update" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;cursor: pointer;border-radius: 5%;font-weight:bold;">
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
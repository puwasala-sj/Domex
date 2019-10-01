<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Card Payment List</title>
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
    <li class="breadcrumb-item"><a href="Admin.jsp">Admin Dashboard</a></li>
    <li class="breadcrumb-item active" aria-current="page">List Card payments</li>
  </ol>
</nav>
<br><br>
       <h1><center>Card Payment List</center></h1>
	  <table cellpadding="20" id="cardTable">
         <thead>                                   
				<th>CardPID</th>
                <th>Card type</th>
                <th>Card number</th>
                <th>Amount</th>
                <th>Expiry Date</th>
                <th>CCV</th> 
										
            </thead>
            <tbody>
                 <%IOrderPaymentService iCardPaymentService = new IOrderPaymentServiceImplement();
                  ArrayList<CardPayment> calist = iCardPaymentService.getCardPayments();
                                      
                  for(CardPayment ca1 : calist){
                  %>
                  <tr>
                      <td> <%=ca1.getCardPID() %> </td>
                      <td> <%=ca1.getCardType() %> </td>
                      <td> <%=ca1.getCardNumber() %> </td>
                      <td> <%=ca1.getAmount() %> </td>
                      <td> <%=ca1.getExpiryDate() %> </td>
                      <td> <%=ca1.getCcv() %> </td>

					<td>
					   <form action="DeleteCardPaymentServlet" method="post">
							<input type="hidden" name="deletePayment" value="<%=ca1.getCardPID()%>">
							<input type="submit" name="btnDelete" value="Delete" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;cursor: pointer;border-radius: 5%;font-weight:bold;">
						</form>
											
					</td>
					<td>
					   <form action="GetCardPaymentInfoServlet" method="post">
							<input type="hidden" name="updateCard" value="<%=ca1.getCardPID()%>">
							<input type="submit" name="btnDelete" value="Update" style=" background-color: purple;border: none; color: white;padding: 10px 32px; text-decoration: none;cursor: pointer;border-radius: 5%;font-weight:bold;">
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
			    tab = document.getElementById('cardTable'); // id of table

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
			        sa=txtArea1.document.execCommand("SaveAs",true,"CardList.xls");
			    }  
			    else                 
			        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

			    return (sa);
			}
		</script>
</body>
</html>
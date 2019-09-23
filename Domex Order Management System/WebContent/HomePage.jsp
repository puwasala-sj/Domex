<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="CSS/Navigation.css">
  
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body >

<div class="header">
	<img  alt="" src="Images/domex_logo.png" style="z-index = 1; position:absolute;  
	z-index:1;  
	right:125px;  
	top:0px; ">	
	<div class="navigationbar">
		
	  	<a href="Home.jsp">Home</a>
	  	<a href="Orders.jsp">Order</a>
	  	<a href="AddEmployee.jsp">Employees</a>
	  	<a href="Customer.jsp">Clients</a>
	  	<a href="AddVehicle.jsp">Vehicles</a>
	</div>
</div>

<div class="bd-example">
  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="3"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="Images/yellow.jpg"class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>WELCOME TO DOMEX ORDER MANAGEMENT SYSTEM</h5>
          <p>Simple , Easy and Reliable </p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="Images/yellow.jpg"class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>ORDER</h5>
          <p>Manage Orders</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="Images/yellow.jpg"class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>Employee</h5>
          <p>Manage Employees</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="Images/yellow.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>Customer</h5>
          <p>Manage Customers from corporate to walk in clients</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<br>
<br>
<br>


<table style="margin-left:auto;margin-right:auto;" >
<tr>
<td >
<div class="card" style="width: 18rem; ">
  <img src="Images/yellow.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">ORDER</h5>
    <p class="card-text">Include details of orders to save into the system</p>
    <br>
    <a href="<%=request.getContextPath()%>/OrderHomepageServlet" class="btn btn-primary">Generate Order</a>
  </div>
</div>
</td>

<td >
<div class="card" style="width: 18rem;">
  <img src="Images/yellow.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">CLIENT</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="client_registration.jsp" class="btn btn-primary">Generate and order</a>
  </div>
</div>
</td>

<td >
<div class="card" style="width: 18rem;">
  <img src="Images/yellow.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">EMPLOYEE</h5>
    <p class="card-text">Edit and manage employees</p>
    <br>
    <br>
    <a href="AddEmployee.jsp" class="btn btn-primary">Manage Employees</a>
  </div>
</div>
</td>

<td >
<div class="card" style="width: 18rem; ">
  <img src="Images/yellow.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">PAYMENTS</h5>
    <p class="card-text">List Payments and manage transactions</p>
    <br>
    
    <a href="PaymentLists.jsp" class="btn btn-primary">List Payments</a>
  </div>
</div>
</td>

</tr>
</table>


<br>
<br>
<br>


<footer><jsp:include page="META-INF/Views/Footer.jsp"></jsp:include></footer>

</html>
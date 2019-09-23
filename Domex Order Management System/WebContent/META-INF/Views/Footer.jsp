<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

body{
	
	
	text-align: center;

    
}
.full {
    width: 100%;    
}
.gap {
	height: 30px;
	width: 100%;
	clear: both;
	display: block;
}
.footer {
	background: background-color: #000000;
background-image: linear-gradient(147deg, #000000 0%, #434343 74%);
	height: auto;
	padding-bottom: 30px;
	position: relative;
	width: 100%;
	border-bottom: 1px solid #CCCCCC;
	border-top: 1px solid #DDDDDD;
}
.footer p {
	margin: 0;
}
.footer img {
	max-width: 100%;
}
.footer h3 {
	color: white;
	font-size: 18px;
	font-weight: 600;
	line-height: 27px;
	padding: 40px 0 0px;
	text-transform: uppercase;
  margin-bottom: 15px;
}

.footer h4 {
	color: white;
	font-size: 2em;
	font-weight: 600;
	line-height: 38px;
	padding: 40px 0 10px;
	font-family: cursive;
  font-weight: lighter
}

.footer ul {
	font-size: 13px;
	list-style-type: none;
	margin-left: 0;
	padding-left: 0;
	margin-top: 0px;
	color: #7F8C8D;
  padding: 0 0 8px 0;
}

.email{
  border-bottom: 3px solid #fff;
}
.footer ul li a {
	padding: 0 0 12px 0;
	display: block;
}
.footer a {
	color: white;
  font-weight: lighter;
}

.footer p {
	color: white;
  font-weight: lighter;
  font-size: 
}

.footer a:hover {
	text-decoration:none;
  font-weight: bold;
}
.supportLi h4 {
	font-size: 20px;
	font-weight: lighter;
	line-height: normal;
	margin-bottom: 0 !important;
	padding-bottom: 0;
}

.bg-gray {
	background-image: -moz-linear-gradient(center bottom, #BBBBBB 0%, #F0F0F0 100%);
	box-shadow: 0 1px 0 #B4B3B3;
}

}
.footer a {
	color: #78828D
}

.footer-bottom {
  margin-top: 2em;
	border-top: 1px solid #DDDDDD;
	padding-top: 20px;
	padding-bottom: 10px;
}
.footer-bottom p.pull-left  {
	padding-top: 6px;
  font-size: 0.75em
}


</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<footer>
    <div class="footer" id="footer" style="background-color = black">
        <div class="container">
            <div class="row">
            <ul>
                <li><div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <h4> DOMEX </h4>
             	</div></li>
             	
             	<li> <div id="googleMap" style="width:550px;height:250px;"></div>
					
					<script>
					function myMap() {
					var mapProp= {
					  center:new google.maps.LatLng(6.822425,79.906775),
					  zoom:5,
					};
					var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
					}
					</script>
					
					<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB82v8RVqVkcv7LoprqOrV0pvqNdDjslos&callback=myMap"></script>
					
					
				</li>
				
				</ul>
				

             
                <div class="col-lg-3 col-sm-2 col-xs-3">
                    <h3> Contact </h3>
                    <ul>
                        <li><a class="email"href="#" style="margin-top: 4em"> contact@domex.lk </a></li>
                        <li><br></li>
                        <li> <p> 511 10th Mile Post Rd,</p> </li>
                        <li> <p>  Boralesgamuwa</p> </li>
                    </ul>
                </div>
                <div class="col-lg-3 col-sm-2 col-xs-3">
                    <ul>
                        <li> <h5> <a href="#" style="margin-top: 4em"> DOMEX</a> <h5></li>
                        <li> <h5><a href="#"> CONTACT US </a> <h5></li>
                        <li> <h5><a href="#"> 076 875 9759 </a> <h5></li>
                        <li> <h5><a href="https://www.domex.lk/"> OFFICIAL PAGE </a> <h5></li>
                    </ul>
                </div>
                

					
       	 </div>   
    </div>

     
    <div class="footer-bottom">
        <div class="container">
            <p class="pull-left copyright"> Copyright © Domex 2019. All right reserved. </p>
       
        </div>
    </div>
    <!--/.footer-bottom--> 

</div>

</footer>

</body>
</html>
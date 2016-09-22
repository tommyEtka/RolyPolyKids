<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Outdoor</title>

<link href="https://fonts.googleapis.com/css?family=Kameron" rel="stylesheet">
    
    
<link rel="stylesheet" href="resources/test/css/style.css">
        
<style>
body {
		background-image:url("http://cdn.backgroundhost.com/backgrounds/subtlepatterns/green_dust_scratch.png");
}
</style>
<spring:url value="/resources/main.css"  var="mainCss"/>
  <link href="${mainCss}"  rel="stylesheet"/>
 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 </head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <!--    <a class="navbar-brand" href="#">Logo</a>--> 
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      <li><a href="home">Home</a></li>
        <li><a href="indoor">Indoor</a></li>
        <li><a href="outdoor">Outdoor</a></li>
        <li><a href="explore">Explore</a></li>
        <li><a href="contact">Contact</a></li>
         </ul>
        </div>
  </div>
</nav>
${alert}
<div class="container">
  <div class="row">
    <div class="col-sm-12">


</div>
  </div>
  </div>

<br> 


<div class="cards_wrapper">
  <div class="card unfolded today">
    <div class="card_description">
      <div class="date"></div>
      <div class="title">FAVORITES</div>
    </div>
    <div class="alarm_item top">
      <div class="time_block">
        <!--  <div class="time">12:00</div>
      </div>
      <div class="day_part">PM</div>
      <div  class="alarm_item_description"> -->

      <a href="http://goexplorenature.com/2010/05/fun-friday-build-roly-poly-terrarium.html">RolyPolyHome</a>
       
      <!--   <p>Metro Parent hosts its annual Education Expo to give families the chance to see what academic and extracurricular options are here in southeast Michigan for kids. </p> <p>Cranbrook Institute of Science, 39221 Woodward Ave., Bloomfield Hills </p> --> 
        </div>
    </div>

      </div>
    </div>
  </div>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>

        <script src="resources/test/js/index.js"></script>

  </body>


<br>


</body>
</html>
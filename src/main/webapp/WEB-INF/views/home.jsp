<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<title>Roly Poly Kids</title>
  <spring:url value="/resources/main.css"  var="mainCss"/>
  <link href="${mainCss}"  rel="stylesheet"/>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="home">Home</a><li>
        <li><a href="indoor">Indoor</a></li>
        <li><a href="outdoor">Outdoor</a></li>
        <li><a href="explore">Explore</a></li>
        <li><a href="contacts">Contact</a></li>

      </ul>
      
    </div>
  </div>
</nav>

<div class="container text-center">
  <br>
    <br>
      <br>
  <h2> Play today </h2>
  <h2>
Welcome! How do you want to play today?
</h2>
</div>
<div class="container">

  <div class="jumbotron">

    <h1>Roly Poly Kids</h1>
    <br>
    <p>Fun, educational activities for ages ten and under. We add the learning to playtime so that you don't have to. Simply select the type of activity and add some fun to your family's day!</p>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-sm-4">
        <h3>Indoor</h3>
		<img class="img-responsive" src="resources/images/indoorCrafts.jpeg" class="img-circle person" alt="Indoor">
        <a class="btn" href="indoor"> INDOOR </a>
        <p>Feeling crafty? What about a great science experiment? Caution: great ideas inside!</p>

      </div>
      <div class="col-sm-4">
        <h3>Outdoor</h3>
		<img class="img-responsive" src="resources/images/outdoor2.jpeg" class="img-circle person" alt="Outdoor">
        <a class="btn" href="outdoor"> OUTDOOR </a>
        <p>Want to go outside to play? We have the best activities for your child's development level. </p>

      </div>
      <div class="col-sm-4">
        <h3>Go Explore</h3>
        <img class="img-responsive" src="resources/images/go explore.jpeg" class="img-circle person" alt="Explored">
        <a class="btn" href="explore"> GO EXPLORE </a>
        <p>What's going on in your neighborhood? Get our and explore your world with local events. </p>
      </div>
    </div>
  </div>

 </div>
 
 
 
</body>
</html>

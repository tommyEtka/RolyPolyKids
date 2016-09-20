<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<title>Roly Poly Kids</title>
 <!--  <spring:url value="/resources/main.css"  var="mainCss"/>
  <link href="${mainCss}"  rel="stylesheet"/>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
<style>
@import url(http://fonts.googleapis.com/css?family=Kameron);

@import 'https://fonts.googleapis.com/css?family=Sansita+One';

 .navbar {

    margin-bottom: 0;

    background-color: white;

    border: 0;

    font-size: 11px !important;

    font-family: 'Kameron';

    letter-spacing: 4px;

    opacity:0.9;

}

/* Add a gray color to all navbar links */

.navbar li a, .navbar .navbar-brand { 

    color: #666156 !important;

}

/* On hover, the links will turn orange */

.navbar-nav li a:hover {

    color: #f28500 !important;

}

/* The active link */

.navbar-nav li.active a {

    color: #f28500 !important;

    background-color:#29292c !important;

}

/* Remove border color from the collapsible button */

.navbar-default .navbar-toggle {

    border-color: transparent;

}

.jumbotron h1 {

    color: #8FB31D;

  font-size: px;

    font-weight: bold;

       }

.person {

    border: 10px solid transparent;

    margin-bottom: 25px;

    width: 80%;

    height: 80%;

    opacity: 0.7;

}

h1 {

 

  top: 17%; 

  left: 0%;

  font-family: 'Sansita one', serif;

  color: #94b001;

  font-size: 80px;

}

h2 {

  top: 20%;

color: white;

  font-family: 'Kameron'

}

h3 {

  font-family: 'Kameron';

 color: #f28500;

}

p {

    font-family: 'Kameron', serif;

}

body {

    font-family: 'Kameron'

    font-weight: 300;

    font-size: 112.5%;

    line-height: 1.4;

    background: url(http://cdn.backgroundhost.com/backgrounds/subtlepatterns/green_dust_scratch.png) #909ca2;

}

background: url(http://cdn.backgroundhost.com/backgrounds/subtlepatterns/green_dust_scratch.png) #909ca2;

}


</style>
 </head>
<body>

<h1>Welcome to Roly Poly Kids</h1>
<h2>Fun, educational activities for ages ten and under. We add learning to playtime so that you don't have to. </h2>
<h2>Simply Login in or Sign up. Let's explore together!</h2>

<h3><a href="login">Login</a></h3> <h3><a href="signup">Sign Up</a></h3>

<br>





</body>
</html>
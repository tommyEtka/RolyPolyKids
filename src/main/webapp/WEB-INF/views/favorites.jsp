<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Outdoor</title>
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
<h1> Great, you have successfully saved to your favorites list </h1>
</div>
  </div>
  </div>



<br>


</body>
</html>
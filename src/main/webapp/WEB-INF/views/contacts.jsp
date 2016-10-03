<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<div class="container">
  <div class="row">
    <div class="col-sm-12">
     <h1> Any questions? Please contact us! </h1>
     
      <table border=1>

       <tr>
                    <td>Team Members</td>
              	 <td>Email</td>
              	 </tr>
              	 
                    <tr>
                    <td>Blair Brown</td>
              	 <td>blair.jbrown@gmail.com</td>
              	 </tr>
              	 
              	 <tr>
              	 <td>Laurin Gracey-Parker</td>
              	 <td>lauriniparker@gmail.com</td>
              	 </tr>
              	 
              	 <tr>
              	 <td>Valerie Smith</td>
              	 <td>vsmith38282@gmail.com</td>
              	 </tr>
              	 
              	 <tr>
              	 <td>Tommy Thurman</td>
              	 <td>thurma13@gmail.com</td>

                </tr>
            </table>   
     
     
  </div>
  </div>
  </div>
</body>
</html>
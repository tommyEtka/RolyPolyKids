<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recipes</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Science Experiment</title>
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
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="indoor">Indoor</a></li>
        <li><a href="outdoor">Outdoor</a></li>
        <li><a href="explore">Explore</a></li>
        <li><a href="contacts">Contact</a></li>
         </ul>
        </div>
  </div>
</nav>
<div class="container">
  <div class="row">
    <div class="col-sm-12">
    <br>
    <br>
    <br>
<br>
<br>
<br>
<h2> Welcome to recipes </h2>
</div>
  </div>
  </div>
<br>
<table border=1>
<c:forEach var="rec" items="${recData}">
                <tr>
                    <td><c:out value="${rec.getTitle()}"/><br><a href='addFavorite?pin=<c:out value="${rec.getFavoritesTag()}" />'> Add To Favorites </a></td>
               <!--<td><c:out value="${craft.getLink()}" /></td>  -->
              	<!-- <td><c:out value="${craft.getImgSrc()}"/></td> -->
              	 <td><a href='<c:out value="${rec.getLink()}" />'> ${rec.getImgSrc()} </a></td>
               <!--<td><a href='<c:out value="${craft.getImgSrc()}" />'> ${craft.getLink()} </a></td>-->

                </tr>
            </c:forEach>

            </table>






</body>
</html>

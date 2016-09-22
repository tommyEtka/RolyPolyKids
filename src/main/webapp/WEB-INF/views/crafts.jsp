<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crafts</title>
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
        <li><a href="indoor">Outdoor</a></li>
        <li><a href="indoor">Explore</a></li>
        <li><a href="contact">Contact</a></li>
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
<h2> Welcome to crafts. </h2>
</div>
  </div>
  </div>
  <br>




 <table border=1>

<c:forEach var="craft" items="${craftData}">
                <tr>
                    <td><c:out value="${craft.getTitle()}"/><a href='addFavorite?pin=<c:out value="${craft.getFavoritesTag()}" />'> Add To Favorites </a></td>
               <!--<td><c:out value="${craft.getLink()}" /></td>  -->
              	<!-- <td><c:out value="${craft.getImgSrc()}"/></td> -->
              	 <td><a href='<c:out value="${craft.getLink()}" />'> ${craft.getImgSrc()} </a></td>
               <!--<td><a href='<c:out value="${craft.getImgSrc()}" />'> ${craft.getLink()} </a></td>-->

                </tr>
            </c:forEach>
            </table>

      <!--    ${craftImage}  -->
</body>
</html>
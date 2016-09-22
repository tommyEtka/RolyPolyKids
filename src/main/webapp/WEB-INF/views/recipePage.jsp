<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>
<br>
<br>
<h2> Welcome to recipes. </h2>

<br>
<table border=1>
<c:forEach var="rec" items="${recData}">
                <tr>
                    <td><c:out value="${rec.getTitle()}"/><a href='addFavorite?pin=<c:out value="${rec.getFavoritesTag()}" />'> Add To Favorites </a></td>
               <!--<td><c:out value="${craft.getLink()}" /></td>  -->
              	<!-- <td><c:out value="${craft.getImgSrc()}"/></td> -->
              	 <td><a href='<c:out value="${rec.getLink()}" />'> ${rec.getImgSrc()} </a></td>
               <!--<td><a href='<c:out value="${craft.getImgSrc()}" />'> ${craft.getLink()} </a></td>-->

                </tr>
            </c:forEach>

            </table>






</body>
</html>

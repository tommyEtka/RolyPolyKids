<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Roly Poly Kids</title>
	<style>
body {
		background-image:url("https://source.unsplash.com/random");
}
</style>
	
</head>
<body>
<h1>ROLY POLY KIDS:</h1>
<h2>fun educational activities for ages 0-10</h2> <a href =  "login">Login </a>&nbsp &nbsp &nbsp <a href =  "signup">Sign Up </a>&nbsp &nbsp &nbsp<a href =  "logout">Log out </a>
<br>

<h2>
Welcome! What do you want to do today?
</h2>


<a href =  "outdoor"> outdoor </a>
<br>
<a href =  "indoor"> indoor </a>
<br>
<a href =  "explore"> explore </a>
<br>
<P>  The time on the server is ${serverTime}. </P>

</body>
</html>

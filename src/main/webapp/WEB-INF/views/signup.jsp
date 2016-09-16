<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
input[type=text],[type=password] {
width: 35%;
height: 34px;
padding-left: 5px;
margin-bottom: 20px;
margin-top: 8px;
box-shadow: 0 0 5px #00F5FF;
border: 2px solid #00F5FF;
color: #4f4f4f;
font-size: 16px;
}
</style>
</head>
<body>
<form action="signupsubmit" method="post">
${warning}
<h1>Soon we will have a log in screen</h1><br>
First Name: <input type="text" name="firstName" ><br>
Last Name: <input type="text" name="lastName" ><br>
Email:&nbsp &nbsp <input type="text" name="email" ><br>
Password:<input type="password" name="passwd" ><br>
<br>
<br>
<br>
 <input type="submit"  value="Sign Up">
 </form>
</body>
</html>
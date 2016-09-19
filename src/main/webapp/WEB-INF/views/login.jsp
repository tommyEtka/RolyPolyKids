<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RolyPolyKids Login Form </title>
<meta name="robots" content="noindex, nofollow">
<!-- Include CSS File Here <link rel="stylesheet" href="css/style.css"/> -->
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Droid+Serif);
h2{
text-align: center;
font-size: 24px;
}
hr{
margin-bottom: 30px;
}
div.container{
width: 960px;
height: 610px;
margin:50px auto;
font-family: 'Droid Serif', serif;
position:relative;
}
div.main{
width: 320px;
margin-top: 80px;
float:left;
padding: 10px 55px 40px;
background-color: rgba(187, 255, 184, 0.65);
border: 15px solid white;
box-shadow: 0 0 10px;
border-radius: 2px;
font-size: 13px;
}
input[type=text],[type=password] {
width: 97.7%;
height: 34px;
padding-left: 5px;
margin-bottom: 20px;
margin-top: 8px;
box-shadow: 0 0 5px #00F5FF;
border: 2px solid #00F5FF;
color: #4f4f4f;
font-size: 16px;
}
label{
color: #464646;
text-shadow: 0 1px 0 #fff;
font-size: 14px;
font-weight: bold;
}
#login {
width: 100%;
background: linear-gradient(#22abe9 5%, #36caf0 100%);
border: 1px solid #0F799E;
font-size: 20px;
margin-top: 15px;
padding: 8px;
font-weight: bold;
cursor: pointer;
color: white;
text-shadow: 0px 1px 0px #13506D;
}
#login:hover{
background: linear-gradient(#36caf0 5%, #22abe9 100%);
}


</style>
<!-- Include CSS File Here -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="login.js"></script>
</head>
<body>
<h1>${warning}</h1>
<div class="container">
<div class="main">
<form class="form" action="loginPage" method="post" >
<h2>RolyPolyKids Login</h2>
<label>Email :</label>
<input type="text" name="demail" id="email">
<label>Password :</label>
<input type="password" name="password" id="password">
<input type="submit" name="login" id="login" value="Login" >
</form>
</div>
</div>

</body>
</html>


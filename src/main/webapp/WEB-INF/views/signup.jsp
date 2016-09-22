<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
@import url(https://fonts.googleapis.com/css?family=Droid+Serif);

h2 {
	text-align: center;
	font-size: 24px;
}

hr {
	margin-bottom: 30px;
}

div.container {
	width: 960px;
	height: 610px;
	margin: 50px auto;
	font-family: 'Droid Serif', serif;
	position: relative;
}

div.main {
	width: 320px;
	margin-top: 80px;
	float: left;
	padding: 10px 55px 40px;
	background-color: rgba(187, 255, 184, 0.65);
	border: 15px solid white;
	box-shadow: 0 0 10px;
	border-radius: 2px;
	font-size: 13px;
}

input[type=text], [type=password] {
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

label {
	color: #464646;
	text-shadow: 0 1px 0 #fff;
	font-size: 14px;
	font-weight: bold;
}

#signup {
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

#signup:hover {
	background: linear-gradient(#36caf0 5%, #22abe9 100%);
}
body {

        background-image:url("http://cdn.backgroundhost.com/backgrounds/subtlepatterns/green_dust_scratch.png");

}
/* input[type=text], [type=password] {
	width: 35%;
	height: 34px;
	padding-left: 5px;
	margin-bottom: 20px;
	margin-top: 8px;
	box-shadow: 0 0 5px #00F5FF;
	border: 2px solid #00F5FF;
	color: #4f4f4f;
	font-size: 16px;
} */
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="login.js"></script>
</head>
<body >
<div class="container">
<div class="main">
	<form name="sign_up_form" action="signupsubmit" method="post">
		<h1>${warning}</h1>
		<label>First Name:</label>
		<br><input type="text" name="firstName"><br>
		<label>Last Name:</label><br>
		<input type="text" name="lastName"><br>
		<label>Email :</label><br>
		<input type="text" name="email"><br>
		<label>Password:</label><br>
		<input type="password" name="passwd"><br> <br>
		<br> <br> <input type="submit" onClick="validateForm()"
			value="Sign Up">
	</form>
	<script type="text/javascript">
		function validateForm() {
			//  validateForm function starts here
			// Validate the fill in of First Name
			var x = document.forms["sign_up_form"]["firstName"].value;

			if (x == null || x == "") {
				alert("The first name must be filled out. Please try again.");
				return false;
			}

			if (!isNaN(x)) {
				//the value is a number

				alert(" The first name can not have a numeric value. Please try again.");
				return false;
			}
			// Validate the fill in of Last Name
			var x = document.forms["sign_up_form"]["lastName"].value;

			if (x == null || x == "") {
				alert("The last name must be filled out. Please try again.");
				return false;
			}
			if (!isNaN(x)) {
				//the value is a number
				alert("The last name can not have a numeric value. Please try again.");
				return false;
			}

			//code for email validation starts here
			var x = document.forms["sign_up_form"]["email"].value;
			var atpos = x.indexOf("@");
			var dotpos = x.lastIndexOf(".");
			if (atpos < 1 || dotpos<atpos+2 || dotpos+2 > == x.length) {
				alert("This is not a valid e-mail address. Please try again.");
				return false;
			}
			//code for email validation ends here
		}
	</script>
</div>
</div>
</body>
</html>
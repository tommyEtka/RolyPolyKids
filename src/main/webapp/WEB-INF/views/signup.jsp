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
<form name="sign_up_form"action="signupsubmit" method="post">
<h1>${warning}</h1>
<br>
First Name: <input type="text" name="firstName" ><br>
Last Name: <input type="text" name="lastName" ><br>
Email:&nbsp &nbsp <input type="text" name="email" ><br>
Password:<input type="password" name="passwd" ><br>
<br>
<br>
<br>
 <input type="submit" onClick="validateForm()" value="Sign Up">
 </form>
 <script type="text/javascript">
function validateForm()
{
//  validateForm function starts here
// Validate the fill in of First Name
var x=document.forms["sign_up_form"]["firstName"].value;

if (x==null || x=="")
{
alert("The first name must be filled out. Please try again.");
return false;
}

if(!isNaN(x)){
 //the value is a number
		
	alert(" The first name can not have a numeric value. Please try again.");
	return false;
	}
// Validate the fill in of Last Name
var x=document.forms["sign_up_form"]["lastName"].value;

if (x==null || x=="")
{
alert("The last name must be filled out. Please try again.");
return false;
}
if(!isNaN(x)){
 //the value is a number
	alert("The last name can not have a numeric value. Please try again.");
	return false;
 }
 
//code for email validation starts here
var x=document.forms["sign_up_form"]["email"].value;
var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2 >= x.length)
{
alert("This is not a valid e-mail address. Please try again.");
return false;
}
//code for email validation ends here
}
</script>
 
</body>
</html>
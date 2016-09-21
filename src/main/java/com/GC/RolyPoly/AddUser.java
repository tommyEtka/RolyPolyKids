package com.GC.RolyPoly;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Controller
public class AddUser {
	@RequestMapping(value = "signupsubmit", method = RequestMethod.POST)
	public String signup(HttpServletRequest request,Model model){
		String selectCommand;
		String firstName,lastName,email,passwd;
		boolean isValid = true;
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		email = request.getParameter("email");
		passwd = request.getParameter("passwd");
		
		 try {
			//load driver for mysql
			 Class.forName("com.mysql.jdbc.Driver");
			//store the info to the DB orders
			 Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1s1uxliw4eyl2.c51rrraraa3j.us-west-2.rds.amazonaws.com:3306/rolypolykids","scriblet","123usert");
			//command
			isValid = validateFlds(model, firstName, lastName, email, passwd);
			if (!isValid){
				//model.addAttribute("warning","All fields are mandatory. Please try again.");
				return "signup";
			}
			else
			{
				
				selectCommand = "insert into Users (firstName,lastName,email,password) values(?,?,?,?)";
				//create statement
				  PreparedStatement ps = cnn.prepareStatement(selectCommand);
				  ps.setString(1, firstName);
				  ps.setString(2, lastName);
				  ps.setString(3, email);
				  ps.setString(4, passwd);
				// use ps to execute the command
				   ps.executeUpdate(); 
				   
			  }
			 			 
			 return "login";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("Error","Error encountered restart app");
			return "errorpage";
		}
		
		
		
	}


	/**
	 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param passwd
	 */
	public boolean validateFlds(Model model, String firstName, String lastName, String email, String passwd) {
		boolean isValid = true;
		if (firstName.isEmpty()||
			lastName.isEmpty()||
			email.isEmpty() ||
			passwd.isEmpty()){
			isValid = false;
		}else if (firstName.equals("") && lastName.equals("") ){
			isValid = false;
		}
		if (firstName.matches("[0-9]+")){
			//model.addAttribute("warning","FirstName is not a numeric field. Please try again.");
			isValid = false;
		}
		if (lastName.matches("[0-9]+")){
			//model.addAttribute("warning","LastName is not a numeric field. Please try again.");
			isValid = false;
		}
		if (email.matches("[0-9]+")){
			//model.addAttribute("warning","email can not be all numeric characters.Please try again.");
			isValid = false;
		}
		if (passwd.matches("[0-9]+")){
			//model.addAttribute("warning","The password should be a mix of Number and Alphabet characters.Please try again.");
			isValid = false;
		}
		return isValid;
	}

	
	@RequestMapping(value = "signup")
	public String signupdir(){
		
		return "signup";
	}
	
	//checkLogin
	@RequestMapping(value="loginPage", method = RequestMethod.POST)
	 public String checkLogin(HttpServletRequest request,HttpSession session,Model model){

		String selectCommand;
		String email;
		String passwd;
		String pwd = "";
		ResultSet rs;
		email = request.getParameter("demail");
		passwd= request.getParameter("password");
		//System.out.println("You made it in the method :" +email);
		//System.out.println("You made it in the method :" +passwd);
		 try {
			//load driver for mysql
			 Class.forName("com.mysql.jdbc.Driver");
			//store the info to the DB orders
			 Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1s1uxliw4eyl2.c51rrraraa3j.us-west-2.rds.amazonaws.com:3306/rolypolykids","scriblet","123usert");
			//command
			if (email == null||email.isEmpty()|| passwd == null || passwd.isEmpty()){
				model.addAttribute("warning","All fields are mandatory. Please try again.");
				return "login";
			  }
			  else
			  {
				  
				  selectCommand = "select * from users where email = ? and password= ?";
				//create statement
				  PreparedStatement ps = cnn.prepareStatement(selectCommand);
				  ps.setString(1,email);
				  ps.setString(2,passwd);
				// use ps to execute the command
				   rs = ps.executeQuery(); 
				   
			  }
			 
			 if(!rs.first()){
				 model.addAttribute("warning","You have entered the wrong email address/password. Please try again.");
				 return "login";
			 }


			 
			  //prepare data and send back to view
			 boolean hasData = false;
			 //System.out.println("Before session");
			 hasData= rs.first();
			 //System.out.println("has data " + hasData);
			  if(hasData){
				  HttpSession session1 = request.getSession();
				  session1.setAttribute("email", email);
				  session1.setAttribute("log", true);
				  System.out.println("session set");
				  
			 }
			  
			  return "home";
			 
			 
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("Error","Error encountered restart app");
			return "errorpage";
		}
		
		 
	 }
	@RequestMapping(value = "login")
	public String logindir(){
		
		return "login";
	}
	@RequestMapping(value="logout")
	 public String SubmitLogout(HttpSession session)
        {
		  session.setAttribute("log", false);
			return "logout";
            
        }

	

	

}

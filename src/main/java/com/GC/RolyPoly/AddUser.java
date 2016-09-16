package com.GC.RolyPoly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rolypolykids","root","vsmith38282");
			//command
			if (firstName.isEmpty()||
				lastName.isEmpty()||
				email.isEmpty() ||
				passwd.isEmpty()){
				isValid = false;
			}else if (firstName.equals("") && lastName.equals("") ){
				isValid = false;
			}
			//if (firstName.)
			
			if (false){
				model.addAttribute("warning","All fields are mandatory. Please try again.");
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
			return "errorPage";
		}
		
		
		
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
		ResultSet rs;
		email = request.getParameter("demail");
		passwd= request.getParameter("password");
		System.out.println("You made it in the method :" +email);
		System.out.println("You made it in the method :" +passwd);
		 try {
			//load driver for mysql
			 Class.forName("com.mysql.jdbc.Driver");
			//store the info to the DB orders
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rolypolykids","root","vsmith38282");
			//command
			if (email == null||email.isEmpty()|| passwd == null || passwd.isEmpty()){
				model.addAttribute("warning","All fields are mandatory. Please try again.");
				return "login";
			  }
			  else
			  {
				  selectCommand = "select * from users where email = ?";
				//create statement
				  PreparedStatement ps = cnn.prepareStatement(selectCommand);
				  ps.setString(1,email);
				// use ps to execute the command
				   rs = ps.executeQuery(); 
				   
			  }
			 
			 
			  //prepare data and send back to view
			 boolean hasData = false;
			 System.out.println("Before session");
			 hasData= rs.first();
			 System.out.println("has data " + hasData);
			  if(hasData){
				  session.setAttribute("log", true);
				  System.out.println("session set");
				  
			 }
			  
			  return "home";
			 
			 
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("Error","Error encountered restart app");
			return "errorPage";
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

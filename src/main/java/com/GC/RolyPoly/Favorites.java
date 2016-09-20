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
	public class Favorites {
		@RequestMapping(value = "addFavorites", method = RequestMethod.POST)
		public String insertFavorite(HttpServletRequest request,Model model){
			String selectCommand;
			String pinURL;
			pinURL = request.getParameter("pinURL");
			
			
			 /*try {
				//load driver for mysql
				 Class.forName("com.mysql.jdbc.Driver");
				//store the info to the DB orders
				Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rolypolykids","root","vsmith38282");
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
				return "errorPage";
			}*/
		
		
			return null;
			}
	}

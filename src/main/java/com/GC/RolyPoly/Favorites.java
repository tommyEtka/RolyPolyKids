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
		@RequestMapping(value = "addFavorite", method = RequestMethod.GET)
		public String insertFavorite(HttpServletRequest request,HttpSession session,Model model){
			String selectCommand;
			String pinId,email = null,description = null;
			
			pinId = request.getParameter("pin");
			//check session
			HttpSession sessionExist = request.getSession(false);
			if (sessionExist == null) {
			    // Not created yet. force login
			    //sessionExist = request.getSession();
				System.out.println("No session exist");
			} else {
			    // Already created.
				System.out.println("session exist" + sessionExist);
			}
			System.out.println("You have passed = " + pinId);
//			 try {
//				//load driver for mysql
//				 Class.forName("com.mysql.jdbc.Driver");
//				//store the info to the DB orders
//				Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1s1uxliw4eyl2.c51rrraraa3j.us-west-2.rds.amazonaws.com:3306/rolypolykids","scriblet","123usert");
//				//command
//					selectCommand = "insert into user_favorites (pinId,description,useremail) values(?,?,?)";
//					//create statement
//					  PreparedStatement ps = cnn.prepareStatement(selectCommand);
//					  ps.setString(1, pinId);
//					  ps.setString(2, description);
//					  ps.setString(3, email);
//					 
//					// use ps to execute the command
//					   ps.executeUpdate(); 
//					   
//				 
//				 			 
//					   return "outdoor";
//			} 
//			 catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				model.addAttribute("Error","Error encountered restart app");
//				return "errorPage";
//			}
		
		
			return "outdoor";
			}
	}

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
	public class Favorites {
		@RequestMapping(value = "addFavorite", method = RequestMethod.GET)
		public String insertFavorite(HttpServletRequest request,HttpSession session,Model model){
			String selectCommand;
			String pinId,description = null;
			String email = null;
			Object sessObj = null;
			Object sessObj1 = null;
			pinId = request.getParameter("pin");
			//check session
			 HttpSession session1 = request.getSession();
			 Object sessionExist = session1.getAttribute("log");
			 String sessionEmail = (String) session1.getAttribute("email");
			 System.out.println("Before getting session attribute" + sessionExist);
			 System.out.println("Before getting session email" + sessionEmail);
			
			
			
			if (sessionEmail == null) {
			    // Not created yet. force login
			    //sessionExist = request.getSession();
				System.out.println("No session exist");
				
				model.addAttribute("warning","You must login in order to save a favorite.  If you are a member, Please sign up.");
				return "login";
			} else {
			    // Already created.
				System.out.println("session exist" + sessionExist);
				email =	sessionEmail;
			}
			System.out.println("You have passed = " + pinId);
			 try {
				//load driver for mysql
				 Class.forName("com.mysql.jdbc.Driver");
				//store the info to the DB orders
				Connection cnn = DriverManager.getConnection("jdbc:mysql://aa1s1uxliw4eyl2.c51rrraraa3j.us-west-2.rds.amazonaws.com:3306/rolypolykids","scriblet","123usert");
				//command
					selectCommand = "insert into user_favorites (pinId,description,useremail) values(?,?,?)";
					//create statement
					  PreparedStatement ps = cnn.prepareStatement(selectCommand);
					  ps.setString(1, pinId);
					  ps.setString(2, description);
					  ps.setString(3, email);
					 
					// use ps to execute the command
					   ps.executeUpdate(); 
					   
					   
				 		 
					   return "favorites";
			} 
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				model.addAttribute("Error","Error encountered restart app");
				return "errorpage";
			}
		
		
			
			}
//		public String redisplayOutdoor(HttpServletRequest request, Model model) {
//
//			try {
//
//				// create object type httpClient call http
//
//				HttpClient http = HttpClientBuilder.create().build();
//
//				// https://www.pinterest.com/<username>/<board>.rss
//
//				// https://www.pinterest.com/parkerlondonr/sample/
//
//				HttpHost host = new HttpHost("www.pinterest.com", 443, "https");
//
//				// HttpGet getPage = new HttpGet("/parkerlondonr/Sample.rss");
//
//				// HttpGet getPage = new
//				// HttpGet("/parkerlondonr/indoorcraftsage3to6.rss");
//
//				HttpGet getPage = new HttpGet("/parkerlondonr/outdooractivities.rss");
//
//				// execute the http request and get the http response
//
//				HttpResponse resp = http.execute(host, getPage);
//
//				// Way to display data using DOM(document object model) tree format
//
//				String result = "";
//
//				String xmlString = EntityUtils.toString(resp.getEntity());
//
//				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//				DocumentBuilder db = factory.newDocumentBuilder();
//
//				InputSource inStream = new InputSource();
//
//				inStream.setCharacterStream(new StringReader(xmlString));
//
//				Document doc = db.parse(inStream);
//
//				String outdoorInfo = "empty";
//				String favoritesTag = "";
//
//				NodeList nl = doc.getElementsByTagName("description");
//
//				// System.out.println("BeforeLoop "+ nl.getLength());
//
//				for (int i = 1; i < nl.getLength(); i++) {
//
//					System.out.println("inLoop " + nl.item(i).getFirstChild().getNodeValue().trim());
//
//					org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);
//
//					outdoorInfo = nameElement.getFirstChild().getNodeValue().trim();
//					
//					favoritesTag = parseFavsFrom(outdoorInfo);
//					
//					result += outdoorInfo + "&nbsp&nbsp&nbsp&nbsp&nbsp<a href='addFavorite?pin="+favoritesTag+"'>Add To Favorites</a>" + "<br>";
//					
//					
//					
//					
//				}
//				model.addAttribute("alert", "Favorite saved");
//				model.addAttribute("pageData", result);
//
//			}
//
//			catch (Exception e)
//
//			{
//
//				model.addAttribute("Error", e.getMessage());
//
//				return "errorpage";
//
//			}
//
//			return "outdoorfav";
//
//		}
//
//		private String parseFavsFrom(String outdoorInfo) {
//			int beginIndex =14;
//			int endIndex=32;
//			return outdoorInfo.substring(beginIndex,endIndex);
//			
//		}
	}

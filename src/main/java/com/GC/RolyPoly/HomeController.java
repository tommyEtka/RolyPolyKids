package com.GC.RolyPoly;

//ROLY POLY HOME CONTROLLER
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.io.StringReader;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	@RequestMapping(value = "outdoor", method = RequestMethod.GET)

	public String processOutdoor(HttpServletRequest request, Model model) {
		try{
			// create object type httpClient call http
			HttpClient http = HttpClientBuilder.create().build();
			//https://www.pinterest.com/<username>/<board>.rss
			//https://www.pinterest.com/parkerlondonr/sample/
			HttpHost host = new HttpHost("www.pinterest.com", 443, "https");
			//HttpGet getPage = new HttpGet("/parkerlondonr/Sample.rss");
			HttpGet getPage = new HttpGet("/parkerlondonr/feed.rss");
			// execute the http request and get the http response
			HttpResponse resp = http.execute(host, getPage);
			
			//Way to display data using DOM(document object model) tree format
			String result = "";
			String xmlString = EntityUtils.toString(resp.getEntity());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			InputSource inStream = new InputSource();
			inStream.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(inStream);
			String weatherForeCast = "empty";
			NodeList nl = doc.getElementsByTagName("description");

			//System.out.println("BeforeLoop "+ nl.getLength());
			for (int i = 1; i < nl.getLength(); i++) {
			    System.out.println("inLoop "+ nl.item(i).getFirstChild().getNodeValue().trim());
				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);
				weatherForeCast = nameElement.getFirstChild().getNodeValue().trim();
				result += ( weatherForeCast );
			}
			model.addAttribute("pageData", result);
		}
		catch(Exception e)
		{
			model.addAttribute("Error", e.getMessage());
			return "errorpage";
		}
		return "outdoor";
	}
	
	@RequestMapping(value = "indoor", method = RequestMethod.GET)

	public String processIndoor(HttpServletRequest request, Model model) {

		return "indoor";
	}
	
	@RequestMapping(value = "explore", method = RequestMethod.GET)

	public String processExplore(HttpServletRequest request, Model model) {

		return "explore";
	}
	@RequestMapping(value="feedPins", method = RequestMethod.GET)
	public String getPinInfo1(Model model){
		try{
			// create object type httpClient call http
			HttpClient http = HttpClientBuilder.create().build();
			//https://www.pinterest.com/<username>/<board>.rss
			HttpHost host = new HttpHost("www.pinterest.com", 443, "https");
			HttpGet getPage = new HttpGet("/RolyPolyKids/Sample.rss");
		
			// execute the http request and get the http response
			HttpResponse resp = http.execute(host, getPage);
			
			//Way to display data using DOM(document object model) tree format
			String result = "";
			String xmlString = EntityUtils.toString(resp.getEntity());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			InputSource inStream = new InputSource();
			inStream.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(inStream);
			String weatherForeCast = "empty";
			NodeList nl = doc.getElementsByTagName("description");

			//System.out.println("BeforeLoop "+ nl.getLength());
			for (int i = 1; i < nl.getLength(); i++) {
			    System.out.println("inLoop "+ nl.item(i).getFirstChild().getNodeValue().trim());
				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);
				weatherForeCast = nameElement.getFirstChild().getNodeValue().trim();
				result += ( weatherForeCast );
			}
			model.addAttribute("pageData", result);
		}
		catch(Exception e)
		{
			model.addAttribute("Error", e.getMessage());
			return "errorpage";
		}
		
		return "outdoor";
	}
}
// @RequestMapping(value = "myForm", method = RequestMethod.GET)
// public String processForm() {
// return "outdoor";
// }

package com.GC.RolyPoly;

//ROLY POLY HOME CONTROLLER

import java.text.DateFormat;

import java.util.ArrayList;

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
 * 
 * Handles requests for the application home page.
 * 
 */

@Controller

public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * 
	 * Simply selects the home view to render by returning its name.
	 * 
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String home(Locale locale, Model model) {

		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "loginHome";

	}

	@RequestMapping(value = "outdoor", method = RequestMethod.GET)

	public String processOutdoor(HttpServletRequest request, Model model) {

		try {

			// create object type httpClient call http

			HttpClient http = HttpClientBuilder.create().build();

			// https://www.pinterest.com/<username>/<board>.rss

			// https://www.pinterest.com/parkerlondonr/sample/

			HttpHost host = new HttpHost("www.pinterest.com", 443, "https");

			// HttpGet getPage = new HttpGet("/parkerlondonr/Sample.rss");

			// HttpGet getPage = new
			// HttpGet("/parkerlondonr/indoorcraftsage3to6.rss");

			HttpGet getPage = new HttpGet("/parkerlondonr/outdooractivities.rss");

			// execute the http request and get the http response

			HttpResponse resp = http.execute(host, getPage);

			// Way to display data using DOM(document object model) tree format

			String result = "";

			String xmlString = EntityUtils.toString(resp.getEntity());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = factory.newDocumentBuilder();

			InputSource inStream = new InputSource();

			inStream.setCharacterStream(new StringReader(xmlString));

			Document doc = db.parse(inStream);

			String outdoorInfo = "empty";
			String favoritesTag = "";

			NodeList nl = doc.getElementsByTagName("description");

			// System.out.println("BeforeLoop "+ nl.getLength());

			for (int i = 1; i < nl.getLength(); i++) {

				System.out.println("inLoop " + nl.item(i).getFirstChild().getNodeValue().trim());

				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);

				outdoorInfo = nameElement.getFirstChild().getNodeValue().trim();
				
				favoritesTag = parseFavsFrom(outdoorInfo);
				
				result += outdoorInfo + favoritesTag + "<br>";
				
				
				
				
			}

			model.addAttribute("pageData", result);

		}

		catch (Exception e)

		{

			model.addAttribute("Error", e.getMessage());

			return "errorpage";

		}

		return "outdoor";

	}

	private String parseFavsFrom(String outdoorInfo) {
		int beginIndex =14;
		int endIndex=32;
		return outdoorInfo.substring(beginIndex,endIndex);
		
	}

	@RequestMapping(value = "indoor", method = RequestMethod.GET)

	public String processIndoor(HttpServletRequest request, Model model) {

		return "indoor";

	}

	@RequestMapping(value = "crafts", method = RequestMethod.GET)

	public String processCrafts(HttpServletRequest request, Model model) {

		try {

			// create object type httpClient call http

			HttpClient http = HttpClientBuilder.create().build();

			// https://www.pinterest.com/<username>/<board>.rss

			// https://www.pinterest.com/parkerlondonr/sample/

			HttpHost host = new HttpHost("www.pinterest.com", 443, "https");

			// HttpGet getPage = new HttpGet("/parkerlondonr/Sample.rss");

			// HttpGet getPage = new
			// HttpGet("/parkerlondonr/indoorcraftsage3to6.rss");

			HttpGet getPage = new HttpGet("/parkerlondonr/indoorcraftsage3to6.rss");

			// execute the http request and get the http response

			HttpResponse resp = http.execute(host, getPage);

			// Way to display data using DOM(document object model) tree format

			String result = "";

			String xmlString = EntityUtils.toString(resp.getEntity());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = factory.newDocumentBuilder();

			InputSource inStream = new InputSource();

			inStream.setCharacterStream(new StringReader(xmlString));

			Document doc = db.parse(inStream);

			NodeList nl = doc.getElementsByTagName("description");

			// we need to add more nodelists?

			NodeList linkNode = doc.getElementsByTagName("link");

			NodeList titleNode = doc.getElementsByTagName("title");

			// NodeList imageNode = doc.getElementsByTagName("img src");

			String craftChoice = "";

			String link = "";

			String title = "";

			ArrayList<CraftInfo> list = new ArrayList<CraftInfo>();

			// System.out.println("BeforeLoop "+ nl.getLength());

			for (int i = 1; i < nl.getLength(); i++) {

				System.out.println("inLoop " + nl.item(i).getFirstChild().getNodeValue().trim());

				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);

				org.w3c.dom.Element linkElement = (org.w3c.dom.Element) linkNode.item(i);

				org.w3c.dom.Element titleElement = (org.w3c.dom.Element) titleNode.item(i);

				craftChoice = nameElement.getFirstChild().getNodeValue().trim();

				link = linkElement.getFirstChild().getNodeValue().trim();

				title = titleElement.getFirstChild().getNodeValue().trim();

				list.add(new CraftInfo(link, craftChoice, title));

				result += (craftChoice);

			}

			model.addAttribute("pageData", result);

			model.addAttribute("craftData", list);

		}

		catch (Exception e)

		{

			model.addAttribute("Error", e.getMessage());

			return "errorpage";

		}

		return "crafts";

	}

	@RequestMapping(value = "explore", method = RequestMethod.GET)

	public String processExplore(HttpServletRequest request, Model model) {

		return "explore";

	}

	@RequestMapping(value = "recipes", method = RequestMethod.GET)

	public String getRecipes(Model model) {

		try {

			// create object type httpClient call http

			HttpClient http = HttpClientBuilder.create().build();

			// https://www.pinterest.com/<username>/<board>.rss

			HttpHost host = new HttpHost("www.pinterest.com", 443, "https");

			HttpGet getPage = new HttpGet("/parkerlondonr/recipes.rss");

			// execute the http request and get the http response

			HttpResponse resp = http.execute(host, getPage);

			// Way to display data using DOM(document object model) tree format

			String result = "";

			String xmlString = EntityUtils.toString(resp.getEntity());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = factory.newDocumentBuilder();

			InputSource inStream = new InputSource();

			inStream.setCharacterStream(new StringReader(xmlString));

			Document doc = db.parse(inStream);

			String weatherForeCast = "empty";

			NodeList nl = doc.getElementsByTagName("description");

			// System.out.println("BeforeLoop "+ nl.getLength());

			for (int i = 1; i < nl.getLength(); i++) {

				System.out.println("inLoop " + nl.item(i).getFirstChild().getNodeValue().trim());

				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);

				weatherForeCast = nameElement.getFirstChild().getNodeValue().trim();

				result += (weatherForeCast);

			}

			model.addAttribute("pageData", result);

		}

		catch (Exception e)

		{

			model.addAttribute("Error", e.getMessage());

			return "errorpage";

		}

		return "recipePage";

	}

	@RequestMapping(value = "scienceExperiments", method = RequestMethod.GET)

	public String getScienceInfo(Model model) {

		try {

			// create object type httpClient call http

			HttpClient http = HttpClientBuilder.create().build();

			// https://www.pinterest.com/<username>/<board>.rss

			HttpHost host = new HttpHost("www.pinterest.com", 443, "https");

			HttpGet getPage = new HttpGet("/parkerlondonr/ScienceExperiments.rss");

			// execute the http request and get the http response

			HttpResponse resp = http.execute(host, getPage);

			// Way to display data using DOM(document object model) tree format

			String result = "";

			String xmlString = EntityUtils.toString(resp.getEntity());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = factory.newDocumentBuilder();

			InputSource inStream = new InputSource();

			inStream.setCharacterStream(new StringReader(xmlString));

			Document doc = db.parse(inStream);

			String weatherForeCast = "empty";

			NodeList nl = doc.getElementsByTagName("description");

			// System.out.println("BeforeLoop "+ nl.getLength());

			for (int i = 1; i < nl.getLength(); i++) {

				System.out.println("inLoop " + nl.item(i).getFirstChild().getNodeValue().trim());

				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);

				weatherForeCast = nameElement.getFirstChild().getNodeValue().trim();

				result += (weatherForeCast);

			}

			model.addAttribute("pageData", result);

		}

		catch (Exception e)

		{

			model.addAttribute("Error", e.getMessage());

			return "errorpage";

		}

		return "scienceExperiments";

	}

}
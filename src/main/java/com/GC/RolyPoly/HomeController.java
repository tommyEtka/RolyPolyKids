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

	@RequestMapping(value = "home", method = RequestMethod.GET)

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

			String outdoorImg = "";
			String getOutdoorImg = "";
			String result = "";
			String result2 = "";

			String xmlString = EntityUtils.toString(resp.getEntity());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = factory.newDocumentBuilder();

			InputSource inStream = new InputSource();

			inStream.setCharacterStream(new StringReader(xmlString));

			Document doc = db.parse(inStream);

			String outdoorInfo = "empty";
			String favoritesTag = "";

			NodeList nl = doc.getElementsByTagName("description");

			NodeList linkNode = doc.getElementsByTagName("link");

			NodeList titleNode = doc.getElementsByTagName("title");

			// System.out.println("BeforeLoop "+ nl.getLength());

			String outdoorChoice = "";
			String link = "";
			String title = "";
			String imgSrc = "";
			String addFav ="";

			ArrayList<OutdoorInfo> list = new ArrayList<OutdoorInfo>();

			for (int i = 1; i < nl.getLength(); i++) {

				System.out.println("inLoop " + nl.item(i).getFirstChild().getNodeValue().trim());

				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);

				outdoorImg = nameElement.getFirstChild().getNodeValue().trim();

				org.w3c.dom.Element linkElement = (org.w3c.dom.Element) linkNode.item(i);

				org.w3c.dom.Element titleElement = (org.w3c.dom.Element) titleNode.item(i);

				imgSrc = getOutdoorImg = "<img src=" + "\"" + parseOutdoorImg(outdoorImg) + "\"" + "/img>";

				outdoorChoice = nameElement.getFirstChild().getNodeValue().trim();

				link = linkElement.getFirstChild().getNodeValue().trim();

				title = titleElement.getFirstChild().getNodeValue().trim();




				outdoorInfo = nameElement.getFirstChild().getNodeValue().trim();

				favoritesTag = parseOutdoorImg(outdoorImg);

				result += outdoorImg + "&nbsp&nbsp&nbsp&nbsp&nbsp<a href='addFavorite?pin="+favoritesTag+"'>Add To Favorites</a>" + "<br>";

				list.add(new OutdoorInfo(link, getOutdoorImg, title, favoritesTag));

				result += (outdoorChoice);
				result2 += (getOutdoorImg);




			}

			model.addAttribute("pageData", result);
			model.addAttribute("outdoorData", list);
			model.addAttribute("outdoorImage", result2);

		}

		catch (Exception e)

		{

			model.addAttribute("Error", e.getMessage());

			return "errorpage";

		}

		return "outdoor";

	}

	private String parseFavsFrom(String outdoorInfo) {
		int beginIndex = 14;
		int endIndex = 32;
		return outdoorInfo.substring(beginIndex, endIndex);

	}
	private String parseOutdoorImg(String outdoorImg) {
		int beginIndex = outdoorImg.indexOf("http");
		int endIndex = outdoorImg.lastIndexOf("\"");
		return outdoorImg.substring(beginIndex, endIndex);

	}

	// this is for crafts
	private String parseImg(String craftImg) {
		// int beginIndex = craftImg.indexOf("&lt");
		// int endIndex= craftImg.lastIndexOf("/a&gt");
		int beginIndex = craftImg.indexOf("http");
		int endIndex = craftImg.lastIndexOf("\"");
		return craftImg.substring(beginIndex, endIndex);

	}

	@RequestMapping(value = "indoor", method = RequestMethod.GET)

	public String processIndoor(HttpServletRequest request, Model model) {

		return "indoor";

	}
	
	@RequestMapping(value = "contact", method = RequestMethod.GET)

	public String processContact(HttpServletRequest request, Model model) {

		return "contact";

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

			String craftImg = "";
			String getCraftImg = "";
			String result = "";
			String result2 = "";

			String xmlString = EntityUtils.toString(resp.getEntity());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = factory.newDocumentBuilder();

			InputSource inStream = new InputSource();

			inStream.setCharacterStream(new StringReader(xmlString));

			Document doc = db.parse(inStream);

			NodeList nl = doc.getElementsByTagName("description");

			NodeList linkNode = doc.getElementsByTagName("link");

			NodeList titleNode = doc.getElementsByTagName("title");

			// NodeList imageNode = doc.getElementsByTagName("img src");

			String craftChoice = "";
			String link = "";
			String title = "";
			String imgSrc = "";
			String favoritesTag = "";
			String addFav ="";
			ArrayList<CraftInfo> list = new ArrayList<CraftInfo>();

			// System.out.println("BeforeLoop "+ nl.getLength());

			for (int i = 1; i < nl.getLength(); i++) {

				System.out.println("inLoop " + nl.item(i).getFirstChild().getNodeValue().trim());

				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);

				craftImg = nameElement.getFirstChild().getNodeValue().trim();

				org.w3c.dom.Element linkElement = (org.w3c.dom.Element) linkNode.item(i);

				org.w3c.dom.Element titleElement = (org.w3c.dom.Element) titleNode.item(i);

				imgSrc = getCraftImg = "<img src=" + "\"" + parseImg(craftImg) + "\"" + "/img>";

				craftChoice = nameElement.getFirstChild().getNodeValue().trim();

				link = linkElement.getFirstChild().getNodeValue().trim();

				title = titleElement.getFirstChild().getNodeValue().trim();
				//get pin id to save favorite
				favoritesTag = parseFavsFrom(craftChoice);
				//add link format to show favorite link
				//addFav =  "<a href='addFavorite?pin="+favoritesTag+"'>Add To Favorites</a>";
				list.add(new CraftInfo(link, getCraftImg, title,favoritesTag));
				
				result += (craftChoice);
				result2 += (getCraftImg);

			}

			model.addAttribute("pageData", result);

			model.addAttribute("craftData", list);
			model.addAttribute("craftImage", result2);

		}

		catch (Exception e)

		{

			model.addAttribute("Error", e.getMessage());

			return "errorpage";

		}

		return "crafts";

	}
	

//updated
	private String parseRecImg(String recImg) {
		int beginIndex = recImg.indexOf("http");
		int endIndex = recImg.lastIndexOf("\"");
		return recImg.substring(beginIndex, endIndex);
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

			String recImg = "";
			String getRecImg = "";
			String result = "";
			String result2 = "";
			
			String xmlString = EntityUtils.toString(resp.getEntity());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = factory.newDocumentBuilder();

			InputSource inStream = new InputSource();

			inStream.setCharacterStream(new StringReader(xmlString));

			Document doc = db.parse(inStream);

			String weatherForeCast = "empty";

			NodeList nl = doc.getElementsByTagName("description");

			NodeList linkNode = doc.getElementsByTagName("link");

			NodeList titleNode = doc.getElementsByTagName("title");


			String recChoice = "";
			String link = "";
			String title = "";
			String imgSrc = "";
			String favoritesTag = "";
			String addFav ="";
			ArrayList<RecipesInfo> list = new ArrayList<RecipesInfo>();

			for (int i = 1; i < nl.getLength(); i++) {

				System.out.println("inLoop " + nl.item(i).getFirstChild().getNodeValue().trim());

				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);

				recImg = nameElement.getFirstChild().getNodeValue().trim();

				org.w3c.dom.Element linkElement = (org.w3c.dom.Element) linkNode.item(i);

				org.w3c.dom.Element titleElement = (org.w3c.dom.Element) titleNode.item(i);

				imgSrc = getRecImg = "<img src=" + "\"" + parseRecImg(recImg) + "\"" + "/img>";

				recChoice = nameElement.getFirstChild().getNodeValue().trim();

				link = linkElement.getFirstChild().getNodeValue().trim();

				title = titleElement.getFirstChild().getNodeValue().trim();
				//get pin id to save favorite
				favoritesTag = parseFavsFrom(recChoice);
				System.out.println("Is fav null? :"+favoritesTag);
				list.add(new RecipesInfo(link, getRecImg, title,favoritesTag));

				result += (recChoice);
				result2 += (getRecImg);

			}

			model.addAttribute("pageData", result);
			model.addAttribute("recData", list);
			model.addAttribute("recImage", result2);

		}


		catch (Exception e)

		{

			model.addAttribute("Error", e.getMessage());

			return "errorpage";

		}

		return "recipePage";

	}


	private String parseSEImg(String seImg) {
		int beginIndex = seImg.indexOf("http");
		int endIndex = seImg.lastIndexOf("\"");
		return seImg.substring(beginIndex, endIndex);
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

			String seImg = "";
			String getSEImg = "";
			String result = "";
			String result2 = "";

			String xmlString = EntityUtils.toString(resp.getEntity());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = factory.newDocumentBuilder();

			InputSource inStream = new InputSource();

			inStream.setCharacterStream(new StringReader(xmlString));

			Document doc = db.parse(inStream);

			String weatherForeCast = "empty";

			NodeList nl = doc.getElementsByTagName("description");
			NodeList linkNode = doc.getElementsByTagName("link");
			NodeList titleNode = doc.getElementsByTagName("title");


			String seChoice = "";
			String link = "";
			String title = "";
			String imgSrc = "";
			String favoritesTag = "";
			String addFav ="";
			ArrayList<SEInfo> list = new ArrayList<SEInfo>();


			for (int i = 1; i < nl.getLength(); i++) {

				System.out.println("inLoop " + nl.item(i).getFirstChild().getNodeValue().trim());

				org.w3c.dom.Element nameElement = (org.w3c.dom.Element) nl.item(i);

				seImg = nameElement.getFirstChild().getNodeValue().trim();

				org.w3c.dom.Element linkElement = (org.w3c.dom.Element) linkNode.item(i);

				org.w3c.dom.Element titleElement = (org.w3c.dom.Element) titleNode.item(i);

				imgSrc = getSEImg = "<img src=" + "\"" + parseSEImg(seImg) + "\"" + "/img>";

				seChoice = nameElement.getFirstChild().getNodeValue().trim();

				link = linkElement.getFirstChild().getNodeValue().trim();

				title = titleElement.getFirstChild().getNodeValue().trim();
				//get pin id to save favorite
				favoritesTag = parseFavsFrom(seChoice);
				list.add(new SEInfo(link, getSEImg, title,favoritesTag));

				result += (seChoice);
				result2 += (getSEImg);

			}

			model.addAttribute("pageData", result);
			model.addAttribute("seData", list);
			model.addAttribute("seImage", result2);

		}


		catch (Exception e)

		{

			model.addAttribute("Error", e.getMessage());

			return "errorpage";

		}

		return "scienceExperiments";


	}

}
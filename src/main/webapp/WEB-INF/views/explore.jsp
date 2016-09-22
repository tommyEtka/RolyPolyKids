


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
  <head>
    <meta charset="UTF-8">
    <title>Go Explore</title>
    
    
<link href="https://fonts.googleapis.com/css?family=Kameron" rel="stylesheet">
    
    
<link rel="stylesheet" href="resources/test/css/style.css">
        
<style>
body {
		background-image:url("http://cdn.backgroundhost.com/backgrounds/subtlepatterns/green_dust_scratch.png");
}
</style>

  <spring:url value="/resources/main.css"  var="mainCss"/>
  <link href="${mainCss}"  rel="stylesheet"/>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <!--    <a class="navbar-brand" href="#">Logo</a>--> 
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      <li><a href="home">Home</a></li>
        <li><a href="indoor">Indoor</a></li>
        <li><a href="outdoor">Outdoor</a></li>
        <li><a href="explore">Explore</a></li>
        <li><a href="contact">Contact</a></li>
         </ul>
        </div>
  </div>
</nav>
${alert}
<div class="container">
  <div class="row">
    <div class="col-sm-12">


</div>
  </div>
  </div>

<br> 



  </head>

  <body>
<br>
<br>
<br>
<br>
<div class="cards_wrapper">
  <div class="card unfolded today">
    <div class="card_description">
      <div class="date">23</div>
      <div class="title">SEPTEMBER (Friday) </div>
    </div>
    <div class="alarm_item top">
      <div class="time_block">
        <div class="time">10:30</div>
      </div>
      <div class="day_part">AM</div>
      <div  class="alarm_item_description"> 
      
        <b>Fall Toddler Story Time at the Fraser Public Library 
       </b>
        <p>Children ages 3 to 5 will listen to stories, play games, and make an occasional craft in each story time session. Call for more information.  Free event. </p> <p>(586) 293-2055 </p>
        </div>
    </div>
    <div class="alarm_item bottom">
      <div class="time_block">
        <div class="time">7:00</div>
      </div>
      <div class="day_part">PM</div>
      <div class="alarm_item_description"> <b>Push Pin Art at Ann Arbor District Library Pittsfield Branch</b> 
        <p> Kids in sixth grade-plus create an all-their-own piece of push pin art they can hang in their room or other personal space. Pre-register ASAP in advance.</p>  </div>
    </div>
    <div class="alarm_item top">
      <div class="time_block">
        <div class="time">8:00</div>
      </div>
      <div class="day_part">PM</div>
      <div  class="alarm_item_description"> 
        
        <b> Rockin Glow Bowl - Classic Lanes in Rochester
       </b>
        <p>Take your family bowling under the glow lights Friday at Bowl Classic Lanes </p>
 <p>         
2145 Avon Industrial Dr, Rochester, Michigan 48309  </p>
      </div>
    </div>
  </div>
  
  
  <div class="card folded tomorrow">
    <div class="card_description">
      <div class="date">24</div>
      <div class="title">SEPTEMBER (Saturday)</div>
    </div>
    <div class="alarm_item top">
      <div class="time_block">
        <div class="time">06:00</div>
      </div>
      <div class="day_part">AM</div>
      <div class="alarm_item_description"> <b> Lowe’s Free Build and Grow Clinics for Kids</b>
        <p>Lowe’s Free Build and Grow Clinic for Kids. Bring the kids into any Lowe’s store and build a FREE wooden project. Each participant also receives a free apron, goggles, a project themed patch, and a certification of merit upon completion of their project.  </p>
      </div>
    </div>
    <div class="alarm_item bottom">
      <div class="time_block">
        <div class="time">10:00</div>
      </div>
      <br>
      <div class="day_part">AM</div>
      <div class="alarm_item_description"> <b> Creatures of Light at the Michigan Science Center</b>
              <p>This exhibit gives you the chance to dive into the world of deep-sea animals and organisms that glow. Runs September 24 through January 15.  Admission: $22/adults, $19/ages 2-12, free/under 2. </p>
        <p> Michigan Science Center, 5020 John R St., Detroit </p>
      </div>
    </div>
  </div>

      
  

<div class="cards_wrapper">
  <div class="card unfolded today">
    <div class="card_description">
      <div class="date">25</div>
      <div class="title">SEPTEMBER  (Sunday)</div>
    </div>
    <div class="alarm_item top">
      <div class="time_block">
        <div class="time">12:00</div>
      </div>
      <div class="day_part">PM</div>
      <div  class="alarm_item_description"> 
   
        <b>Education Expo at the Cranbrook Institute of Science
       </b>
        <p>Metro Parent hosts its annual Education Expo to give families the chance to see what academic and extracurricular options are here in southeast Michigan for kids. </p> <p>Cranbrook Institute of Science, 39221 Woodward Ave., Bloomfield Hills </p>
        </div>
    </div>
    <div class="alarm_item bottom">
      <div class="time_block">
        <div class="time">10:00</div>
      </div>
      <div class="day_part">AM</div>
      <div class="alarm_item_description"> <b>Fall Color Car Classic at Independence Oaks County Park</b> 
        <p> Check out early 1900s antique cars, ’40s street rods ’50s to ’90s classics, muscle cars, corvettes, vans and more.</p>  </div>
    </div>
    
      </div>
    </div>
  </div>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>

        <script src="resources/test/js/index.js"></script>

  </body>
</html>
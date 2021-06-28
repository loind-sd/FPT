<%-- 
    Document   : slider
    Created on : Mar 15, 2021, 3:30:08 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/slider.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/modernizr.custom.28468.js"></script>
	<script type="text/javascript" src="js/jquery.cslider.js"></script>
	<script type="text/javascript">
		$(function () {
			$('#da-slider').cslider();
		});
	</script>
    </head>
    <body>
        <!-- start slider -->
        <div id="da-slider" class="da-slider">
            <div class="da-slide">
                <h2>welcome to aditii</h2>
                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her
                    hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line
                    Lane.</p>
                <a href="#" class="da-link">shop now</a>
                <div class="da-img"><img src="images/backSlider.jpg" style="width: 1250px" alt="image01" /></div>
            </div>
            <div class="da-slide">
                <h2>Easy management</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the
                    blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language
                    ocean.</p>
                <a href="#" class="da-link">shop now</a>
                <div class="da-img"><img src="images/s21Ultra.jpg" style="width: 220px; height: 280px;" alt="image01" /></div>
            </div>
            <div class="da-slide">
                <h2>Revolution</h2>
                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a
                    paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                <a href="#" class="da-link">shop now</a>
                <div class="da-img"><img src="images/ip12ProMax.PNG" style="width: 220px; height: 280px;" alt="image01" /></div>
            </div>
            <div class="da-slide">
                <h2>Quality Control</h2>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life
                    One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World
                    of Grammar.</p>
                <a href="#" class="da-link">shop now</a>
                <div class="da-img"><img src="images/ipXPro.PNG" style="width: 220px; height: 280px;" alt="image01" /></div>
            </div>
            <nav class="da-arrows">
                <span class="da-arrows-prev"></span>
                <span class="da-arrows-next"></span>
            </nav>
        </div>
    </body>
</html>

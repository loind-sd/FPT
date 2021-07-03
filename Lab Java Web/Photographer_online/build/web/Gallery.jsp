<%-- 
    Document   : Gallery
    Created on : Jun 19, 2021, 08:48:27 AM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css">
        <script src="js/home.js" type="text/javascript"></script>
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="top">
                    <ul>
                        <li> <a href="home">My front page</a></li>
                        <c:forEach items="${list}" var="i" >
                            <li> <a href="view?id=${i.id}">${i.name}</a> </li>
                            </c:forEach>
                        <li> <a href="contact">Contact</a> </li>
                    </ul>

                </div>
                <div class="down">
                    <div class="img"><img src="images/logo.png"></div>
                    <div class="down2">
                        <div class="title ">
                            PHOTOGRAPHER
                        </div>
                        <div class="subtitle">
                            Welcome to this website
                        </div>
                    </div>

                </div>
            </div>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>${g.name}</h3>
                    </div>
                    <div class="bigImg">
                        <c:forEach items="${listImg}" var="i">
                            <div class="test" onclick="pause()">
                                <img src="images/${i}">
                            </div>
                        </c:forEach>
                        
                        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                        <a class="next" onclick="plusSlides(1)">&#10095;</a>
                    </div>

                    <div class="contentGalery">
                        <c:forEach items="${listImg}" var="i" varStatus="o">
                            <div class="subImg">
                                <img src="images/${i}" onclick="currentSlide(${o.count})">
                            </div>
                        </c:forEach>
                    </div>

                </div>
                <div class="right">
                    <div class="top-right">
                        <h4>Share this page</h4>
                    </div>
                    <div class="share">
                        <ul>
                            <li><img src="images/face.png"><a href="#"><span>Share on Facebook</span></a></li>
                            <li><img src="images/twitter.png"><a href="#"><span>Share on Twitter</span></a></li>
                            <li><img src="images/google.png"><a href="#"><span>Share on Google</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <a href="#">Created with SimpleSite </a>
            <span class="number">0</span>
            <span class="number">2</span>
            <span class="number">2</span>
            <span class="number">1</span>
            <span class="number">3</span>
            <span class="number">1</span>
        </div>

    </body>
</html>

<%-- 
    Document   : HomePage
    Created on : Jun 19, 2021, 07:31:12 AM
    Author     : ADMIN
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Front Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
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
                        <div class="title">
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
                    <div class="image">
                        <img src="images/homeImage.jpg" alt="First">
                    </div>
                    <div class="description">
                        Lorem ipsum dolor sit amet
                    </div>
                    <div class="content">
                        <c:forEach items="${list}" var="i" >
                            <div class="galleryChild">
                                <div class="image">
                                    <img src="images/${i.img}">
                                </div>
                                <h4>
                                    <a href="view?id=${i.id}">View ${i.name}</a>
                                </h4>
                                <p>${i.description}</p>
                            </div>

                        </c:forEach>
                    </div>
                    <div class="about">
                        <h3>About me</h3>
                    </div>
                    <div class="about-detail">
                        A professional photographer who works full-time often does studio work that involves taking pictures in a controlled interior setting, with professional or amateur models. These photographers can be freelance, or can also be kept on retainer by certain magazines and fashion companies.
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

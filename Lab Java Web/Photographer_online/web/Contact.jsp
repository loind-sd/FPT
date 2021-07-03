<%-- 
    Document   : HomePage
    Created on : Jun 19, 2021, 14:01:13 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
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
                        <h3>Contact</h3>
                    </div>
                    <div class="content-contact">
                        <h4>PHOTOGRAPHER</h4>
                        <div class="country">
                            <p>Address: ${contact.address}
                                <br>City: ${contact.city}
                                <br>Country: ${contact.country}</p>
                        </div>
                        <div class="infor">
                            <table>
                                <tr>
                                    <td>Tel: </td>
                                    <td>${contact.phone}</td>
                                </tr>
                                <tr>
                                    <td>Email: </td>
                                    <td>${contact.email}</td>
                                </tr>

                            </table>
                        </div> 
                        <div class="map">
                            <img src="images/map.PNG">
                        </div>
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

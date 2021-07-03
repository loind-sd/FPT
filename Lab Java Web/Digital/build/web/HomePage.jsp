
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script src="js/style.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body> 
        <div class="container">
            <div class="header">
                <div class="header1">                
                </div>
                <div class="header2">
                    <h3>My Digital News</h3>
                </div>
                <div class="header3">
                    <a href="home">News</a>
                </div>
            </div>
            <div class="content">
                <div class="left">
                    <div class="tittle">
                        ${digital.title}
                    </div>
                    <div class="image">
                        <img src="images/${digital.image}"/>
                    </div>
                    <div class="text">
                        ${digital.des}
                    </div>
                    <div class="author">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By ${digital.author} | ${digital.date}
                    </div>
                </div>
                <div class="right">
                    <div class="newst">
                        <div class="titleNews">
                            <span>Digital News</span>
                        </div>
                        <div class="contentNews">
                            ${recent.shortDes}
                        </div>
                    </div>
                    <div class="newst">
                        <div class="titleNews">
                            Search
                        </div>
                        <form id="form" action="search" method="post">
                            <input class="searchBox" id="box" type="text" name="txtSearch" placeholder="Search..." value="${txt}" required>
                            <input class="searchButton" type="submit" value="Go" onclick="checkEmpty()">
                        </form>                        
                    </div>
                    <div class="newst">
                        <div class="titleNews">
                            <span>Last Articles</span><br>
                        </div>
                        <c:forEach items="${listTop5}" var="o">
                            <div class="lastArticles">
                                <a href="detail?id=${o.id}">${o.title}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div> 
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>

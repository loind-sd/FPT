
<%@page import="javax.naming.Context"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Search</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <script src="js/search.js" type="text/javascript"></script>
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
                    <c:forEach items="${listSearch}" var="o">
                        <div class="tittle">
                            <a href="detail?id=${o.id}" name="titlteSearch" title="${o.title}">      
                                ${o.title}
                            </a>
                        </div>
                        <div class="image_search">
                            <img src="images/${o.image}" alt="hihi"/>
                        </div>
                        <div class="text_search">
                            ${o.shortDes}
                        </div>
                        <br>
                    </c:forEach>
                    <c:if test="${end > 1}">
                        <div class="paging">
                            <c:if test="${end > 0}">
                                <c:forEach begin="1" end="${end}" var="i">
                                    <a href="search?index=${i}&txtSearch=${txt}" ${index == i ? "active":""} >${i}</a>
                                </c:forEach>
                            </c:if>

                            <c:if test="${end == 0}">
                                <h2 style="text-align: center;">Not Found!</h2>
                            </c:if>
                        </div>
                    </c:if>

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
                        <form action="search" method="post" id="form">
                            <input class="searchBox" id="box" type="text" name="txtSearch" size="15" placeholder="Search..." value="${txt}" required>
                            <input class="searchButton" type="submit" name="btnGo" value="Go" onclick="checkEmpty()">
                            <input type="hidden" value="${txt}" id="oldTxt">
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mark.js/8.9.0/jquery.mark.min.js" integrity="sha256-jcYvou95wtQNBJhqUWTA7Xv+A9ZPumT5e9nwTEmCzJs=" crossorigin="anonymous"></script>
        <script type="text/javascript">
                                $('.tittle').mark('${txt}');
        </script>
    </body>
</html>

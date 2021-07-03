<%-- 
    Document   : index
    Created on : 11-May-2021, 20:58:14
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <div>
            <h2><img src="images/table.png" width="20px" height="20px"/> Time table </h2>
        </div>
        <form action="search" method="post">
            <div class="head">
                <div class="from">
                    <p>From Date</p>
                    <input type="text" name="from" value="${from}"/>
                </div>
                <div class="to">
                    <p>To Date</p>
                    <input type="text" name="to" value="${to}"/>

                </div>
                <div class="search">
                    <input type="submit" value="Search" name="Search" />
                    <a href="preAdd">Add timetable</a>
                </div>
            </div>
        </form>

        <div class="content">
            <c:if test="${isValid == 1}"> 
                <p>DAte is not valid!</p>
                <style>
                    table {
                        display: none;
                    }
                </style>
            </c:if>
            <c:if test="${isEmpty == 1}">
                <p>Not Found!</p>
            </c:if>
            <c:if test="${isEmpty == null}">
                <table border="solid 0.5px white">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Slot</th>
                            <th>Time</th>
                            <th>Class</th>
                            <th>Teacher</th>
                            <th>Room</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="o">
                            <tr>
                                <td>${o.date}</td>
                                <td>${o.slot}</td>
                                <td>${o.time}</td>
                                <td>${o.className}</td>
                                <td>${o.teacher}</td>
                                <td>${o.room}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

        </div>
                    
                    
        <c:if test="${success != null}">
            <script>
                alert("Add SuccessFul!");
            </script>
        </c:if>

        
    </body>
</html>

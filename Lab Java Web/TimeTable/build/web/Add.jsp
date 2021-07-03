<%-- 
    Document   : Add
    Created on : 11-May-2021, 23:42:49
    Author     : hp
--%>

<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/add.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <div>
                <h2><img src="images/table.png" width="20px" height="20px"/> Add Time table </h2>
            </div>
            <form action="add" method="post">
                <table>
                    <tbody>
                        <tr>
                            <td>Date</td>
                            <td><input type="text" name="date" value="${date}" /></td>
                        </tr>
                        <tr>
                            <td>Slot</td>
                            <td><select name="slot">
                                    <c:forEach items="${sessionScope.listTime}" var="o">
                                        <option value="${o.slot}" ${o.slot == slot ? "selected":""}>${o.slot} (${o.time})</option>
                                    </c:forEach>
                                </select></td>
                        </tr>
                        <tr>
                            <td>Room</td>
                            <td><select name="room">
                                    <c:forEach items="${sessionScope.listRoom}" var="o">
                                        <option value="${o.id}" ${o.id == room ? "selected":""}>${o.room}</option>
                                    </c:forEach>
                                </select></td>
                        </tr>
                        <tr>
                            <td>Teacher</td>
                            <td><input type="text" name="teacher" value="${teacher}" /></td>
                        </tr>
                        <tr>
                            <td>Class/Course</td>
                            <td><select name="class">
                                    <c:forEach items="${sessionScope.listClass}" var="o">
                                        <option value="${o.id}" ${o.id == class ? "selected":""}>${o.name}</option>
                                    </c:forEach>
                                </select></td>
                        </tr>
                     
                    </tbody>
                </table>
                <input id="save" type="submit" value="Save"/>
                <h3>${result}</h3>
            </form>
        </div>
    </body>
</html>

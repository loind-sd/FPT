<%-- 
    Document   : CheckBill
    Created on : Mar 21, 2021, 8:56:37 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý Hóa Đơn</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/checkBill.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1><span class="blue">&lt;</span>Table<span class="blue">&gt;</span> <span class="yellow">Bill</span></h1>
        <h2>Copied with love by Đức Lợi</h2>

        <form action="filter" method="post" class="form-inline my-2 my-lg-0">

            <label class="filter">Filter:</label>
            <select name="filter">
                <option value="-1" ${index == -1? "selected":""}>All</option>
                <option value="0" ${index == 0? "selected":""}>Wait</option>
                <option value="1" ${index == 1? "selected":""}>Process</option>
                <option value="2" ${index == 2? "selected":""}>Done</option>
            </select>
            <input type="submit" value="Search">


        </form>

        <table class="container">
            <thead>
                <tr>
                    <th><h1>ID</h1></th>
                    <th><h1>Date Create</h1></th>
                    <th><h1>Total</h1></th>
                    <th><h1>Receiver Name</h1></th>
                    <th><h1>Receiver Phone</h1></th>
                    <th><h1>Receiver Address</h1></th>
                    <th><h1>Customer Name</h1></th>
                    <th><h1>Status</h1></th>
                    <th><h1>Action</h1></th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${listBill}" var="o">
                    <tr>
                        <td><a href="billDetail?id=${o.bid}" style="color: yellowgreen">${o.bid}</a></td>
                        <td>${o.date}</td>
                        <td>${o.total}</td>
                        <td>${o.recNAme}</td>
                        <td>${o.recPhone}</td>
                        <td>${o.recAddress}</td>
                        <td>${o.cName}</td>

                        <c:if test="${o.status == 0}">
                            <td>Wait</td>
                            <td><a href="process?id=${o.bid}" style="text-decoration: none; color: yellowgreen;">Process</a>
                                <a href="checkDone2?id=${o.bid}" style="text-decoration: none; color: red;"><img src="images/tick.png">Done</a>
                            </td>
                        </c:if>
                        <c:if test="${o.status == 1}">
                            <td>Process</td>
                            <td><a href="wait?id=${o.bid}" style="text-decoration: none; color: yellowgreen;">Wait</a>
                                <a href="checkDone?id=${o.bid}" style="text-decoration: none; color: red;"><img src="images/tick.png">Done</a></td>
                                </c:if>
                                <c:if test="${o.status == 2}">
                            <td>Done</td>
                            <td></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="home" class="btn btn-success btn-block" style="width: 20%; margin-top: 50px; margin-left: 200px">Back To Home</a>
    </body>
</html>

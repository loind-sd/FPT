<%-- 
    Document   : BillDetail
    Created on : Mar 23, 2021, 8:26:36 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/billDetail.css" rel="stylesheet" type="text/css">
    </head>
    <body>



        <h1>Bill Detail</h1>
        <table class="rwd-table">
            <tr>
                <th>Bill ID</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>SubTotal</th>
            </tr>

            <c:forEach items="${listBillDetail}" var="o">
                <tr>
                    <td data-th="Movie Title">${o.bid}</td>
                    <td data-th="Genre">${o.pName}</td>
                    <td data-th="Year">${o.quantity}</td>
                    <td data-th="Gross">${o.price}</td>
                    <td data-th="Gross">${o.subTotal} vnd</td>
                </tr>
            </c:forEach>
                <tr>
                    <td data-th="Movie Title"></td>
                    <td data-th="Genre"></td>
                    <td data-th="Year"></td>
                    <td data-th="Gross">Total: </td>
                    <td data-th="Gross">${all} vnd</td>
                </tr>

        </table>

        <a href="checkBill"><button type="button" class="btn btn-primary">Back</button></a>

        <!--<script src="js/manager.js" type="text/javascript"></script>-->
    </body>
</html>

<%-- 
    Document   : CheckAccount
    Created on : Mar 21, 2021, 9:43:18 AM
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/checkAccount.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section>
            <!--for demo wrap-->
            <h1>Manager Account</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                        <tr>
                            <th>Customer ID</th>
                            <th>Customer Name</th>
                            <th>Customer Phone</th>
                            <th>Customer Address</th>
                            <!--<th>Action</th>-->
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>

                        <c:forEach items="${listCus}" var="o">
                            <tr>
                                <td>${o.cusid}</td>
                                <td>${o.name}</td>
                                <td>${o.phone}</td>
                                <td>${o.address}</td>
                                <!--<td><a href="deleteCus?id=${o.cusid}" class="delete" data-toggle="modal" style="text-decoration: none; color: yellowgreen; font-size: 20px"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>Delete</a></td>-->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>

        <a href="home" class="btn btn-success btn-block" style="width: 20%; margin-top: 50px; margin-left: 200px">Back To Home</a>

        <!-- follow me template -->
        <div class="made-with-love">
            Copied with
            <i>♥</i> by
            Đức Lợi
        </div>
        
    </body>
</html>

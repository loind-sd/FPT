<%-- 
    Document   : Home
    Created on : May 29, 2021, 8:48:39 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h1>FPT Education System</h1>
                <h3>Teacher Control Panel</h3>
            </div>

            <div class="content">
                <div class="left">
                    <c:if test="${sessionScope.acc == null}">
                        <a href="HomeControl"><button>Login</button></a>
                    </c:if>
                    <c:if test="${sessionScope.acc != null}">
                        <a href="logout"><button>Welcome ${sessionScope.acc.shortName}, Logout</button></a>
                    </c:if>
                    <a href="#"><button>Home</button></a>
                    <a href="#"><button>View Request</button></a>
                    <a href="#"><button>Solve Request</button></a>
                    <button>Today is: ${sessionScope.today}</button>
                </div>
                <div class="right">
                    <c:if test="${sessionScope.acc == null}">
                        <div class="login">
                            <h2>Member Login</h2>
                            <p>Using your username and password</p>
                            <form action="login" method="post">
                                <table>
                                    <tr>
                                        <td>Username: </td>
                                        <td><input type="text" name="user" value="${user}"></td>
                                    </tr>
                                    <tr>
                                        <td>Password </td>
                                        <td><input type="password" name="pass" value="${pass}"></td>
                                    </tr>
                                </table>
                                <input class="btnLogin" type="submit" value="Login">
                                <h5>${noti}</h5>
                            </form>
                        </div>
                    </c:if>

                    <c:if test="${sessionScope.acc != null}">
                        <div class="after_login">
                            <h3 style="color: blue;">Request received by today</h3>
                            <table class="request_today" border="groove 2px">
                                <tr>
                                    <th>Department name</th>
                                    <th>Number of Request</th>
                                    <th>View</th>
                                </tr>
                                <c:forEach items="${listToday}" var="i">
                                    <tr>
                                        <td>${i.requestName}</td>
                                        <td>${i.number}</td>
                                        <td><a href="view?requestTo=${i.to}&today=1">View</a></td>
                                    </tr>
                                </c:forEach>
                            </table>

                            <h3 style="color: blue;">Request received in the last few days</h3>
                            <table class="request_last" border="groove 2px">
                                <tr>
                                    <th>Department name</th>
                                    <th>Number of Request</th>
                                    <th>View</th>
                                </tr>
                                <c:forEach items="${listPast}" var="i">
                                    <tr>
                                        <td>${i.requestName}</td>
                                        <td>${i.number}</td>
                                        <td><a href="view?requestTo=${i.to}&today=0">View</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </c:if>
                </div>

            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>

<%-- 
    Document   : SolveRequest
    Created on : May 29, 2021, 3:20:04 PM
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
                    <a href="logout"><button>Welcome ${sessionScope.acc.shortName}, Logout</button></a>
                    <a href="login"><button>Home</button></a>
                    <a href="#"><button>View Request</button></a>
                    <a href="#"><button>Solve Request</button></a>
                    <button>Today is: ${sessionScope.today}</button>
                </div>
                <div class="right">
                    <div class="solve">
                        <h3 style="color: blue;">Request ID: ${r.id}</h3>
                        <form action="solve" method="post">
                            <table>
                                <tr>
                                    <td>Request to department</td>
                                    <td><input type="text" name="department" readonly value="${r.requestName}">
                                        <input type="hidden" name="requestID" value="${r.id}">                                    
                                    </td>
                                </tr>
                                <tr>
                                    <td>Student ID</td>
                                    <td><input type="text" name="stuId" readonly value="${r.studentId}"></td>
                                </tr>
                                <tr>
                                    <td>Student Name</td>
                                    <td><input type="text" name="stuName" readonly value="${r.studentName}"></td>
                                </tr>
                                <tr>
                                    <td>Date Create</td>
                                    <td><input type="text" name="dateCreate" readonly value="${r.dateCreated}"></td>
                                </tr>
                                <tr>
                                    <td>Request Title</td>
                                    <td><input type="text" name="title" readonly value="${r.title}" ></td>
                                </tr>
                                <tr>
                                    <td>Request Content</td>
                                    <td><textarea name="title" readonly>${r.content}</textarea></td>
                                </tr>
                                <tr>
                                    <td>Request Status</td>
                                    <td>
                                        <input type="radio" name="status" style="width: auto;"  value="1" ${r.status == 1? "checked":""} > <span style="color: green">Approve</span>
                                        <input type="radio" name="status" style="width: auto;"  value="2"  ${r.status == 0? "checked":""} ${r.status == 2? "checked":""}> <span style="color: red">Reject</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Date Close</td>
                                    <td><input type="text" name="dateClose" readonly value="${r.dateClose}"></td>
                                </tr>
                                <tr>
                                    <td>Solve By</td>
                                    <td><input type="text" name="solveBy" readonly value="${sessionScope.acc.shortName}"></td>
                                </tr>
                                <tr>
                                    <td>Attaches (if have)</td>
                                    <td>
                                        <c:if test="${r.attach == null}">
                                            <input type="button" value="Download">
                                        </c:if>
                                        <c:if test="${r.attach != null}">
                                            <a href="download?fileName=${r.attach}"><input type="button" value="Download"></a>
                                            </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td>School's Solution</td>
                                    <td><textarea name="solution" ${r.solution != null ? "readonly":""} required>${r.solution}</textarea></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <c:if test="${hidden == null}">
                                            <input type="submit" value="Save">
                                        </c:if>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>

            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>

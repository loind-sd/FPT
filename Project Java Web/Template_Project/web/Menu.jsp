<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->


<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home"  style="color: red;"><i class="fab fa-app-store-ios"></i> Home Smartphone</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.isAdmin == 0}">
                    <li class="nav-item">
                        <a class="nav-link" href="Register.jsp" style="color: orange;">Register</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.isLogin == 0}">
                    <c:if test="${sessionScope.isAdmin == 0}">
                        <li class="nav-item">
                            <a class="nav-link" href="Login.jsp" style="color: orange;">Login</a>
                        </li>
                    </c:if>

                </c:if>
                <c:if test="${sessionScope.isLogin != 0}">
                    <li class="nav-item">
                        <a class="nav-link" href="logout" style="color: orange;">Logout</a>
                    </li>
                    <li>
                        <a class="nav-link" href="UserAccount.jsp" style="color: orange;">Hello ${sessionScope.customer.name}</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.isAdmin != 0}">
                    <li class="nav-item">
                        <a class="nav-link" href="logout" style="color: orange;">Logout</a>
                    </li>
                </c:if>


                <c:if test="${sessionScope.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="managerProduct" style="color: orange;">Manager Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="checkAccount" style="color: orange;">Manager Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="checkBill" style="color: orange;">Manager Bill</a>
                    </li>
                </c:if>


            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="txt" type="text" value="${txt}" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number"  style="background: red;">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <c:if test="${sessionScope.isAdmin == 0}">
                    <a class="btn btn-success btn-sm ml-3"  style="background: red;" href="show">
                        <i class="fa fa-shopping-cart"></i> Cart
                        <span class="badge badge-light"  style="background: greenyellow;">${sessionScope.numberProduct}</span>
                    </a>
                </c:if>

            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">


    <!--        <h1 class="jumbotron-heading" id="blink">Ở đây có bán điện thoại tươi</h1>
            <style>
                #blink {
                    animation: blinker 2s linear infinite;
                    color: #1c87c9;
                    font-size: 40px;
                    font-weight: bold;
                    font-family: sans-serif;
                    text-align: center;
                }
            </style>-->
    <%--<jsp:include page="slider.jsp"></jsp:include>--%>

</section>
<!--end of menu-->

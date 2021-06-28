<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <h4></h4>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>
                    <div class="col-sm-9">
                        <div class="row">
                        <c:if test="${sessionScope.in4Add != null}">
                            <h5 style="color: red;">${in4Add}</h5>
                        </c:if>
                        <c:forEach items="${sessionScope.list}" var="o">
                            <!--                            <div class="col-12 col-md-6 col-lg-4">
                                                            <div class="card">
                                                                <img class="card-img-top" src="https://image.yes24.vn/Upload/ProductImage/thethaochinhang/2063162_L.jpg?width=550&height=550" alt="Card image cap">
                                                                <div class="card-body">
                                                                    <h4 class="card-title show_txt"><a href="#" title="View Product">Giày adidas 2A</a></h4>
                                                                    <p class="card-text show_txt">Giày đá bóng nam chính hãng Adidas Predator 18.4 FXG DB2007
                                                                    </p>
                                                                    <div class="row">
                                                                        <div class="col">
                                                                            <p class="btn btn-danger btn-block">100 $</p>
                                                                        </div>
                                                                        <div class="col">
                                                                            <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>-->
                            <div class="grid_1_of_4 images_1_of_4">
                                <img src="images/${o.image}" alt="test" style="width: 235px; height: 260px;" />
                                <a href="detail?id=${o.id}"><h2>${o.name}</h2></a>
                                <div class="price-details">
                                    <div class="price-number">
                                        <p><span class="rupees">${o.price} </span></p>
                                    </div>

                                    <c:if test="${o.quantity != 0}">
                                        <div class="add-cart">
                                            <h4><a href="addToCard?id=${o.id}">Add to Cart</a></h4>
                                        </div>
                                    </c:if>
                                    <c:if test="${o.quantity == 0}">
                                        <div class="add-cart">
                                            <h5 style="color: red; margin-top: 15px">Out of Stock</h5>
                                        </div>
                                    </c:if>
                                    <div class="clear"></div>
                                </div>

                            </div>
                        </c:forEach>
                    </div>
                    <div class="clearfix">
                        <ul class="pagination">
                            <c:forEach begin="1" end="${end}" var="o">
                                <c:if test="${action == 1}">
                                    <li class="${in == o? "page-item active":"page-item"}"><a href="home?index=${o}" class="page-link">${o}</a></li>
                                    </c:if>
                                    <c:if test="${action == null}">
                                    <li class="${in == o? "page-item active":"page-item"}"><a href="home?index=${o}"  class="page-link">${o}</a></li>
                                    </c:if>
                                    <c:if test="${action == 2}">
                                    <li class="${in == o? "page-item active":"page-item"}"><a href="getByBrand?index=${o}&s=${st}"  class="page-link">${o}</a></li>
                                    </c:if>
                                    <c:if test="${action == 3}">
                                    <li class="${in == o? "page-item active":"page-item"}" ><a href="search?index=${o}&txt=${txt}" class="page-link">${o}</a></li>
                                    </c:if>
                                </c:forEach>
                        </ul>
                    </div>
                </div>


            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>


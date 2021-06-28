

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <!--    <div class="card bg-light mb-3">
            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
            <ul class="list-group category_block">
                
            </ul>
        </div>-->

    <div class="header_bottom_left">
        <div class="categories">
            <ul>
                <h3>Categories</h3>
                <c:forEach items="${listC}" var="o">
                    <li><a href="getByBrand?index=1&s=${o.id}">${o.name}</a></li>
                    </c:forEach>
            </ul>
        </div>
    </div>

    <div class="header_bottom_left2">
        <!--                <div class="card-header bg-success text-white text-uppercase">Super product</div>
                        <div class="card-body">
                            <img class="img-fluid" src="images/${max.image}" />
                            <h5 class="card-title">${max.name}</h5>
                            <p class="card-text">${max.description}</p>
                            <p class="bloc_left_price">${max.price}</p>
                        </div>-->
        <br>
        <br>
        <br>
        <jsp:include page="minion.jsp"></jsp:include>
    </div>
</div>
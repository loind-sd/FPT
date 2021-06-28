<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                                <c:if test="${sessionScope.numberProduct == 0}">
                                    <h2 style="color: red; text-align: center; font-weight: initial">Hiện tại chưa có sản phẩm nào trong giỏ hàng</h2>
                                    <style>
                                        #haha{
                                            display: none;
                                        }
                                    </style>
                                </c:if>
                                <c:if test="${afterBuy == 1}">
                                    <h2 style="color: red; text-align: center; font-weight: initial">Cảm ơn bạn đã mua hàng!</h2>
                                    <a href="home" class="btn btn-success btn-block">Tiếp tục mua hàng</a>
                                    <style>
                                        #haha{
                                            display: none;
                                        }
                                    </style>
                                </c:if>
                                <c:if test="${sessionScope.numberProduct != 0}">
                                    <style>
                                        #haha{
                                            display: compact;
                                        }
                                    </style>
                                </c:if>

                                <!-- Shopping cart table -->
                                <div class="table-responsive" id="haha">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Đơn Giá</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Số Lượng</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Xóa</div>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listInBill}" var="o">
                                                <tr>
                                                    <th scope="row">
                                                        <div class="p-2">
                                                            <img src="images/${o.image}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block">${o.name}</a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                            </div>
                                                        </div>
                                                    </th>
                                                    <td class="align-middle"><strong>${o.price} vnd</strong></td>
                                                    <td class="align-middle">
                                                        <a href="sub?id=${o.id}"><button class="btnSub">-</button></a> 
                                                        <strong>${o.quantity}</strong>
                                                        <a href="plus?id=${o.id}"><button class="btnAdd">+</button></a>
                                                    </td>
                                                    <td class="align-middle"><a href="remove?id=${o.id}" class="text-dark">
                                                            <button type="button" class="btn btn-danger">Delete</button>
                                                        </a>
                                                    </td>
                                                    <c:if test="${o.id == sessionScope.idPlus}">
                                                <h5>${sessionScope.infor}</h5>
                                            </c:if>
                                            </tr> 
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm" id="haha">
                            <div class="col-lg-6" id="anHien">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thông tin người nhận</div>
                                <div class="p-4">
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <input type="text" placeholder="Tên người nhận" id="recName" value="${sessionScope.customer.name}" aria-describedby="button-addon3" class="form-control border-0" required>

                                    </div>
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <input type="text" placeholder="Số Điện Thoại" id="recPhone" value="${sessionScope.customer.phone}" aria-describedby="button-addon3" class="form-control border-0" required>

                                    </div>
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <input type="text" placeholder="Địa chỉ" id="recAddress" value="${sessionScope.customer.address}" aria-describedby="button-addon3" class="form-control border-0" required>

                                    </div>
                                </div>
                            </div>
                            <style>
                                #anHien{
                                    display: none;
                                }
                            </style>
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${sessionScope.allTotal}</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                            <h5 class="font-weight-bold">${sessionScope.allTotal}</h5>
                                        </li>
                                    </ul>
                                    <c:if test="${sessionScope.isLogin == 0}">
                                        <a onclick="window.alert('Vui lòng đăng nhập để thực hiện bước cuối cùng');" href="Login.jsp" class="btn btn-dark rounded-pill py-2 btn-block">Tiếp tục</a>
                                    </c:if>
                                    <c:if test="${sessionScope.isLogin != 0}">
                                        <a href="#" onclick="checkReceiver()" class="btn btn-dark rounded-pill py-2 btn-block">Thanh toán</a>
                                        <style>
                                            #anHien{
                                                display: block;
                                            }
                                        </style>
                                        <script>
                                            function checkReceiver() {
                                                var name = document.getElementById("recName").value;
                                                var phone = document.getElementById("recPhone").value;
                                                var address = document.getElementById("recAddress").value;

                                                if (name === "" || phone === "" || address === "") {
                                                    alert("Vui lòng điền đầy đủ thông tin người nhận");
                                                    return;
                                                }

                                                window.location = "buy?recName=" + name + "&recAddress=" + address + "&recPhone=" + phone;
                                            }
                                        </script>
                                    </c:if>    

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>
</html>

<%-- 
    Document   : UserAccount
    Created on : Mar 21, 2021, 2:14:55 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Main css -->
        <link rel="stylesheet" href="css/userAccount.css">
    </head>
    <body>
        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Your Account Information</h2>
                        <form method="POST" class="register-form" id="register-form" action="updateCus">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" style="font-family: sans-serif; font-size: 20px;" name="name" id="name" value="${sessionScope.customer.name}" placeholder="Your Name"/>
                            </div>
                            <div class="form-group">
                                <label for="phone"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" style="font-family: sans-serif; font-size: 20px;" name="phone" id="name" value="${sessionScope.customer.phone}" placeholder="Your Phone"/>
                            </div>
                            <div class="form-group">
                                <label for="address"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" style="font-family: sans-serif; font-size: 20px;" style="font-family: sans-serif; font-size: 20px;" name="address" id="name" value="${sessionScope.customer.address}" placeholder="Your Address"/>
                            </div>
                            <div class="form-group">
                                <label for="user"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" style="font-family: sans-serif; font-size: 20px;" name="user" id="email" value="${sessionScope.customer.user}" placeholder="Your UserName" readonly/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" style="font-family: sans-serif; font-size: 20px;" name="pass" id="pass" value="${sessionScope.customer.pass}" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" style="font-family: sans-serif; font-size: 20px;" name="re_pass" id="re_pass" placeholder="Repeat your password"/>
                            </div>
                            <div>
                                <c:if test="${h4 != null}">
                                    <p style="font-size: 14px; color: red">${h4}</p>
                                </c:if>
                            </div>
                            <div class="form-group">
                                <label for="agree-term" class="label-agree-term" style="font-size: 18px">You also can change password in here!</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="OK"/>
                                <button style="width: 115px; margin-left: 20px; height: 50px; background-color: greenyellow; border-radius: 8px"><a href="home" style="text-decoration: none;">Back To Home</a></button>
                            </div>

                        </form>


                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>

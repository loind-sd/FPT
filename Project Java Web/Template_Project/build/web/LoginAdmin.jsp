<%-- 
    Document   : LoginAdmin
    Created on : Mar 13, 2021, 8:54:48 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/loginAdmin.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <meta name="keywords" content="Classy Login form Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <!-- //for-mobile-apps -->
        <!--Google Fonts-->
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <!--header start here-->
        <div class="header">
            <div class="header-main">
                <h1>Admin Đăng Nhập</h1>
                <div class="header-bottom">
                    <div class="header-right w3agile">

                        <div class="header-left-bottom agileinfo">

                            <form action="loginAdmin" method="post">
                                <input type="text"  value="Tên tài khoản" name="user" onfocus="this.value = '';" onblur="if (this.value == '') {
                                            this.value = 'User name';
                                        }"/>
                                <input type="password"  value="Mật Khẩu" name="pass" onfocus="this.value = '';" onblur="if (this.value == '') {
                                            this.value = 'password';}"/>

                                <input type="submit" value="Đăng nhập">
                            </form>	
                            
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!--header end here-->
        <div class="copyright">
            <p>© 2021 Admin Login Form. All rights reserved | Copied by Đức Lợi</p>
        </div>
    </body>
</html>

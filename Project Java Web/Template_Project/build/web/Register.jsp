<%-- 
    Document   : Register
    Created on : Mar 13, 2021, 7:54:09 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng kí</title>
        <link rel="stylesheet" href="css/register.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Merriweather:300,400,400i|Noto+Sans:400,400i,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600" rel="stylesheet">
    </head>
    <body>
        
                <!--                <h2>Đăng ký</h2>
                                <label style="margin-left: -150px;">Họ và tên</label>
                                <input type="text" name="name" id="name">
                                <label>Số điện thoại</label>
                                <input type="text" name="phone" id="phone">    
                                <label style="margin-left: -180px;">Địa chỉ</label>
                                <input type="text" name="address" id="address"> 
                                <label style="margin-left: -135px;">Tên tài khoản</label>
                                <input type="text" name="user"id="user" >
                                <label style="margin-left: -160px;">Mật khẩu</label>
                                <input type="password" name="pass" id="pass">
                                <label style="margin-left: -95px;">Nhập lại mật khẩu</label>
                                <input type="password" name="rePass" id="rePass">
                                <input id="submit" type="button" onclick="check()" name="submit" value="Đăng ký">-->
                <!--<img class="bg-img" src="https://mariongrandvincent.github.io/HTML-Personal-website/img-codePen/bg.jpg" alt="">-->
                <div class="connexion">
                    <div class="contact-form">
                        <label>FULL NAME</label>
                        <input placeholder="" type="text" name="name" id="name">
                        
                        <label>PHONE NUMBER</label>
                        <input placeholder="" type="text" name="phone" id="phone">
                        
                        <label>ADDRESS</label>
                        <input placeholder="" type="text" name="address" id="address">
                        
                        <label>USERNAME</label>
                        <input placeholder="" type="text" name="user" id="user">

                        <label>PASSWORD</label>
                        <input placeholder="" type="password" name="pass" id="pass">

                        <label>RE-PASSWORD</label>
                        <input placeholder="" type="password" name="rePass" id="rePass">
                        

                        <input class="submit" type="button" onclick="check()" value="Register" >
                    </div>


                </div>

 

        <script>
            function check() {
                var name = document.getElementById("name").value;
                var phone = document.getElementById("phone").value;
                var address = document.getElementById("address").value;
                var username = document.getElementById("user").value;
                var password = document.getElementById("pass").value;
                var rePassword = document.getElementById("rePass").value;

                console.log(address, name, phone, username, password, rePassword);

                if (name === "" || phone === "" || address === "" || username === "" || password === "" || rePassword === "") {
                    alert("Vui lòng điền vào các vị trí còn trống!");
                    return;
                }

                if (password !== rePassword) {
                    alert("Xác nhận mật khẩu không chính xác");
                    return;
                }

                window.location = "register?name=" + name + "&phone=" + phone + "&address="
                        + address + "&user=" + username + "&pass=" + password;
            }
        </script>
    </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Login Form</title>
    </head>
    <body>
        <!--        <div id="logreg-forms">
                    <form class="form-signin" action="login" method="post">
                        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
                        <p class="text-danger">${mess}</p>
                        <input name="user"  type="text" id="inputEmail" class="form-control" placeholder="Username" required="" autofocus="">
                        <input name="pass"  type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
        
                        <div class="form-group form-check">
                            <input name="remember" value="1" type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Remember me</label>
                        </div>
        
                        <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
                        <hr>
                        <button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i> Sign up New Account</button>
                    </form>
        
                    <form action="signup" method="post" class="form-signup">
                        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign up</h1>
                        <input name="user" type="text" id="user-name" class="form-control" placeholder="User name" required="" autofocus="">
                        <input name="pass" type="password" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
                        <input name="repass" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">
        
                        <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
                        <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
                    </form>
                    <br>
        
                </div>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
                <script>
                    function toggleResetPswd(e) {
                        e.preventDefault();
                        $('#logreg-forms .form-signin').toggle() // display:block or none
                        $('#logreg-forms .form-reset').toggle() // display:block or none
                    }
        
                    function toggleSignUp(e) {
                        e.preventDefault();
                        $('#logreg-forms .form-signin').toggle(); // display:block or none
                        $('#logreg-forms .form-signup').toggle(); // display:block or none
                    }
        
                    $(() => {
                        // Login Register Form
                        $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                        $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                        $('#logreg-forms #btn-signup').click(toggleSignUp);
                        $('#logreg-forms #cancel_signup').click(toggleSignUp);
                    })
                </script>-->
        <div class="container" id="container">
            <!--            <div class="form-container sign-up-container">
                            <form action="#">
                                <h1>Create Account</h1>
                                <div class="social-container">
                                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                                </div>
                                <span>or use your email for registration</span>
                                <input type="text" placeholder="Name" />
                                <input type="email" placeholder="Email" />
                                <input type="password" placeholder="Password" />
                                <button>Sign Up</button>
                            </form>
                        </div>-->
            <div class="form-container sign-in-container">
                <form action="loginCus" method="post">
                    <h1>Đăng nhập</h1>
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <span>hoặc</span>
                    <input type="text" placeholder="Tài khoản" name="user" />
                    <input type="password" placeholder="Mật khẩu" name="pass"/>
                    <c:choose>
                        <c:when test="${loginFail == null}">

                        </c:when>
                        <c:when test="${loginFail == 1}">
                            <h5 style="color: red">Tài khoản hoặc mật khẩu không chính xác</h5>
                        </c:when>
                    </c:choose>
                    <a href="#">Quên mật khẩu?</a>
                    <button type="submit">Đăng nhập</button>
                    <a href="LoginAdmin.jsp">Đăng nhập với tư cách Admin</a>
                </form>

            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <!--                    <div class="overlay-panel overlay-left">
                                            <h1>Welcome Back!</h1>
                                            <p>To keep connected with us please login with your personal info</p>
                                            <button class="ghost" id="signIn">Sign In</button>
                                        </div>-->
                    <div class="overlay-panel overlay-right">
                        <h1>Hello, Friend!</h1>
                        <p>Nếu bạn chưa có tài khoản, hãy ấn vào nút <strong>Đăng ký</strong></p>
                        <a href="Register.jsp"><button class="ghost" id="signUp">Đăng ký</button></a>
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <p>
                From Đức Lợi With <i class="fa fa-heart"></i>
            </p>
        </footer>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles/login.css">
</head>
<body>
<div class="wrapper">
    <div class="logo">
        <img src="images/index/logo.png" alt="">
    </div>
    <div class="text-center mt-4 name">
    </div>
    <form class="p-3 mt-3"  action="login" method="post">
        <input type="hidden" name="action" value="login">
        <div class="form-field d-flex align-items-center">
            <span class="far fa-user"></span>
            <input type="text" name="username" id="username" placeholder="username">
        </div>
        <div class="form-field d-flex align-items-center">
            <span class="fas fa-key"></span>
            <input type="password" name="password" id="password" placeholder="password">
        </div>
        <div id="message">${message}</div><br>
        <button class="btn mt-3" type="submit">Login</button>
    </form>
    <div class="text-center fs-6">
        <a href="forgotpassword.jsp">Forgot password ?</a>
    </div>
    <div class="text-center mt-2 fs-6">
        <p>Don't have an account?<p>

    </div>
    <a href="register.jsp" class="btn mt-2 btn-sign-up">Sign Up</a>
</div>
</body>
</html>

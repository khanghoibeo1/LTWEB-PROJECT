<%-- 
    Document   : forgotpassword
    Created on : Dec 6, 2023, 2:50:43 AM
    Author     : tranp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    String email = (String) session.getAttribute("email");
    // Now userEmail contains the email information
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Password</title>
        <link rel="stylesheet" type="text/css" href="styles/forgotpassword.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="card login-form">
	<div class="card-body">
		<h3 class="card-title text-center">Reset Password</h3>
		
		<div class="card-text">
			<form action="newPass" method="post">
				<div class="form-group">
					<label >Please enter your new password</label>
					<input type="password" name="password" class="form-control form-control-sm mt-2" placeholder="Enter your new password">
                                        <input type="password" name="conpassword" class="form-control form-control-sm mt-2" placeholder="Confirm your new password">
				</div>

                            <button type="submit" class="btn btn-primary btn-block">Submit</button>
			</form>
		</div>
	</div>
</div>
    </body>
</html>

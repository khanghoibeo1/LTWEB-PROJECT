<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="./styles/register.css">
</head>
<body>

<section>
    <!-- Image Section -->
    <div class="img-bg">
        <img src="./images/register/register_image.png" alt="Image">
    </div>
    <div class="register-container">
        <div class="content">
            <div class="form">
                <h1 class="title-page">Register Account</h1>
                <form class="register_form" action="register" method="post" name="form" id="register-form-id">
                    <!-- Username -->
                    <div class="input-form">
                        <span>Username</span>
                        <input type="text" class="input" name="username" />
                    </div>

                    <!-- Password -->
                    <div class="input-form">
                        <span>Password</span>
                        <input type="password" name="password" />
                        <div class="indicator">
                            <span class="weak"></span>
                            <span class="medium"></span>
                            <span class="strong"></span>
                        </div>
                        <div class="text"></div>
                    </div>
                    <!-- Confirm Password -->
                    <div class="input-form">
                        <span>Confirm Password</span>
                        <input type="password" name="confirmPassword" id="confirmPassword" />
                        <div class="error-message" id="confirmPasswordError"></div>
                    </div>


                    <!-- First Name -->
                    <div class="input-form">
                        <span>First Name</span>
                        <input type="text" name="firstname" />
                    </div>

                    <!-- Last Name -->
                    <div class="input-form">
                        <span>Last Name</span>
                        <input type="text" name="lastname" />
                    </div>

                    <!-- Date of Birth -->
                    <div class="input-form">
                        <span>Date</span>
                        <input type="date" name="date" />
                    </div>

                    <!-- Gender -->
                    <div class="input-form">
                        <span>Gender</span>
                        <label>
                            Male
                            <input type="radio" name="gender" value="male" />
                        </label>
                        <label>
                            Female
                            <input type="radio" name="gender" value="female" />

                        </label>
                        <label>
                            Other
                            <input type="radio" name="gender" value="other" />

                        </label>
                    </div>



                    <!-- Email -->
                    <div class="input-form">
                        <span>Email</span>
                        <input type="text" name="email" />
                    </div>

                    <!-- Phone -->
                    <div class="input-form">
                        <span>Phone</span>
                        <input type="tel" name="phone" />
                    </div>

                    <!-- Address -->
                    <div class="input-form">
                        <span>Address</span>
                        <input type="text" name="address" />
                    </div>
                    <!-- Submit Button -->
                    <div class="input-form">
                        <input type="submit" value="Register"/>
                    </div>
                    <p class="additional-text">You already have an account? <a href="login.jsp">Sign in</a></p>
                    <!-- Error/Message Section -->
                    <div id="message">${message}</div>
                </form>
            </div>
        </div>
    </div>
</section>

<script src="./js/register.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>

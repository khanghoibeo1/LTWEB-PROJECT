<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>OTP verification</title>
  <!-- Bootstrap 5 CDN Link -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS Link -->
  <link rel="stylesheet" href="style.css">
</head>
<body>
<section class="wrapper">
  <div class="container">
    <div class="col-sm-8 offset-sm-2 col-lg-6 offset-lg-3 col-xl-6 offset-xl-3 text-center">
      <div class="logo">
        <img decoding="async" src="images/index/logo.png" class="img-fluid" alt="logo" width="200" height="200">
      </div>
      <form class="rounded bg-white shadow p-5" action="CheckOTP" method="post">
        <h3 class="text-dark fw-bolder fs-4 mb-2">Verification</h3>

        <div class="fw-normal text-muted mb-4">
          Enter the verification code we sent to your email
        </div>

        <div class="otp_input text-start mb-2">
          <label>Type your 6 digit security code</label>
          <div class="d-flex align-items-center justify-content-between mt-2">
            <input type="text" class="form-control" placeholder="" name="otp">
            <!--<input type="text" class="form-control" placeholder="">
            <input type="text" class="form-control" placeholder="">
            <input type="text" class="form-control" placeholder="">
            <input type="text" class="form-control" placeholder="">
            <input type="text" class="form-control" placeholder="">-->
          </div>
        </div>

        <button type="submit" class="btn btn-primary submit_btn my-4">Submit</button>

        <div class="fw-normal text-muted mb-2">
          Didn’t get the code ? <a href="#" class="text-primary fw-bold text-decoration-none">Resend</a>
        </div>
        <div id="message">${message}</div>
      </form>
    </div>
  </div>
</section>
</body>
</html>

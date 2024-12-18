<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Site Metas -->
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="images/index/logo.png" type="">
    <title>LaBy Shop - Product Detail</title>
    <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <!-- font awesome style -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <!-- responsive style -->
    <link href="css/responsive.css" rel="stylesheet">
</head>
<body>
    <div class="hero_area">
        <!-- header section starts -->
        <header class="header_section">
            <div class="container">
                <nav class="navbar navbar-expand-lg custom_nav-container">
                    <a class="navbar-brand" href="index.jsp"><img width="100" src="images/index/logo.png" alt="#"></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="true" aria-label="Toggle navigation">
                    <span class=""> </span>
                    </button>
                    <div class="navbar-collapse collapse show" id="navbarSupportedContent" style="">
                        <ul class="navbar-nav">
                            <li>
                                <form class="form-inline my-2 my-lg-0">
                                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                                </form>
                            </li>
                            <li>
                                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="product_detail.jsp">Home <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item dropdown">
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="product.jsp">Products</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="cart.jsp">
                                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                                        <!-- ... (your existing SVG path) ... -->
                                    </svg>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a id="loginButton" class="btn btn-outline-primary my-2 my-sm-0" href="login.jsp">Log In</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <!-- end header section -->
        
        <!-- slider section -->
        <section class="slider_section ">
            <!-- ... (your existing slider content) ... -->
        </section>
        <!-- end slider section -->

        <!-- product detail section -->
        <!-- product detail section -->
        <section class="product_detail_section layout_padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <img src="<c:out value="${product.getImage()}" />" alt="<c:out value="${product.getName()}" /> Image">
                    </div>
                    <div class="col-md-6">
                        <h2><c:out value="${product.getName()}" /></h2>
                        <p><c:out value="${product.getDescription()}" /></p>
                        <h3>Price: $<c:out value="${product.getPrice}" /></h3>
                        <h3>Price: $<c:out value="${product.getPrice()}" /></h3>
                        <div class="btn-box">
                            <label for="quantity">Quantity:</label>
                            <input type="number" id="quantity" name="quantity" value="1" min="1">
                            <button type="button" class="btn btn-outline-success" onclick="addToCart(<c:out value="${product.getProductId()}" />)">Add to Cart</button>
                            <a href="product.jsp" class="btn btn-outline-info ml-2">Continue Shopping</a>
                        </div>
                     </div>
                </div>

                <!-- Feedback Section -->
                <!-- Include your feedback content here... -->

            </div>
        </section>
       

    </div>
    <!-- jQery -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- popper js -->
    <script src="js/popper.min.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.js"></script>
    <!-- custom js -->
    <script src="js/custom.js"></script>
    <!-- AJAX Script -->
    <script>
        function addToCart(productId) {
            var quantity = $("#quantity").val();

            // Sử dụng AJAX để gửi yêu cầu thêm sản phẩm vào giỏ hàng
            $.ajax({
                type: "GET",
                url: "addToCart?productId=" + productId + "&quantity=" + quantity,
                success: function(data) {
                    // Hiển thị thông báo thành công
                    alert("Product added to cart successfully!");
                },
                error: function() {
                    alert("Error adding product to cart. Please try again.");
                }
            });
        }
    </script>
</body>
</html>

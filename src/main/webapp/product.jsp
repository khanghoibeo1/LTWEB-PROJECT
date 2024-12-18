<%-- 
    Document   : product
    Created on : Dec 6, 2023, 2:29:49 PM
    Author     : tranp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Products</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Open+Sans">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet">
<style>
body {
	background: #e2eaef;
	font-family: "Open Sans", sans-serif;
}
h2 {
	color: #000;
	font-size: 26px;
	font-weight: 300;
	text-align: center;
	text-transform: uppercase;
	position: relative;
	margin: 30px 0 60px;
}
h2::after {
	content: "";
	width: 100px;
	position: absolute;
	margin: 0 auto;
	height: 4px;
	border-radius: 1px;
	background: #7ac400;
	left: 0;
	right: 0;
	bottom: -20px;
}
.carousel {
	margin: 50px auto;
	padding: 0 70px;
}
.carousel .item {
	color: #747d89;
	min-height: 325px;
	text-align: center;
	overflow: hidden;
}
.carousel .thumb-wrapper {
	padding: 25px 15px;
	background: #fff;
	border-radius: 6px;
	text-align: center;
	position: relative;
	box-shadow: 0 2px 3px rgba(0,0,0,0.2);
}
.carousel .item .img-box {
	height: 120px;
	margin-bottom: 20px;
	width: 100%;
	position: relative;
}
.carousel .item img {	
	max-width: 100%;
	max-height: 100%;
	display: inline-block;
	position: absolute;
	bottom: 0;
	margin: 0 auto;
	left: 0;
	right: 0;
}
.carousel .item h4 {
	font-size: 18px;
}
.carousel .item h4, .carousel .item p, .carousel .item ul {
	margin-bottom: 5px;
}
.carousel .thumb-content .btn {
	color: #7ac400;
	font-size: 11px;
	text-transform: uppercase;
	font-weight: bold;
	background: none;
	border: 1px solid #7ac400;
	padding: 6px 14px;
	margin-top: 5px;
	line-height: 16px;
	border-radius: 20px;
}
.carousel .thumb-content .btn:hover, .carousel .thumb-content .btn:focus {
	color: #fff;
	background: #7ac400;
	box-shadow: none;
}
.carousel .thumb-content .btn i {
	font-size: 14px;
	font-weight: bold;
	margin-left: 5px;
}
.carousel .item-price {
	font-size: 13px;
	padding: 2px 0;
}
.carousel .item-price strike {
	opacity: 0.7;
	margin-right: 5px;
}
.carousel-control-prev, .carousel-control-next {
	height: 44px;
	width: 40px;
	background: #7ac400;	
	margin: auto 0;
	border-radius: 4px;
	opacity: 0.8;
}
.carousel-control-prev:hover, .carousel-control-next:hover {
	background: #78bf00;
	opacity: 1;
}
.carousel-control-prev i, .carousel-control-next i {
	font-size: 36px;
	position: absolute;
	top: 50%;
	display: inline-block;
	margin: -19px 0 0 0;
	z-index: 5;
	left: 0;
	right: 0;
	color: #fff;
	text-shadow: none;
	font-weight: bold;
}
.carousel-control-prev i {
	margin-left: -2px;
}
.carousel-control-next i {
	margin-right: -4px;
}		
.carousel-indicators {
	bottom: -50px;
}
.carousel-indicators li, .carousel-indicators li.active {
	width: 10px;
	height: 10px;
	margin: 4px;
	border-radius: 50%;
	border: none;
}
.carousel-indicators li {	
	background: rgba(0, 0, 0, 0.2);
}
.carousel-indicators li.active {	
	background: rgba(0, 0, 0, 0.6);
}
.carousel .wish-icon {
	position: absolute;
	right: 10px;
	top: 10px;
	z-index: 99;
	cursor: pointer;
	font-size: 16px;
	color: #abb0b8;
}
.carousel .wish-icon .fa-heart {
	color: #ff6161;
}
.star-rating li {
	padding: 0;
}
.star-rating i {
	font-size: 14px;
	color: #ffc000;
.col-md-3 {
        margin-left: 15px; /* Adjust the margin as needed */
    }

.categories {
        background-color: #f8f9fa; /* Background color for the categories box */
        padding: 15px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

.categories h4 {
        font-size: 18px;
        margin-bottom: 10px;
        color: #333; /* Text color for the category heading */
    }

.categories ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }

.categories li {
        margin-bottom: 8px;
    }

.categories a {
        text-decoration: none;
        color: #007bff; /* Link color for the categories */
        font-weight: bold;
        transition: color 0.3s ease;
    }

.categories a:hover {
        color: #0056b3; /* Hover color for the categories */
    }

    /* Style for the buttons */
.btn {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 10px 15px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

.btn:hover {
        background-color: #0056b3;
    }
}
body {
        margin: 0;
        padding: 0;
    }

    .container-xl {
        position: relative;
    }

    .categories {
        margin-right:50px;
        position: absolute;
        top: 0;
        left: 0;
        background-color: #f8f9fa; /* Màu nền của danh mục */
        padding: 15px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Hiển thị đường viền nhẹ */
    }

    .categories h4 {
        margin-bottom: 10px;
    }

    .categories ul {
        list-style: none;
        padding: 0;
        margin: 0;
    }

    .categories li {
        margin-bottom: 5px;
    }
body {
            background: #e2eaef;
            font-family: "Open Sans", sans-serif;
            margin: 0;
            padding: 0;
        }

        .container-xl {
            position: relative;
        }

        .categories {
            position: absolute;
            top: 0;
            left: 0;
            background-color: #f8f9fa; /* Màu nền của danh mục */
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Hiển thị đường viền nhẹ */
        }

        .categories h4 {
            margin-bottom: 10px;
        }

        .categories ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .categories li {
            margin-bottom: 5px;
        }

        .featured-products {
            margin-top: 20px; /* Khoảng cách giữa Categories và Featured Products */
        }

        h2 {
            color: #000;
            font-size: 26px;
            font-weight: 300;
            text-align: center;
            text-transform: uppercase;
            position: relative;
            margin: 30px 0 60px;
        }

        h2::after {
            content: "";
            width: 100px;
            position: absolute;
            margin: 0 auto;
            height: 4px;
            border-radius: 1px;
            background: #7ac400;
            left: 0;
            right: 0;
            bottom: -20px;
        }
</style>
<script>
$(document).ready(function(){
	$(".wish-icon i").click(function(){
		$(this).toggleClass("fa-heart fa-heart-o");
	});
});	
</script>
</head>
<body>
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
                           <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                       <li class="nav-item dropdown">
                        </li>
                        <li class="nav-item">
                           <a class="nav-link" href="product.jsp">Products</a>
                        </li>
                        <li class="nav-item">
                           <a class="nav-link" href="cart.jsp">
                              <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                                 <g>
                                    <g>
                                       <path d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                                          c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z"></path>
                                    </g>
                                 </g>
                                 <g>
                                    <g>
                                       <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                                          C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                                          c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                                          C457.728,97.71,450.56,86.958,439.296,84.91z"></path>
                                    </g>
                                 </g>
                                 <g>
                                    <g>
                                       <path d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                                          c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z"></path>
                                    </g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                                 <g>
                                 </g>
                              </svg>
                           </a>
                        </li>
                        <li class="nav-item">
                            <a id="loginButton" class="btn btn-outline-primary my-2 my-sm-0" href="login.jsp">Log In</a>
                        </li>
                        <li class="nav-item">
                            <a id="profileButton" class="btn btn-outline-primary my-2 my-sm-0" href="profile.jsp">Profile</a>
                        </li>
                     </ul>
                  </div>
               </nav>
            </div>
         </header>
	<div class="row">
<%--		<div class="col-md-3">--%>
<%--			<div class="categories">--%>
<%--				<h4>Categories</h4>--%>
<%--				<!-- Thay thế các danh mục cố định bằng danh mục động từ database -->--%>
<%--				<ul>--%>
<%--					<c:forEach var="category" items="${categories}">--%>
<%--						<li><a href="#" class="btn btn-outline-primary btn-block"><c:out value="${category.name}" /></a></li>--%>
<%--					</c:forEach>--%>
<%--				</ul>--%>
<%--			</div>--%>
<%--		</div>--%>

		<div class="col-md-9">
			<div class="container-xl">
				<h2>Featured <b>Products</b></h2>
				<div class="row">
					<!-- Lặp qua danh sách sản phẩm từ database -->
					<%--@elvariable id="products" type="java.util.List"--%>
					<jsp:useBean id="productList" scope="request" type="java.util.List"/>
					<c:forEach var="product" items="${productList}">
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<!-- Sử dụng đường dẫn hình ảnh từ database -->
									<img src="<c:out value="${product.getImage()}" />" class="img-fluid" alt="<c:out value="${product.name}" />">
								</div>
								<div class="thumb-content">
									<h4><c:out value="${product.getName()}" /></h4>
									<p class="item-price"><b>$<c:out value="${product.getPrice()}" /></b></p>
									<p><b>Brand:</b> <c:out value="${product.getBrand()}" /></p>
									<a href="cart.jsp" class="btn btn-primary">Add to Cart</a>
                                    <a href="#" onclick="viewProductDetail('${product.getProductId()}')">View Details</a>
								</div>
							</div>
						</div>
					</c:forEach>
                    <script>
                        function viewProductDetail(productId) {
                            // Redirect to the product detail page with the product ID
                            window.location.href = '/product_detail.jsp/loadProducts?productId=' + productId;
                        }
                    </script>
				</div>
			</div>
		</div>
	</div>
</body>
</html>                                		

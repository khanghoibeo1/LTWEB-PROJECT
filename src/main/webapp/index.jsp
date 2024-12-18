<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ecommerce.entity.Account"%>
<%@page import="ecommerce.entity.Cart"%>
<%@page import="java.util.List"%>
<%@page import="ecommerce.entity.CartLine"%>

<%
  Account acc = (Account) session.getAttribute("acc");
  Cart cart = (Cart) session.getAttribute("Cart");
%>
<!DOCTYPE html>
<html><head>
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
  <title>LaBy Shop</title>
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
  <!-- header section strats -->
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
              <a class="nav-link" href="#">
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
<%--              <a id="loginButton" class="btn btn-outline-primary my-2 my-sm-0" href="login.jsp">Log In</a>--%>
                <% if (acc != null) { %>
                <!-- If the user is logged in, show the logout button -->
                <form action="logout" method="post">
                  <a id="profileButton" class="btn btn-outline-primary my-2 my-sm-0" href="profile.jsp">Profile</a>
                  <input type="hidden" name="action" value="logout">
                  <button type="submit" >Logout</button>
                </form>
                <% } else { %>
                <!-- If the user is not logged in, show the login button -->
                <a id="loginButton" class="btn btn-outline-primary my-2 my-sm-0" href="login.jsp">Log In</a>



                <% } %>
            </li>

          </ul>
        </div>
      </nav>
    </div>
  </header>
  <!-- end header section -->
  <!-- slider section -->
  <section class="slider_section ">
    <div class="slider_bg_box">
      <img src="images/index/slider-bg.jpg" alt="">
    </div>
    <div id="customCarousel1" class="carousel slide" data-ride="carousel">
      <div class="carousel-inner">
        <div class="carousel-item">
          <div class="container ">
            <div class="row">
              <div class="col-md-7 col-lg-6 ">
                <div class="detail-box">
                  <h1>
                                    <span>
                                    Sale 20% Off
                                    </span>
                    <br>
                    On Everything
                  </h1>
                  <p>
                    Explicabo esse amet tempora quibusdam laudantium, laborum eaque magnam fugiat hic? Esse dicta aliquid error repudiandae earum suscipit fugiat molestias, veniam, vel architecto veritatis delectus repellat modi impedit sequi.
                  </p>
                  <div class="btn-box">
                    <a href="" class="btn1">
                      Shop Now
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="carousel-item active">
          <div class="container ">
            <div class="row">
              <div class="col-md-7 col-lg-6 ">
                <div class="detail-box">
                  <h1>
                                    <span>
                                    Sale 20% Off
                                    </span>
                    <br>
                    On Everything
                  </h1>
                  <p>
                    Explicabo esse amet tempora quibusdam laudantium, laborum eaque magnam fugiat hic? Esse dicta aliquid error repudiandae earum suscipit fugiat molestias, veniam, vel architecto veritatis delectus repellat modi impedit sequi.
                  </p>
                  <div class="btn-box">
                    <a href="" class="btn1">
                      Shop Now
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div class="container ">
            <div class="row">
              <div class="col-md-7 col-lg-6 ">
                <div class="detail-box">
                  <h1>
                                    <span>
                                    Sale 20% Off
                                    </span>
                    <br>
                    On Everything
                  </h1>
                  <p>
                    Explicabo esse amet tempora quibusdam laudantium, laborum eaque magnam fugiat hic? Esse dicta aliquid error repudiandae earum suscipit fugiat molestias, veniam, vel architecto veritatis delectus repellat modi impedit sequi.
                  </p>
                  <div class="btn-box">
                    <a href="" class="btn1">
                      Shop Now
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="container">
        <ol class="carousel-indicators">
          <li data-target="#customCarousel1" data-slide-to="0" class=""></li>
          <li data-target="#customCarousel1" data-slide-to="1" class="active"></li>
          <li data-target="#customCarousel1" data-slide-to="2" class=""></li>
        </ol>
      </div>
    </div>
  </section>
  <!-- end slider section -->
</div>
<!-- why section -->
<section class="why_section layout_padding">
  <div class="container">
    <div class="heading_container heading_center">

    </div>
    <div class="row">
      <div class="col-md-4">

      </div>
      <div class="col-md-4">

      </div>
      <div class="col-md-4">

      </div>
    </div>
  </div>
</section>
<!-- end why section -->

<!-- arrival section -->
<section class="arrival_section">
  <div class="container">

  </div>
</section>
<!-- end arrival section -->

<!-- product section -->
<section class="product_section layout_padding">
  <div class="container">
    <div class="heading_container heading_center">
      <h2>
        Our <span>products</span>
      </h2>
    </div>
    <div class="row">
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Men's Shirt
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p1.jpg" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa dê HiKid 650g
            </h5>
            <h6>
              579.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p2.png" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa bột Meiji HP cho bé dị ứng đạm sữa bò 850g
            </h5>
            <h6>
              850.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p3.png" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Glico Icreo Nhật Bản số 0 (0-12 tháng)
            </h5>
            <h6>
              489.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p4.jpg" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa non ILDong số 2 100g
            </h5>
            <h6>
              258.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p5.png" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Glico Icreo Nhật Bản số 1 (9-36 tháng)
            </h5>
            <h6>
              350.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p6.png" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa bột Morinaga số 0 800g (0-12 tháng)
            </h5>
            <h6>
              439.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p7.jpg" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa Aptakid New Zealand số 3 900g (24 tháng+)
            </h5>
            <h6>
              604.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p8.jpg" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa bột Meiji Kids Formula 900g (3-10 tuổi)
            </h5>
            <h6>
              495.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p9.png" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa bột Aptamil Essensis số 2 (900g)
            </h5>
            <h6>
              1.249.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p10.png" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa bột Milo (1kg)
            </h5>
            <h6>
              300.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p11.jpg" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa bột Mejsu Dimon 900g (1-10 tuổi)
            </h5>
            <h6>
              419.000đ
            </h6>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-4">
        <div class="box">
          <div class="option_container">
            <div class="options">
              <a href="" class="option1">
                Add To Cart
              </a>
              <a href="" class="option2">
                Buy Now
              </a>
            </div>
          </div>
          <div class="img-box">
            <img src="images/index/p12.jpg" alt="">
          </div>
          <div class="detail-box">
            <h5>
              Sữa bột Mejsu Gold 900g (6-36 tháng)
            </h5>
            <h6>
              425.000đ
            </h6>
          </div>
        </div>
      </div>
    </div>
    <div class="btn-box">

    </div>
  </div>
</section>
<!-- end product section -->

<!-- subscribe section -->
<section class="subscribe_section">
  <div class="container-fuild">

  </div>
</section>
<!-- end subscribe section -->
<!-- client section -->

<!-- end client section -->
<!-- footer start -->

<!-- footer end -->
<div class="cpy_">
  <p class="mx-auto">© 2023 Web Project By LTQA,TTK,VTD <br>

  </p>
</div>
<!-- jQery -->
<script src="js/jquery-3.4.1.min.js"></script>
<!-- popper js -->
<script src="js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>
</body></html>

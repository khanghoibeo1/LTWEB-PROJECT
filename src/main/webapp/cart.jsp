<%-- 
    Document   : cart
    Created on : Dec 6, 2023, 5:07:19 PM
    Author     : tranp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://code.jquery.com/jquery-3.3.1.slim.min.js">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
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
        <section class="pt-5 pb-5">
  <div class="container">
    <div class="row w-100">
        <div class="col-lg-12 col-md-12 col-12">
            <h3 class="display-5 mb-2 text-center">Shopping Cart</h3>
            <p class="mb-5 text-center">
                <i class="text-info font-weight-bold"><c:out value="${fn:length(sessionScope.cart.listCart)}" /></i> items in your cart</p>
            <table id="shoppingCart" class="table table-condensed table-responsive">
                <thead>
                    <tr>
                        <th style="width:60%">Product</th>
                        <th style="width:12%">Price</th>
                        <th style="width:10%">Quantity</th>
                        <th style="width:16%"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="cartLine" items="${sessionScope.Cart.listCart}">
                    <tr>
                        <td data-th="Product">
                            <div class="row">
                                <div class="col-md-3 text-left">
                                    <img src="<c:out value="${cartLine.product.image}" />" alt="" class="img-fluid d-none d-md-block rounded mb-2 shadow">
                                </div>
                                <div class="col-md-9 text-left mt-sm-2">
                                    <h4><c:out value="${cartLine.product.name}" /></h4>
                                    <p class="font-weight-light">Brand &amp; Name</p>
                                </div>
                            </div>
                        </td>
                        <td data-th="Price">$<c:out value="${cartLine.product.price}" /></td>
                        <td data-th="Quantity">
                            <form action="editCartItem" method="post">
                                <input type="hidden" name="productId" value="<c:out value="${cartLine.product.productId}" />">
                                <input type="number" name="newQuantity" class="form-control form-control-lg text-center" value="<c:out value="${cartLine.quantity}" />">
                                <button type="submit" class="btn btn-primary">Update</button>
                            </form>
                        </td>
                        <td class="actions" data-th="">
                            <div class="text-right">
                                <form action="deleteCartItem" method="get">
                                    <input type="hidden" name="productId" value="<c:out value="${cartLine.product.productId}" />">
                                    <button type="submit" class="btn btn-white border-secondary bg-white btn-md mb-2">
                                        <i class="fas fa-trash"></i>
                                    </button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="float-right text-right">
                <h4>Subtotal:</h4>
                <h1>$<c:out value="${sessionScope.Cart.totalPrice}" /></h1>
            </div>
        </div>
    </div>
      <div class="row mt-4 d-flex align-items-center">
          <div class="col-sm-6 order-md-2 text-right">
              <a href="checkout.jsp" class="btn btn-primary mb-4 btn-lg pl-5 pr-5">Checkout</a>
          </div>
          <div class="col-sm-6 mb-3 mb-m-1 order-md-1 text-md-left">
              <a href="product.jsp">
                  <i class="fas fa-arrow-left mr-2"></i> Continue Shopping</a>
          </div>
      </div>
  </div>
</section>
    </body>
</html>

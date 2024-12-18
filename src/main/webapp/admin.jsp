<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ecommerce.entity.Product" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel - Products</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }

        .sidebar {
            height: 100%;
            width: 250px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            padding-top: 20px;
            color: white;
        }

        .sidebar a {
            padding: 15px;
            text-decoration: none;
            font-size: 18px;
            color: #818181;
            display: block;
            transition: 0.3s;
        }

        .sidebar a:hover {
            color: #f1f1f1;
        }

        .content {
            margin-left: 250px;
            padding: 1px 16px;
            height: 1000px;
        }

        .product-box {
            margin-bottom: 20px;
            border: 1px solid #ddd;
            padding: 10px;
            overflow: hidden;
        }

        .img-box {
            float: left;
            margin-right: 20px;
        }

        .detail-box {
            float: left;
        }

        .edit-btn,
        .remove-btn {
            margin-top: 10px;
        }
        table {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>

    <div class="sidebar">
        <a href="#">Products</a>
    </div>

    <div class="content">
        <a href="addproduct.jsp" class="btn btn-success">Add Product</a>

            </div>
            <table>
                <thead>
                <tr>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Brand</td>
                    <td>Description</td>
                    <td>Image</td>
                    <td></td>
                </tr>
                </thead>

                <tbody id="tbody-product">

                <c:forEach items="${productList}" var="product">
                    <tr id="product-id-${product.getProductId()}">
                        <td class="productName">${product.getName()}</td>
                        <td class="productPrice">${product.getPrice()}</td>
                        <td class="brandProduct">${product.getBrand()}</td>
                        <td class="description">${product.getDescription()}</td>
                        <td>
                            <img class="circle-image" src="${product.getImage()}" alt="${product.getName()} Image">
                        </td>
                        <td>
                            <div class="cardBtn">
                                <button class="btn-edit" data-toggle="modal" href="editproduct.jsp">Edit</button>
                            </div>
                            <div class="cardBtn" action="deleteProduct" method="post">
                                <button id="delete-btn-id-${product.getProductId()}" class="btn-delete" data-toggle="modal" >Delete</button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>
        <!-- Loop through the product list and display product information -->

    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

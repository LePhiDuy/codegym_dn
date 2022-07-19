<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/23/2022
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <title>Product Manager</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Product Manager</h1>

        <div class="content">

            <a class="btn btn-info" href="/products?action=create">Add new product</a>
            <form class="search form-inline" method="post" action="/products?action=search">
                <table class="table">
                    <tr>
                        <th>Product name</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Color</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name = "name" placeholder="Enter Product Name">
                        </td>
                        <td>
                            <input type="text" name = "price" placeholder="Enter Price">
                        </td>
                        <td>
                            <input type="text" name = "category" placeholder="Enter Category">
                        </td>
                        <td>
                            <input type="text" name = "color" placeholder="Enter Color">
                        </td>
                        <td>
                            <input type="submit" value = "Search">
                        </td>
                    </tr>
                </table>
            </form>

            <div class="content-body">
                <c:if test="${search != null}">
                    <a href="/products" class="btn btn-info">Back to home</a>
                </c:if>
                <c:if test="${addSuccess != null}">
                    <h5 class="text-success">${addSuccess}</h5>
                </c:if>
                <c:if test="${noticeDelete != null}">
                    <h5 class="text-success">${addSuccess}</h5>
                </c:if>
                <h2 class="text-center">List product</h2>
                <table class="table table-striped table-bordered">
                    <tr class="bg-info text-center">
                        <th>ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Color</th>
                        <th>Category</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.getId()}</td>
                            <td>${product.getName()}</td>
                            <td>${product.getPrice()}</td>
                            <td class="text-center">${product.getQuantity()}</td>
                            <td>${product.getColor()}</td>
                            <c:forEach var="category" items="${categories}">
                                <c:if test="${category.getId() == product.getId_category()}">
                                    <td>${category.getName()}</td>
                                </c:if>
                            </c:forEach>
                            <td class="text-center">
                                <a class="btn btn-danger" href="/products?action=edit&id=${product.getId()}">Edit</a>
                                <button class="btn btn-danger" data-toggle="modal" data-target="#myModal" data-id="${product.getId()}">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <!-- The Modal -->
        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Do you want to delete this product?</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
                        <a href="/products?action=delete&id=">
                            <button type="button" class="btn btn-danger">Yes</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        $('#myModal').on('show.bs.modal', function (e) {
            let productId = $(e.relatedTarget).attr('data-id');
            document.querySelector("a[href^='/products?action=delete&id=']").href = '/products?action=delete&id=' + productId;
        });

    </script>
</body>
</html>

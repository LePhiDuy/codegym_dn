<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">

    <style>
        th {
            text-align: left;
        }
        input, select {
            width: 100%;
        }
    </style>
</head>

<body>
<div class="container">
    <h2 class="text-center mt-4 mb-4">Edit product</h2>
    <form method="post">
        <table class="table table-striped bg-light">
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" required value="${product.getName()}"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" required value = "${product.getPrice()}"/>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" required  value = "${product.getQuantity()}"/>
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" required value = "${product.getColor()}"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="desc" required value="${product.getDesc()}"/>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select name="idCategory">
                        <c:forEach var="category" items="${categories}">
                            <c:if test="${category.getId() == product.getId_category()}">
                                <option value="${category.getId()}">${category.getName()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="category" items="${categories}">
                            <c:if test="${category.getId() != product.getId_category()}">
                                <option value="${category.getId()}">${category.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <button type="submit" class="btn btn-success">Edit</button>
                    <a href="/products" class="btn btn-dark">Back</a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

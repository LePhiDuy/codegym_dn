<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
    <h1>List Product</h1>
    <p><a href="/products?action=create">Create new product</a></p>
    <input type="text" name="search">
    <input type="button" value="Search">
    <table class="table" border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items= "${products}" var = "product">
                <tr>
                    <td><a href="/products?action=view&id=${product.getId()}"></a>${product.getName()}</td>
                    <td>${product.getPrice()}</td>
                    <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
                    <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 84354
  Date: 7/1/2022
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit product</h1>
<form action="/products" method="post">
    <fieldset>
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${product.id}">
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="OK"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

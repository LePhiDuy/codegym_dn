<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/bootstrap-5.1.3/css/bootstrap.css">
</head>
<body>
<div class="container">
    <a class="btn btn-success" href="product/save.jsp" role="button">Create</a>
    <h1>Product List</h1>
    <c:if test="${empty productList}">
        <h1 style="color: red">Product List Empty</h1>
    </c:if>

    <c:if test="${not empty productList}">
        <table class="table" border="1px">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Color</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.color}</td>
                    <td>
                        <a class="btn btn-danger" href="/products?action=save&id=${product.id}" role="button">Edit</a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="/products?action=delete&id=${product.id}" role="button">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
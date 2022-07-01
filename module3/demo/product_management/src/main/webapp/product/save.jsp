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
    <div class="row justify-content-center mt-4">
        <form class="col-md-6" method="post" action="/products">
            <input type="hidden" name="action" value="save">
            <c:if test="${product != null}">
                <h1 class="">Edit product</h1>
            </c:if>
            <c:if test="${product == null}">
                <h1 class="">Create product</h1>
            </c:if>
            <input type="hidden" name= "id" value="${product.getId()}">
            <div class="form-group">
                <label for="txtName">Product Name</label>
                <input type="text" class="form-control" name="productName" id="txtName" value="${product.name}">
            </div>
            <div class="form-group">
                <label for="txtPrice">Product price</label>
                <input type="text" class="form-control" name="productPrice" id="txtPrice" value="${product.price}">
            </div>
            <div class="form-group">
                <label for="txtColor">Product Color</label>
                <input type="text" class="form-control" name="productColor" id="txtColor" value="${product.color}">
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Create</button>
                <button class="btn btn-warning" role="button">Cancel</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>

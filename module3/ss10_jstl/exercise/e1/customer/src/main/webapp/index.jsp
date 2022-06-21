<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Danh sách khách hàng</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
  <h1>Danh sách khách hàng</h1>
  <c:if test="${empty customerList}">
    <h1 style="color: red">List customer empty</h1>
  </c:if>
  <c:if test="${not empty customerList}">
    <table class="table">
      <thead>
      <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${customerList}" var ="customer">
        <tr>
          <td>${customer.name}</td>
          <td>${customer.birthday}</td>
          <td>${customer.address}</td>
          <td>${customer.img}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>
</body>
</html>

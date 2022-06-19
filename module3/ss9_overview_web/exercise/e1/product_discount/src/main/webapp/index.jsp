<%--
  Created by IntelliJ IDEA.
  User: 84354
  Date: 6/20/2022
  Time: 2:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form action="/discount" method="post">
      <label>Product Description</label>
      <input type="text" name="description">
      <br><br>
      <label>List Price</label>
      <input type="text" name="listPrice">
      <br><br>
      <label>Discount Percent</label>
      <input type="text" name="discountPercent">
      <br><br>
      <input type="submit" id="submit" value="Calculate Discount">
  </form>
  </body>
</html>

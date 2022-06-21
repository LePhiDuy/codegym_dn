<%--
  Created by IntelliJ IDEA.
  User: 84354
  Date: 6/20/2022
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency converted</title>
  </head>
  <body>
  <form action="converter.jsp" method="post">
    <h1>CURRENCY CONVERTED</h1>
    <label>Rate:</label><br>
    <input type="text" name="rate"><br>
    <label>USD:</label><br>
    <input type="text" name="usd"><br>
    <input type="submit" value="Converted">
  </form>

  </body>
</html>

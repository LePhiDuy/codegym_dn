<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator" method="post">
      <div>
          <label>Number 1</label><input type="text" name="num1">
          <label>Number 2</label><input type="text" name="num2">
          <input type="hidden" id="operator" name="operator">
      </div>
      <div>
          <button type="submit" onclick="document.getElementById('operator').value = '+'">Addition(+)</button>
          <button type="submit" onclick="document.getElementById('operator').value = '-'">Subtraction(+)</button>
          <button type="submit" onclick="document.getElementById('operator').value = '*'">Multiplication(X)</button>
          <button type="submit" onclick="document.getElementById('operator').value = '/'">Division(/)</button>
      </div>
  </form>
  <c:if test="${not empty result}">
      <h2>Result: ${result}</h2>
  </c:if>
  </body>
</html>

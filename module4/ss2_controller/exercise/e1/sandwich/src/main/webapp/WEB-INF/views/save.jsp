<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List condiments of Sandwich</h1>
    <c:forEach var="condiment" items="${condiments}">
        ${condiment}
    </c:forEach>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 84354
  Date: 7/26/2022
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
</head>
<body>
<form:form modelAttribute="employee" action="addEmployee" method="post">
    <table>
        <tr>
            <form:label path="id">ID</form:label>
            <form:input path="id"></form:input>
        </tr>
        <tr>
            <form:label path="name">Name</form:label>
            <form:input path="name"></form:input>
        </tr>
        <tr>
            <form:label path="contactNumber">Contact Number</form:label>
            <form:input path="contactNumber"></form:input>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>

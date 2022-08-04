<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 84354
  Date: 7/20/2022
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="student" method="post">
    <table border="1">
        <tr>
            <th>ID</th>
            <td>
                <form:input path="id"/>
            </td>
        </tr>
        <tr>
            <th>Name</th>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <th>Gender</th>
            <td>
                <form:radiobutton path="gender" value="1" label="Male"/>
                <form:radiobutton path="gender" value="0" label="Female"/>
                <form:radiobutton path="gender" value="2" label="LGBT"/>
            </td>
        </tr>
        <tr>
            <th>Gender</th>
            <td>
                <form:checkboxes path="languages" items="${languageList}" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Create</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

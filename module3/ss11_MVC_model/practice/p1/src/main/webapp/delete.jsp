<%--
  Created by IntelliJ IDEA.
  User: 84354
  Date: 6/17/2022
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
    <h1>Delete Customer</h1>
    <p>
        <a href="/customers">Back to list customers</a>
    </p>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>Customer information</legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td>${requestScope["customer"].getName()}</td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td>${requestScope["customer"].getEmail()}</td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td>${requestScope["customer"].getAddress()}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete customer"></td>
                    <td><a href="/customers">Back to customer list</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 84354
  Date: 6/20/2022
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Calculator</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
</head>
<body>
<h1>Simple Calculator</h1>
<form method="post" action="/calculator">
    <fieldset>
        <legend>Calculator</legend>
        <table class="table">
            <tbody>
            <tr>
                <td>First operand:</td>
                <td><input type="text" name="firstOperand"></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td><select name="operator">
                    <option value="Addition">Addition</option>
                    <option value="Sub">Sub</option>
                    <option value="Mutil">Multi</option>
                    <option value="Division">Division</option>
                </select></td>
            </tr>
            <tr>
                <td>Second operand:</td>
                <td> <input type="text" name="secondOperand"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"></td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>
</body>
</html>

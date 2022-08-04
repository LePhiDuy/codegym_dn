<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="setting" method="post" action="save">
    <div>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="language">
                    <form:option value="English"></form:option>
                    <form:option value="VietNamese"></form:option>
                    <form:option value="Japanese"></form:option>
                    <form:option value="Chinese"></form:option>
                </form:select>
            </td>
        </tr>
    </div>
    <div>
        <tr>
            <td>Page Size:</td>
            <td>Show
                <form:select path="pageSize">
                    <form:option value="5"></form:option>
                    <form:option value="10"></form:option>
                    <form:option value="15"></form:option>
                    <form:option value="25"></form:option>
                    <form:option value="50"></form:option>
                    <form:option value="100"></form:option>
                </form:select>
                email per page
            </td>
        </tr>
    </div>
    <div>
        <tr>
            <td>Spams filter:</td>
            <td>
                <form:checkbox path="spamFilter" value= "true" />
                Enable spams filter
            </td>
        </tr>
    </div>
    <div>
        <tr>
            <td>Singature</td>
            <td>
                <form:textarea path="signature" rows="5" cols="15"></form:textarea>
            </td>
        </tr>
    </div>
    <div>
        <input type="submit" value="Update">
        <input type="button" value="Cancel">
    </div>

</form:form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
        integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
        crossorigin="anonymous"></script>
</body>
</html>

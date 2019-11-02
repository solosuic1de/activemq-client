<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title></head>
<style>
    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
</style>
<body>
<h3>Enter The Employee Details</h3>
<%--@elvariable id="employee" type="com.mycompany.server.model.entity.Employee"--%>
<form:form method="POST"
           action="${pageContext.request.contextPath}/addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="firstName">Name</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Surname</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="email">
                email</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
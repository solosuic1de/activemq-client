<%--
  Created by IntelliJ IDEA.
  User: solos
  Date: 03.11.2019
  Time: 03:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All</title>
</head>
<style>
    table, td, th {
        border: 1px solid #4CAF50;
        text-align: left;
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        padding: 15px;
    }

    h1.err {
        color: red;
    }
</style>
<body>
<h1 class="err">${error}</h1>
<table>
    <tr>
        <td><c:out value="id"/></td>
        <td><c:out value="Name"/></td>
        <td><c:out value="Surname"/></td>
        <td><c:out value="email"/></td>
    </tr>
    <c:forEach items="${list}" var="emloyee">
        <tr>
            <td><c:out value="${emloyee.id}"/></td>
            <td><c:out value="${emloyee.firstName}"/></td>
            <td><c:out value="${emloyee.lastName}"/></td>
            <td><c:out value="${emloyee.email}"/></td>
        </tr>
    </c:forEach>
</table
</body>
</html>

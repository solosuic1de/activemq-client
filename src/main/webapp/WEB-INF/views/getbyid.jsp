<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: solos
  Date: 03.11.2019
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get by id</title>
</head>
<style>

    h1.err {
        color: red;
    }

    p.empl {
        font-weight: bold;
        color: green;
    }

</style>
<body>


<h1 class="err">${error}</h1>


<p class="empl">id: ${employee.id}</p>
<p class="empl">name: ${employee.firstName}</p>
<p class="empl">surname: ${employee.lastName}</p>
<p class="empl">email: ${employee.email}</p>
<br/>


</body>
</html>

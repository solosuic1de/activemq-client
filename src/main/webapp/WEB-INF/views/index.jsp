<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Test Project</title>
</head>
<style>
    input[type=number], select {
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
<div>
    <form action="${pageContext.request.contextPath}/getAll" method="get">
        <input type="submit" value="Get all employee in db">
    </form>
    <form id="get" onsubmit="addToPathGet()">
        <input type="number" name="id">
        <input type="submit" value="Get employee by id">
    </form>
    <form action="${pageContext.request.contextPath}/add" method="get">
        <input type="submit" value="Add new employee in db">
    </form>

    <form id="delete" onsubmit="addToPathDelete()">
        <input type="number" name="id">
        <input type="submit" value="Delete employee by id">
    </form>

</div>
</body>
<script>
    function addToPathGet() {
        var action_src = "http://localhost:8080/spring_mvc_helloworld_example_war_exploded/get/" + document.getElementsByName("id")[0].value;
        var form = document.getElementById('get');
        form.action = action_src;
    }

    function addToPathDelete() {
        var action_src = "http://localhost:8080/spring_mvc_helloworld_example_war_exploded/delete/" + document.getElementsByName("id")[1].value;
        var form = document.getElementById('delete');
        form.action = action_src;
    }
</script>
</html>
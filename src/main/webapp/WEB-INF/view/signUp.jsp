<%--
  Created by IntelliJ IDEA.
  User: Illia
  Date: 19.09.2020
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>

<div class="form">

    <h1>Sing Up</h1><br>
    <form method="post" action="/signUp">

        <label><input type="text" required placeholder="username" name="username"></label><br>

        <label><input type="password" required placeholder="password" name="password"></label><br>

        <input type="submit" value="Ok" name="Ok"><br>
    </form>
</div>
</body>
</html>

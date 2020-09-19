<%--
  Created by IntelliJ IDEA.
  User: Illia
  Date: 19.09.2020
  Time: 10:52
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

    <h1>Вход в систему</h1><br>
    <form method="post" action="">

        <input type="text" required placeholder="username" name="username"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Sign in">

    </form>
    <br>
    <a href="/signUp">Sign Up</a>
</div>
</body>
</html>

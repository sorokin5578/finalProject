<%--
  Created by IntelliJ IDEA.
  User: Illia
  Date: 20.09.2020
  Time: 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>

</head>
<body>
<h2>Edit conference <c:out value="${conference.name}"/></h2><br />

    <form method="post" action="/edit_conference">
        <label><input type="text" name="name" value="${conference.name}"></label><br>

        <label><input type="text" name="topic" value="${conference.topic}" ></label><br>

        <label><input type="datetime-local" name="conferenceDate" value="${conference.conferenceDate}">${conference.conferenceDate}</label><br>

        <input type="submit" value="Edit" name="Edit"><br>
    </form>

</body>
</html>

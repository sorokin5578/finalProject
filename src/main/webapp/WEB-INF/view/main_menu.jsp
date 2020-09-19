<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Hello <c:out value="${role}"/>!</h1>
<a href="/logout">Logout</a><br><br>


<h1>Hello from my Project</h1><br />

<h2>All conferences</h2><br />

<c:forEach var="conference" items="${requestScope.conferences}">
    <ul>

        <li>Name: <c:out value="${conference.name}"/></li>

        <li>Topic: <c:out value="${conference.topic}"/></li>

        <li>Conference Date: <c:out value="${conference.conferenceDate}"/></li>
    </ul>
    <hr />

</c:forEach>

<h2>Создание новой конференции</h2><br />

<form method="post" action="/main_page">

    <label><input type="text" name="name"></label>Name<br>

    <label><input type="text" name="topic"></label>Topic<br>

    <label><input type="datetime-local" name="conferenceDate"></label>Conference Date<br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
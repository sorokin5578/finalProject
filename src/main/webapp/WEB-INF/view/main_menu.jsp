<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.epam.java.project.entity.Role" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Hello ${user.username}!</h1>
<%--<h1>Hello <c:out value="${username}"/>!</h1>--%>
<a href="/logout">Logout</a><br><br>

<h2>All conferences</h2><br/>

<c:forEach var="conference" items="${requestScope.conferences}">
    <ul>

        <li>Name: <c:out value="${conference.name}"/></li>

        <li>Topic: <c:out value="${conference.topic}"/></li>

        <li>Topic: <c:out value="${conference.speaker.username}"/></li>

        <li>Conference Date: <c:out value="${conference.conferenceDate}"/></li>
        <c:if test="${user.role==Role.ADMIN||(user.role==Role.SPEAKER&&conference.speaker.username==user.username)}">
            <form method="get" action="/edit_conference">
                <input type="hidden" name="confId" value="${conference.id}">
                <input type="submit" value="edit" name="Edit">
            </form>
            <form method="post" action="/delete_conference">
                <input type="hidden" name="confId" value="${conference.id}">
                <input type="submit" value="delete" name="Delete">
            </form>
        </c:if>
    </ul>
    <hr/>

</c:forEach>
<c:if test="${user.role==Role.ADMIN||user.role==Role.SPEAKER}">
    <h2>Создание новой конференции</h2><br/>

    <form method="post" action="/main_page">

        <label><input type="text" name="name"></label>Name<br>

        <label><input type="text" name="topic"></label>Topic<br>

        <label><input type="datetime-local" name="conferenceDate"></label>Conference Date<br>

        <input type="submit" value="Ok" name="Ok"><br>
    </form>
</c:if>
</body>
</html>
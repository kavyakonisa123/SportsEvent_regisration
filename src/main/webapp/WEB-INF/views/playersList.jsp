<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Players List</title>
</head>
<body>
<h2>Players List</h2>
<table>
    <tr>
        <th>Player Name</th>
        <th>Team</th>
    </tr>
    <c:forEach var="player" items="${players}">
        <tr>
            <td>${player.playerName}</td>
            <td>${player.team.teamName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

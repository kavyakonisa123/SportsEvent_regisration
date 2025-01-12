<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User registration</title>
</head>
<body>
<form:form action="#" modelAttribute="user" method="POST">
  <form:input path="username" />
  <form:input path="email" />
  <form:select path="selectedTeamId" items="${teams}" itemValue="teamId" itemLabel="teamName" />
  <form:select path="selectedPlayerId" items="${players}" itemValue="playerId" itemLabel="playerName" />
  <input type="submit" value="Register" />
</form:form>


</body>
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User registration</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #6495ED;
}

form {
	max-width: 500px;
	margin: auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: beige;
}

label {
	margin: 10px 0 5px;
	display: block;
	color: #333;
}

input[type="text"], select {
	width: 100%;
	padding: 10px;
	margin: 5px 0 20px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
.error {
            color: red;
        }
</style>
</head>
<body>
	<form:form action="#" modelAttribute="user" method="POST">
		<label for="username">Username</label>
		<form:input path="username" required="true" />
		<form:errors path="username" cssClass="error" />
		<label for="email">Email</label>
		<form:input path="email" type="email" required="true" />
		<form:errors path="email" cssClass="error" />
		<label for="selectedEventId">Event</label>
		<form:select path="selectedEventId" items="${events}"
			itemValue="eventId" itemLabel="eventName" />
		<label for="selectedTeamId">Team</label>
		<form:select path="selectedTeamId" items="${teams}" itemValue="teamId"
			itemLabel="teamName" />
		<label for="selectedPlayerId">Player</label>
		<form:select path="selectedPlayerId" items="${players}"
			itemValue="playerId" itemLabel="playerName" />
		<input type="submit" value="Register" />
	</form:form>
</body>
</html>



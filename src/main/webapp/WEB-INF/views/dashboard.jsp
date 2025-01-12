<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
<title>Dashboard</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</head>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #6495ED;
    }

    h1, h2 {
        color: #333;
        text-align: center;
    }

    section {
        margin: 20px;
        padding: 20px;
        background: white;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        background-color: beige;
        
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        padding: 10px;
        border-bottom: 1px solid #eee;
    }

    li:last-child {
        border-bottom: none;
    }

    canvas {
        max-width: 100%;
        box-sizing: border-box;
        
    }

    /* Style for div elements inside li */
    li > div {
        margin-bottom: 5px;
    }

    /* Custom styling for specific div elements */
    div.username {
        font-weight: bold;
        color: #007bff; /* Blue color */
    }

    div.email {
        color: #28a745; /* Green color */
    }

    div.team {
        color: #dc3545; /* Red color */
    }

    div.player {
        font-style: italic;
        color: #6610f2; /* Purple color */
    }

    div.event {
        font-weight: bold;
        color: #fd7e14; /* Orange color */
    }
</style>
<body>

	<h1>Event Dashboard</h1>


<section>
    <h2>Registration Completed Successfully for</h2>
    <c:if test="${not empty registrationMessages}">
        <ul>
            <c:set var="lastMessage" value="${registrationMessages[registrationMessages.size() - 1]}" />
            <li>
                <div>Username: ${lastMessage.username}</div>
                <div>Email: ${lastMessage.email}</div>
                <div>Team Selected: ${lastMessage.selectedTeamId.teamName}</div>
                <div>Player Selected: ${lastMessage.selectedPlayerId.playerName}</div>
                <div>Event Selected: ${lastMessage.selectedEventId.eventName}</div>
            </li>
        </ul>
    </c:if>
    <c:if test="${empty registrationMessages}">
        <p>No registrations found.</p>
    </c:if>
</section>


	<section id="visualizations">
		<h2>Visualizations</h2>
		<canvas id="userRegistrationsChart" width="400" height="200"></canvas>
	</section>
	<!-- Highest Selected Player -->
	<section id="highestSelectedPlayer">
		<h2>Highest Selected Player</h2>
		<p>${highestSelectedPlayer.playerName}(Selected
			${highestSelectedPlayer.userSelectionCount} times)</p>
	</section>

	<!-- Highest Selected Team -->
	<section id="highestSelectedTeam">
		<h2>Highest Selected Team</h2>
		<p>${highestSelectedTeam.teamName}(Selected
			${highestSelectedTeam.userSelectionCount} times)</p>
	</section>

	<!-- User Registrations -->
	<section id="userRegistrations">
		<h2>User Registrations</h2>
		<ul>
			<c:forEach var="user" items="${userRegistrations}">
				<li>${user.username}-Registered on ${user.registrationTime}</li>
			</c:forEach>
		</ul>
	</section>



	<script>
		const dates = JSON.parse('${datesJson}');
		const counts = JSON.parse('${countsJson}');

		const ctx = document.getElementById('userRegistrationsChart')
				.getContext('2d');
		const userRegistrationsChart = new Chart(ctx, {
			type : 'bar',
			data : {
				labels : dates,
				datasets : [ {
					label : 'User Registrations',
					data : counts,
					backgroundColor : 'rgba(75, 192, 192, 0.2)',
					borderColor : 'rgba(75, 192, 192, 1)',
					borderWidth : 1
				} ]
			},
			options : {
				scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true
						}
					} ]
				}
			}
		});
	</script>

</body>
</html>

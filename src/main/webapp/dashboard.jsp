<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./CSS/dashboard.css">
</head>
<body>

	<nav>
        <h1>RoomStay</h1>

        <div class="links">
            <p><a href="#">Service</a></p>
            <p><a href="#" class="fetchDataBtn">Contact</a></p>
            <p><a href="feedback.jsp">Feedback</a></p>
            <%
            	ArrayList userInfo = (ArrayList) session.getAttribute("userInfo");
            	ArrayList adminInfo = (ArrayList) session.getAttribute("adminInfo");
            	if(userInfo != null) {
            %>
            <p>Hii, <%=userInfo.get(0) %></p>
            <%
            	}
            	else if(adminInfo != null) {
            %>
            <p><a href="dashboard.jsp">Dashboard</a></p>
            <p><%=adminInfo.get(0) %></p>
            <%
            	}
            	else{
            %>
            
            <p><a href="login.jsp">Login</a></p>
            <p><a href="register.jsp">Signup</a></p>
            <%
            	}
            %>
        </div>
    </nav>

	<div class="bar-chart">
		<canvas id="genderChart" width="400" height="400"></canvas>
		<canvas id="statusChart" width="400" height="400"></canvas>
	</div>
	
	<div class="bar-chart">
		<canvas id="wifiServiceChart" width="400" height="400"></canvas>
		<canvas id="onlineBookingChart" width="400" height="400"></canvas>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	
	<script type="text/javascript" src="./JS/displayCharts.js"></script>
	
</body>
</html>
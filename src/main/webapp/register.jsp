<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./CSS/registerPage.css">
</head>
<body>
	<div class="container">

        <div class="image-content">
            <div class="content">
                <h2>JAVAHIVE</h2>
                <h2>Unlock Your</h2>
                <h2>Performance</h2>
            </div>
            <div class="image">
                <img src="./Images/login-form3.png" alt="">
            </div>

        </div>

        <div class="log-form">
            <h2 class="log-header">Welcome to JAVAHIVE</h2>
            <h3 class="log-header">Register</h3>
            <form action="${pageContext.request.contextPath}/registerController" method="post">
                <div class="full-name">
                    <input type="text" class="names" placeholder="First name" name="firstname">

                    <input type="text" class="names" placeholder="Last name" name="lastname">
                </div>

                <input type="text" class="log-input" placeholder="Phone number" name="phone">

                <input type="text" class="log-input" placeholder="Email address" name="email">

                <input type="password" class="log-input" placeholder="Password" name="password">

                <!-- <div class="forgot-pass">
                <a href="#">Forgot Password?</a>
            </div> -->

                <input type="submit" value="register" class="log-input">
            </form>

            <div class="register">
                <a href="login.jsp">Login</a>
            </div>
        </div>
    </div>
    
    <%
	    String errorMessage = (String)request.getAttribute("registerError");
	    if(errorMessage != null) {
	 %>
    <div class="message">
    	
	    <p><%= errorMessage %></p>
    </div>
    
    <% 
	    }
    %>
    
    <script>
		setTimeout(function() {
	        const successMsg = document.querySelector('.message');
	        if (successMsg) {
	            successMsg.style.display = 'none';
	        }
	    }, 5000);
	</script>
</body>
</html>
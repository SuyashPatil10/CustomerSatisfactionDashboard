<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./CSS/loginPage.css">
</head>
<body>
	<div class="container">

        <div class="image-content">
            <div class="content">
                <h2>RoomStay</h2>
                <h2>Unlock Your</h2>
                <h2>Performance</h2>
            </div>
            <div class="image">
                <img src="./Images/login-form3.png" alt="">
            </div>

        </div>

        <div class="log-form">
            <h2 class="log-header">Welcome to RoomStay</h2>
            <h3 class="log-header">Login</h3>

            <form action="${pageContext.request.contextPath}/loginController" method="post">
                <input type="text" class="log-input" name="email" placeholder="Email address">

                <input type="password" class="log-input" name="password" placeholder="Password">

                <div class="forgot-pass">
                    <a href="#">Forgot Password?</a>
                </div>

                <input type="submit" value="login" id= "loginBtn" class="log-input">
            </form>

            <div class="register">
                <a href="admin.jsp">admin</a>
            </div>
        </div>
    </div>
    
    <%
	    String errorMessage = (String)request.getAttribute("loginError");
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
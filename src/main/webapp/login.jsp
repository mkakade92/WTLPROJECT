<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
 	<meta charset="UTF-8">
 	<link rel="stylesheet" href="./loginStyle.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>
	<!-- User already logged in -->
	<c:if test="${not empty uid}">
		<c:redirect url="./dashboard.jsp"/>
	</c:if>

    <div class="wrapper fadeInDown">
        <div id="formContent">
          <!-- Tabs Titles -->
      
          <!-- Icon -->
          <div class="fadeIn first">
            <img id="logo" src="./images/pict-logo.jpeg" id="icon" alt="User Icon" />
          </div>
      
          <!-- Login Form -->
          <form action="/StudenLogin.java" method="post">
            <input type="text" id="username" class="fadeIn second" name="uname" placeholder="Username">
            <input type="text" id="password" class="fadeIn third" name="pwd" placeholder="Password">
            <input type="submit" class="fadeIn fourth" value="Log In">
          </form>
      
          <!-- Remind Password -->
          <div id="formFooter">
            <a class="underlineHover" href="#">Forgot Password?</a>
            <a class="underlineHover" href="./signUp.jsp">Not a Member? Sign up here</a>
          </div>
        </div>
      </div>
      <c:choose>
      	<c:when test="${not empty message}">
      		<c:redirect url="/dashboard.jsp"/>
      	</c:when>
      	<c:when test="${empty message}">
      		<p><h5>Invalid username or Password</h5>
      	</c:when>
      </c:choose>
      	
      	
</body>

</html>
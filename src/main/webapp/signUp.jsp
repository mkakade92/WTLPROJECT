<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
</head>

<head>
 	<meta charset="UTF-8">
 	<link rel="stylesheet" href="./signUpStyle.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
</head>

<body>
    <div class="wrapper fadeInDown">
        <div id="formContent">
          <!-- Tabs Titles -->
      
          <!-- Icon -->
          <div class="fadeIn first">
            <img id="logo" src="./images/pict-logo.jpeg" id="icon" alt="User Icon" />
          </div>
      
          <!-- Login Form -->
          <form>
          <div id="name">
          	<input type="text" id="FName" class="fadeIn second" name="fName" placeholder="First Name">
          	<input type="text" id="LName" class="fadeIn second" name="lNAme" placeholder="Last Name">
		  </div>
			<input type="text" id="Class" class="fadeIn third" name="_Class" placeholder="Class">
			<input type="text" id="RollNo" class="fadeIn fourth" name="rollno" placeholder="Roll Number">          	  	
            <input type="text" id="username" class="fadeIn fifth" name="uName" placeholder="Username">
            <input type="text" id="password" class="fadeIn sixth" name="pwd" placeholder="Password">
            <input type="submit" class="fadeIn seventh" value="Sign Up">
          </form>
      
          <!-- Remind Password -->
          <div id="formFooter">
            <a class="underlineHover" href="./login.jsp">Already a Member? Sign in here</a>
          </div>
      
        </div>
      </div>
</body>
</html>
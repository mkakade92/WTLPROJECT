<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<head>
	<meta charset="UTF-8">
 	<link rel="stylesheet" href="./dashboardStyle.css">
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>    
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
   	<script src="./dashboardScript.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<title>Home</title>
	
</head>
<html>
<body>

	<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	%>
	
	<c:if test="${sessionScope.uname != null}">
		<c:forEach items="${requestScope.Student}" var="item" >
				<h1>Welcome ${sessionScope.uname} ${requestScope.fName} ${requestScope.lName}</h1>
		</c:forEach>
				<div class="formContainer">
					<div class="formContainer-centered">
						<form id="uploadForm" action="UploadGrievance" method="GET" >
							<input type="text" name="title" placeholder="Title">
							<textarea name="grievance" rows="5" cols="100" maxlength="500" ></textarea>
							<input type="submit" id="uploadBtn" value="submit">
						</form>
					</div>
					<div class="viewGrievance">
						<button type="button" id="viewG">View Grievance </button>
					</div>
					<form action="Logout" method="GET">
						<input type="submit" value="Logout">
					</form> 
					<div id="UploadSuccessMsg"></div>	
				</div>
				<div class="displayGrievance">
				<table id="GrievanceTable">
				</table>
				</div>
				<div class="deleteGrievanceMsg">
				<c:out value="${requestScope.MSG}"></c:out>
				 </div>
	</c:if>
	<c:if test="${sessionScope.uname == null}">
		<c:redirect url="/login.jsp"/>
	</c:if>
	
	
</body>
</html>

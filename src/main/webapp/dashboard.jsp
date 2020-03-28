<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>
	<c:forEach var="item" items="${data}">
	<p>${item.fName}</p>
	<p>${item.lName}</p>
	<p>${item._Class}</p>
	</c:forEach>
</body>
</html>

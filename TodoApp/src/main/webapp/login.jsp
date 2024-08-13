<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">Login Page</h1>
<div class="container w-25">
<form action="login" method="post">
	<label class="form-label" for="userid">Enter UserID :</label>
	<input class="form-control" id="userid" type="text" name="userid" required="required">
	<%@ include file="msg.jsp" %>
	
	<label class="form-label" for="password">Enter Password :</label>
	<input class="form-control" id="password" type="text" name="password" required="required">
	<br>
	<button class="btn btn-success">Log In</button>
	</form>
</div>
</body>
</html>
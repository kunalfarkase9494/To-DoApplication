<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ include file="msg.jsp"%>
<h1 class="text-center">Sign Up</h1>
<div class="container w-25 border border-rounded">
	<form action="signup" method="post">
	<label class="form-label" for="userid">Enter UserID :</label>
	<input class="form-control" id="userid" type="text" name="userid" required="required">
	
	
	<label class="form-label" for="password">Enter Password :</label>
	<input class="form-control" id="password" type="text" name="password" required="required">
	
	<label class="form-label" for="email">Enter Email :</label>
	<input class="form-control" id="email" type="text" name="email" required="required">
	<br>
	<button class="btn btn-success">Sign Up</button>
	
	<a href="showloginpage" class="btn btn-primary">Login</a>
	</form>
</div>

</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Model.Note"%>
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
<%
String check = (String)session.getAttribute("check");
if(check!=null){
String oldNote = (String)session.getAttribute("oldNote");
%>
<h1 class="text-center">Update Note</h1>
<div class="container w-75">
	<form action="updatedNote">
	<input type="hidden" name="userid" value="<%=check%>">
	<input type="hidden" name="oldNote" value="<%=oldNote%>">
	<input type="text" class="form-control" value="<%=oldNote %>" name="newNote">
	<button class="btn btn-success">Updated</button>
	</form>
</div>
<%
}
else{
	response.sendRedirect("login.jsp");
}
%>




</body>
</html>
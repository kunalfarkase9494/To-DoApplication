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
	
%>
<h1 class="text-center">Write Note</h1>
<div class="container w-50">

<form action="addnote">
<input type="hidden" name="userid" value="<%=check %>">
<textarea rows="5" cols="10" name="note" class="form-control"></textarea>
<button class="btn btn-success">Submit</button>
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
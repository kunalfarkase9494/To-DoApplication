<%@page import="com.Model.Note"%>
<%@page import="java.util.ArrayList"%>
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
<p>Hello <%=check %></p>
<h1 class="text-center">Dashboard</h1>
<div class="container w-75">
<div class="position-relative">
<a href="addnote.jsp" class="btn btn-info">Add Note</a>
<div class="position-absolute bottom-0 end-0">
<a href="logout" class="btn btn-secondary">Logout</a>
</div>
</div>
</div>
<br>
<%
ArrayList<Note> al = (ArrayList<Note>)session.getAttribute("al");
if(al!=null){
	for(Note n:al){
	
%>
<div class="container w-75 border border-info rounded-3">
	
	<h4><%=n.getNote() %></h4>
		<p>Add date :-<%=n.getAddDate() %></p>
		<p>Edit date :-<%=n.getEditDate() %></p>
	<div class="position-relative">	
		<form action="updateNote">
			<input type="hidden" name="userid" value="<%=check%>">
			<input type="hidden" name="sNote" value="<%=n.getNote()%>">
			<button class="btn btn-info btn-sm">Update</button>
		</form>	
		<div class="position-absolute bottom-0 end-0">
			<form action="deleteNote">
				<input type="hidden" name="userid" value="<%=check%>">
				<input type="hidden" name="note" value="<%=n.getNote()%>">
				<button class="btn btn-danger btn-sm">Delete</button>
			</form>
		</div>
	</div>
</div>
<br>
<%} }%>
<%
}
else{
	response.sendRedirect("home.jsp");
}
%>
</body>
</html>
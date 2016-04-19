<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	//get table from servlet
    String table = (String) request.getAttribute("table");
%>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Members</title>
</head>
<body>
	<!-- temporary nav links that will totally not be here in the final build -->
	<a href="myProfile.jsp">My Profile</a>
	<br />
	<a href="editMembers.jsp">Edit Members</a>
	<br />
	<a href="reports.jsp">Reports [don't click because it makes the server sad]</a>
	<br />

	<br />
	<a href="addForm">Add a new member</a>
	<br />
	<!-- Table to display all existing members and update/delete -->
	<%= table	%>
	
</body>
</html>
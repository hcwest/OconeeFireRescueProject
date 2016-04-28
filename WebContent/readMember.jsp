<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@ page import="controllers.ReadPersonServlet" %>
 <%
 	String personTable = (String) request.getAttribute("personTable");
 	//String test = (String) request.getAttribute("test");
 %> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Member List</title>
</head>
<body>

	<br/>
	<br/>
	<a href="home.jsp">Home</a>
	<br/>
	<br/>
	<a href="memberInfo.jsp">Member Info</a>
	<br/>
	<br/>
	<a href="reports.jsp">Reports</a>
	<br />
	<br />

<h1>Member List</h1>
<form name=blahblahtest action=readPerson method=get >
	<input type=submit name=submit value="make shit happen" />
</form>
<%= personTable %>

<br />
<a href="addMember.jsp">Add a Member</a>

</body>
</html>
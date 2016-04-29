<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dbHelpers.*" %>
<%
  
	ReadQuery rq = new ReadQuery("ocfr", "root", "password");
	rq.doListMembers();
	String memberList = rq.getMemberList();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> lists members by station and radio number, and shows email addresses. This report shall be able to be exported to a CSV file</title>
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
	<h1>Members</h1>
	<div>
	
    
	<%= memberList %>
	</div>
	
	<a href=blahblah>Export to .csv file</a>
	
	
</body>
</html>
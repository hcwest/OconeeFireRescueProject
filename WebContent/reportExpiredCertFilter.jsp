<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dbHelpers.*" %>
<%

	String expiredCertsFilter = (String) request.getAttribute("expiredCertsFilter");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> lists people with expired certifications</title>
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
	
	<h1>Members with Expired Certifications</h1>
<p>Filter by Certification Name</p>
<form name=whatever action=reportExpiredCertFilter method=post>
	<input type=text name=certificationName value="">
	<input type=submit name=sumbit value="submit">
</form>
<%= expiredCertsFilter %>

<form name=blah action="reportExpiredCert.jsp" method=post>
	<input type=submit name=submit value="Reset">
</form>

</body>
</html>
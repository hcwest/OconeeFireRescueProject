<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.Certifications" %>
<% Certifications certification = (Certifications) request.getAttribute("certification"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Certification</title>
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

	<h1>Update Certifications</h1>
	<br />
	<br />

<form name=updateForm action=updateCert method=get >	
	<label> Certification Name: </label>
	<input type=text name=certificationName value="<%= certification.getCertificationName() %>" />
	<br />
	<label> Expiration Period </label>
	<input type=text name=expirationPeriod value="<%= certification.getExpirationPeriod() %>" />
	<br />
	<label> Certifying Agency: </label>
	<input type=text name=certifyingAgency value="<%= certification.getCertifyingAgency() %>" />
	<br />
	<input type=submit name=submit value="Update the Certification" />
</form>
</body>
</html>
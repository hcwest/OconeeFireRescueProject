<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="model.PersonCertifications" %>
<% PersonCertifications personCertification = (PersonCertifications) request.getAttribute("personCertification"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Person Has Certifications</title>
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

	<h1>Update A Person's Certifications</h1>
	</br>
	<form name=updateForm action=updatePersonHasCert method=get >	
	<label> Radio Number: </label>
	<input type=text name=radioNumber value="<%= personCertification.getRadioNumber() %>" />
	<br />
	<label> Certification Name: </label>
	<input type=text name=certificationName value="<%= personCertification.getCertificationName() %>" />
	<br />
	<label> Expired?: </label>
	<input type=text name=isExpired value="<%= personCertification.getIsExpired() %>" />
	<br />
	<label> Earned Date: </label>
	<input type=text name=earnedDate value="<%= personCertification.getEarnedDate() %>" />
	<br />
	<label> Renewal Date: </label>
	<input type=text name=renewalDate value="<%= personCertification.getRenewalDate() %>" />
	<br />
	<input type=submit name=submit value="Update the PersonHasCertification" />
</form>
</body>
</html>
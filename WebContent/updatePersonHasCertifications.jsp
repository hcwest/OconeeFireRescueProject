<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="model.PersonCertifications" %>
<% PersonCertifications personCertification = (PersonCertifications) request.getAttribute("personCertification"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="mainStyle.css"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Update Person Has Certifications</title>
</head>
<body>

	<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="home.jsp">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="memberInfo.jsp">Member Info<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="readMember.jsp">Edit Member Info</a></li>
        <li><a href="readCertifications.jsp">Edit Certification Info</a></li>
        <li><a href="readPersonHasCertification.jsp">Member has Earned or Lost Cert</a></li>                        
      </ul>
    </li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="reports.jsp">Reports<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="reportExpiredCert.jsp">People with expired certifications</a></li>
        <li><a href="reportListMembers.jsp">List members by station and radio number, and show email addresses</a></li>                       
      </ul>
    </li>
  </ul>
</div>

	<h1>Update A Person's Certifications</h1>
	</br>
	<form name=updateForm action=updatePersonHasCert method=get >	
	<label> Radio Number: </label>
	<input type=text name=radioNumber value="<%= personCertification.getRadioNumber() %>" />
	<br />
	<label> ID: </label>
	<input type=text name=id value="<%= personCertification.getid() %>" />
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

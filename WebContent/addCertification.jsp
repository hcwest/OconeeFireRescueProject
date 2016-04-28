<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new certification</title>
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
	
	<form name=addForm action=addCertification method=get>
		<h2>New Certification Information:</h2>
		<br /> Certification Name: <input type=text name="certificationName" value="" />
		<br /> Expiration Period: <input type=text name="expirationPeriod" value="" />
		<br /> Certifying Agency: <input type=text name="certifyingAgency" value="" />
		
		<input type=submit name=submit value="Add the Certification" />
	</form>
	
</body>
</html>
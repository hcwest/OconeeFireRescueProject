<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new certification</title>
</head>
<body>
	<!-- temporary nav links that will totally not be here in the final build -->
	<a href="myProfile.jsp">My Profile</a>
	<br />
	<a href="editMembers.jsp">Edit Members</a>
	<br />
	<a href="reports.jsp">Reports [don't click because it makes the server sad]</a>
	<br />
	
	
	<form name=addForm action=addMemberCertification method=get>
		<h2>New Member Certification Information:</h2>
		<br /> Radio Number: <input type=text name="radioNumber" value="" />
		<br /> Certification Name: <input type=text name="certificationName" value="" />
		<br /> Is Expired: <input type=text name="isExpired" value="" />
		<br /> Earned Date: <input type=text name="earnedDate" value="" />
		<br /> Renewed Date: <input type=text name="renewedDate" value="" />
		
		
		<input type=submit name=submit value="Add the Member's Certification" />
	</form>
	
</body>
</html>
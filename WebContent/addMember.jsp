<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new member</title>
</head>
<body>
	<!-- temporary nav links that will totally not be here in the final build -->
	<a href="myProfile.jsp">My Profile</a>
	<br />
	<a href="editMembers.jsp">Edit Members</a>
	<br />
	<a href="reports.jsp">Reports [don't click because it makes the server sad]</a>
	<br />
	
	
	<form name=addForm action=addMember method=get>
		<h2>New Member Information:</h2>
		<br /> Radio Number: <input type=text name="radioNumber" value="" />
		<br /> First Name: <input type=text name="personFirstName" value="" />
		<br /> Last Name: <input type=text name="personLastName" value="" />
		<br /> Position: <input type=text name="position" value="" /> <br />
		Gender: <input type=text name="gender" value="" /> <br /> Date of
		Birth: <input type=text name="dateOfBirth" value="" /> <br />
		Address: <input type=text name="address" value="" /> <br /> Work
		Work Phone: <input type=text name="workPhone" value="" /> <br /> Mobile
		Mobile Phone: <input type=text name="mobilePhone" value="" /> <br />
		Station Number: <input type=text name="stationNumber" value="" /> <br />
		Active: <input type=text name="isActive" value=""/> (true or false)<br />
		<input type=submit name=submit value="Add the Member" />
	</form>
	
</body>
</html>
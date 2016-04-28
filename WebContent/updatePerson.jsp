<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.Person" %>
<% Person person = (Person) request.getAttribute("person"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Person</title>
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

	<h1>Update Person</h1>
	<br />
	<br />

<form name=updateForm action=updatePerson method=get >	
	<label> Radio Number: </label>
	<input type=text name=radioNumber value="<%= person.getRadioNumber() %>" />
	<br />
	<label> First Name: </label>
	<input type=text name=firstName
		value="<%= person.getFirstName() %>" />
	<br />
	<label> Last Name: </label>
	<input type=text name=lastName value="<%= person.getLastName() %>" />
	<br />
	<label> Position: </label>
	<input type=text name=position value="<%= person.getPosition() %>" />
	<br />
	<label> Gender: </label>
	<input type=text name=gender value="<%= person.getGender() %>" />
	<br />
	<label> Date of Birth: </label>
	<input type=text name=dateOfBirth value="<%= person.getDateOfBirth() %>" />
	<br />
	<label> Address: </label>
	<input type=text name=address value="<%= person.getAddress() %>" />
	<br />
	<label> Work Phone: </label>
	<input type=text name=workPhone value="<%= person.getWorkPhone() %>" />
	<br />
	<label> Mobile Phone: </label>
	<input type=text name=mobilePhone value="<%= person.getMobilePhone() %>" />
	<br />
	<label> Station Number: </label>
	<input type=text name=stationNumber value="<%= person.getStationNumber() %>" />
	<br />
	<label> Active? </label>
	<input type=text name=isActive value="<%= person.getActive() %>" />
	<br />
	<label> Email: </label>
	<input type=text name=email value="<%= person.getEmail() %>" />
	<br />
	<input type=submit name=submit value="Update the Person" />
</form>
</body>
</html>
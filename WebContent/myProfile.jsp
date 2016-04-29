<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Oconee Fire Rescue Portal - My Profile</title>
</head>
<body>
	<h1>Oconee Fire Rescue Portal - My Profile</h1>
	<h3>Welcome, ${user.username}!</h3>
	<h3>You have successfully logged in, congratulations.</h3>

	<form method="get" action="/myprofile">
    	<button type="submit">My Profile</button>
	</form>
	<form method="get" action="/editMembers">
    	<button type="submit">Edit</button>
	</form>
	<form method="get" action="/reports">
    	<button type="submit">Reports</button>
	</form>
	
	<!-- temporary nav links that will totally not be here in the final build -->
	<a href="myProfile.jsp">My Profile</a>
	<br />
	<a href="readMember.jsp">Members</a>
	<br />
	<a href="reports.jsp">Reports [don't click because it makes the server sad]</a>
	<br />
	
	<!--  Basic Info table -->
	<h2>Basic Info</h2>
	<br />
	Radio Number:
	<br />
	First Name:
	<br />
	Last Name:
	<br />
	Position:
	<br />
	Gender:
	<br />
	Date of Birth:
	<br /> 
	Address:
	<br />
	Work Phone:
	<br />
	Mobile Phone:
	<br />
	Station Number:
	<br />
	Email:
	<br />
		
	<!--  Certifications table -->	
	<h2>Certifications</h2>
	<br />
	Date Completed: 
	<br />
	Expiration Date: 
	<br/>
	<br/>
	<p>Click <a href="Login?logout=true">here</a> to log back out.</p>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="newUser">
		
		<form name=newUserForm action=addUser method=get>
		<h2>Create User Account:</h2>
		<br /> Email: <input type=text name="email" value="" />
		<br /> Password: <input type=text name="password" value="" />
		
		
		<input type=submit name=submit value="Create Account" />
	</form>

</body>
</html>
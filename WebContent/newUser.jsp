<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
<title>Insert title here</title>
</head>
<body>

<div class="newUser">

	<div class="login-header">
		<h1>Create New User</h1>
	</div>
		<div class="login-form">
		<form name=newUserForm action=addUser method=get>
		
		<h3>Username</h3>
		<br />
		<input type="text" name="email" placeholder="email" required><br>
		<br />
		<h3>Password</h3>
		<br />
		<input type="password" name="password" placeholder ="password" required><br>
		<br />

		<input type=submit name=submit value="Create Account" />
	</form>
	</div>

</body>
</html>
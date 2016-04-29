<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
<title>Oconee Fire Rescue Portal</title>
</head>
<body>
<div class="login">
	
	<div class="login-header">
		<h1>Oconee Fire Rescue Portal</h1>
	</div>
	
	<div class="login-form">
		<form name=loginForm action="login" method=post >
	
		<h3>Username</h3>
		<br />
		<input type="text" name="email" placeholder="email" required><br>
		<br />
		<h3>Password</h3>
		<br />
		<input type="password" name="password" placeholder ="password" required><br>
		<br />
		
		<input type="submit" name="btn_Login" value="login">
		
		<a href="newUser.jsp">CreateNewUser</a>
		login
		</form>
	</div>
</div>
</body>
</html>

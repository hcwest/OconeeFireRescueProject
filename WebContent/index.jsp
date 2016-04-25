<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Oconee Fire Rescue Portal</title>
</head>
<body>
	<h1>Oconee Fire Rescue Portal</h1>
	
	<img src="https://scontent-atl3-1.xx.fbcdn.net/hphotos-xfp1/v/t1.0-9/10486466_288435341342261_4579019031222629554_n.jpg?oh=eb949ac5c8427ffcb5fbf0826047abeb&oe=57AE41A8">
	<br />
	<form name=loginForm action=login method=post >
	
	Username
	<br />
	<input type="text" name="email" placeholder="Email" required><br>
	<br />
	Password
	<br />
	<input type="password" name="password" placeholder ="Password" required><br>
	<br />
	<a href="" >Create An Account</a>
	<a href="" >Forgot My Password</a>
	<br />
	<input type=submit name "btn_Login" value="Login">
	${errorMessage}
	</form>
	
</body>
</html>

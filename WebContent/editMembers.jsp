<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="model.*" %>   
    
<% Person person = (Person) request.getAttribute("person"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="mainStyle.css"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Edit Members</title>
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

<form name=editMembers action=UpdatePersonFormServlet method=get >


	<label>
      Radio Number:
   </label>
   <input type=text name=radioNumber value="<%= person.getRadioNumber() %>" />
   <br />
   
    <label>
      First Name:
   </label>
   <input type=text name=firstName value="<%= person.getFirstName() %>" />
   <br />

   <label>
      Last Name:
   </label>
   <input type=text name=lastName value="<%= person.getLastName() %>" />
   <br />
   <label>
      Position:
   </label>
   <input type=text name=position value="<%= person.getPosition() %>" />
   <br />
   <label>
      Gender:
   </label>
   <input type=text name=gender value="<%= person.getGender() %>" />
   <br />
    <label>
      Date of Birth:
   </label>
   <input type=text name=dateOfBirth value="<%= person.getDateOfBirth() %>" />
   <br />
   <label>
      Address:
   </label>
   <input type=text name=address value="<%= person.getAddress() %>" />
   <br />
   <label>
      Work Phone:
   </label>
   <input type=text name=workPhone value="<%= person.getWorkPhone() %>" />
   <br />
   <label>
      Mobile Phone:
   </label>
   <input type=text name=mobilePhone value="<%= person.getMobilePhone() %>" />
   <br />
   <label>
      Station Number:
   </label>
   <input type=text name=stationNumber value="<%= person.getStationNumber() %>" />
   <br />
   <label>
      Active:
   </label>
   <input type=text name=isActive value="<%= person.getActive() %>" />
   <br />
   
   <input type=submit name=submit value="Update the Member" />

</form>
	
</body>
</html>
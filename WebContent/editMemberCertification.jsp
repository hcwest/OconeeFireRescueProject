<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.*" %>   
    
<% PersonCertifications personCertification = (PersonCertifications) request.getAttribute("personCertification"); %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Certification</title>
</head>
<body>
	<!-- temporary nav links that will totally not be here in the final build -->
	<a href="myProfile.jsp">My Profile</a>
	<br />
	<a href="editMembers.jsp">Edit Members</a>
	<br />
	<a href="reports.jsp">Reports [don't click because it makes the server sad]</a>
	<br />

<form name=editMemberCertification action=editMemberCertification method=get >


	<label>
      Radio Number:
   </label>
   <input type=text name=radioNumber value="<%= personCertification.getRadioNumber() %>" />
   <br />
   
    <label>
      Certification Name:
   </label>
   <input type=text name=certificationName value="<%= personCertification.getCertificationName() %>" />
   <br />

   <label>
      Is Expired:
   </label>
   <input type=text name=isExpired value="<%= personCertification.getIsExpired() %>" />
   <br />
   
   <label>
      Earned Date:
   </label>
   <input type=text name=earnedDate value="<%= personCertification.getEarnedDate() %>" />
   <br />
   
   <label>
      Renewed Date:
   </label>
   <input type=text name=renewalDate value="<%= personCertification.getRenewalDate() %>" />
   <br />

   
   <input type=submit name=submit value="Update the Member's Certification" />

</form>
	
</body>
</html>
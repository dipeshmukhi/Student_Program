<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">	
		
<html>

<head>
<title>Register Form</title>
</head>
<body>

	<center>
	<h2>Student Register</h2>
	<h4>${sessionScope.returnMessage}</h4>
	<c:set var="returnMessage" value="" scope="session"></c:set>
	<form action="Register" method="post" id="RegisterForm">
	
		<h4>First Name*: <input type="text" name="txtFirstName" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
		<h4>Last Name*: <input type="text" name="txtLastName" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
		<h4>Email Id*: <input type="text" name="txtEmailId" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
		<h4>Phone: <input type="text" name="txtPhone" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
	
		<h4>User Name*: <input type="text" name="txtUserName" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
		<h4>Password*: <input type="password" name="txtPassword" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
		<h4>Re-confirm Password*: <input type="password" name="txtRePassword" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
		
		<button type="button" onclick="validate(this.form)">Submit</button>
		<button type="reset">Reset</button>
	</form>

</body>

<script type="text/javascript">
	function validate(form)
	{
		if(form.txtFirstName.value == "" || form.txtLastName.value == "" || form.txtEmailId.value == "" || form.txtUserName.value == "" || form.txtPassword.value == "")
		{
			alert("Please fill in all the required details");
			form.txtUserName.focus();
		}		
		else if(form.txtPassword.value != form.txtRePassword.value)
		{
			alert("Re-confirmed password does not match");
			form.txtPassword="";
			form.txtRePassword="";
			form.txtPassword.focus();
		}
		else
		{
			form.submit();
		}
	}
</script>

</html>
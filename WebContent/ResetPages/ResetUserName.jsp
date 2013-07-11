<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Reset" method="post" id="ResetForm">
		<h4>Registered Email: <input type="text" name="txtEmailId" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
		<button type="button" onclick="validate(this.form)">Submit</button>
	</form>		
</body>

<script type="text/javascript">
	function validate(form)
	{
		if(form.txtEmailId.value=="")
		{
			alert("Please provide your registered Email Id.");
			form.txtEmailId.focus();
		}		
		else
		{
			form.submit();
		}
	}
</script>

</html>
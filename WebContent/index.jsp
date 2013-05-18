<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-in Page</title>
</head>
<body>

	<c:if test="${sessionScope.currentUser!=null}">
		<c:choose>
			<c:when test="${fn:toLowerCase(sessionScope.currentUser.lType)==\"student\"}">
		       <c:redirect url="http://localhost:8090/Student_Program/Student/StudentMainPage.jsp"></c:redirect>
		   </c:when>
		   <c:when test="${fn:toLowerCase(sessionScope.currentUser.lType)==\"professor\"}">
		       <jsp:forward page="<%=response.encodeURL(\"/temp.jsp\")%>"></jsp:forward>
		   </c:when>
		   <c:otherwise>
		   </c:otherwise>
		</c:choose>
	</c:if>
	
	${sessionScope.currentUser.lType}
	
	<center>
	<h4>${sessionScope.returnMessage}</h4>
	<c:set var="returnMessage" value="" scope="session"></c:set>
	<h2>Student Login</h2>
	<form action="CheckLogin" method="post" id="login_form">
		<h4>User Name: <input type="text" name="txtUserName" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
		<h4>Password: <input type="password" name="txtPassword" value="" onkeydown="if (event.keyCode == 13) {validate(this.form);}"></h4>
		<button type="button" onclick="validate(this.form)">Submit</button>
	</form>
	<form action="Register.jsp" id=register_form>
		<button type="submit">Register</button>
	</form>
	<br>
		<a href="<%=response.encodeURL("ResetPages/ResetUserName.jsp")%>">Forgot UserName ?</a>
		<a href="<%=response.encodeURL("ResetPages/ResetPassword.jsp")%>">Forgot Password ?</a>	
	</center>
	
	<jsp:include page="/includes/footer.jsp" flush="true"/>
</body>

<script type="text/javascript">
	function validate(form)
	{
		if(form.txtUserName.value=="" && form.txtPassword.value=="")
		{
			alert("Please fill in your UserName and Password");
			form.txtUserName.focus();
		}		
		else if(form.txtUserName.value=="")
		{
			alert("Please fill in your UserName");
			form.txtUserName.focus();
		}
		else if (form.txtPassword.value=="")
		{
			alert("Please fill in your Password");
			form.txtPassword.focus();
		}
		else
		{
			form.submit();
		}
	}
</script>

</html>
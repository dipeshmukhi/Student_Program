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

	<sql:setDataSource var="myData" driver="com.mysql.jdbc.Driver"
						    url="jdbc:mysql://localhost:3306/Dipesh"
						    user="root"  password="Dip_mukh99"
						    scope="session"/>
						    
	<sql:query dataSource="${myData}" var="result">
		SELECT * FROM dipesh.user_details
	</sql:query>
	
	<%=session.getAttribute("myData").getClass().getName() %>
	
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>User Name</th>
			<th>Password</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone</th>
		</tr>	
	<c:forEach var="row" items="${result.rows}">
		<tr>
		<td><c:out value="${row.id}"/></td>
		<td><c:out value="${row.User_Name}"/></td>
		<td><c:out value="${row.Password}"/></td>
		<td><c:out value="${row[\"First Name\"]}"/></td>
		<td><c:out value="${row[\"Last Name\"]}"/></td>
		<td><c:out value="${row.Email}"/></td>
		<td><c:out value="${row.Phone}"/></td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>
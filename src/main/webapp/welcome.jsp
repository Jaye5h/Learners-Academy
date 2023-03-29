<%@page import="org.simplilearn.hrmapp.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		User user=(User)session.getAttribute("user");
	%>
	<h1>Welcome, <%=user.getUsername()%></h1>
	<div>
		<a href="addSubject.jsp">Add Subject</a>
		||<a href="addClass.jsp">Add Class</a>
		||<a href="addStudent.jsp">Add Student</a>
		||<a href="addTeacher.jsp">Add Teacher</a>
	</div>
	<div>
		
	</div>
</body>
</html>
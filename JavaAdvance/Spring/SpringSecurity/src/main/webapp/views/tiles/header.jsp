<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h2 style="color: red;">HEADER</h2>
	<sec:authentication property="name"/>
	<sec:authentication property="authorities"/>
	<a href="logout">LogOut</a>
</body>
</html>
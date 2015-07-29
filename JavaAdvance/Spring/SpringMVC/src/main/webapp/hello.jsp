<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Hello world</title>

<link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />'
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src='<jstl:url value="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" />'></script>

</head>
<body>
	<h1>Hello, world!</h1>
	<a href="showAll">Show</a>
</body>
</html>
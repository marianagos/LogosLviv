<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>New Book</title>

<link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />'
	rel="stylesheet">
<link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" />'
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src='<jstl:url value="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" />'></script>

</head>
<body>

	<div style="padding:30px;">
		<p> Create New Book </p>
		<form action="newBook" method="POST">
			Title
			<input type="text" name="title"/>
			
			<br>
			Author
			<select name="authorId">
				<jstl:forEach items="${authors}" var="author">
					<option value="${author.getId()}">${author.getName()}</option>
				</jstl:forEach>
			</select>
			<br>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
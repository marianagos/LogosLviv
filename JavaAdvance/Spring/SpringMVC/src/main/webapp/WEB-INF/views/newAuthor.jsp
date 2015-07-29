<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>New Author</title>

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
		<p> Create New Author </p>
		<form role="form" style="width: 300px" action="showAll" method="POST">
			<div class="form-group">
				<label for="email">Name:</label> <input type="email" name="name"
					class="form-control" id="name">
			</div>
			<div class="form-group">
				<label for="pwd">Age:</label> <input type="text" name="age"
					class="form-control" id="age">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>
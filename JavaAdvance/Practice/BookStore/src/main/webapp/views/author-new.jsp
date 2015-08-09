<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div style="padding: 30px;">
	<p>Create New Author</p>
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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody>
		<jstl:forEach items="${authors}" var="author">
			<tr>
				<td>${author.name}</td>
				<td>${author.age}</td>
			</tr>
		</jstl:forEach>
	</tbody>
</table>
<a href="createAuthor">Create Author</a>

<%@ page import="java.util.List"%>

<html>
<body>
	<h2>Hello World!</h2>

	<%
		List<String> list = (List<String>) request.getAttribute("heroes");
		pageContext.setAttribute("heroes", list);
	%>

	<%=list.size()%>
	<%=list.get(0)%>

</body>
</html>

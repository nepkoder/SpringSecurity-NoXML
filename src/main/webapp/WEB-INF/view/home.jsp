<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Home Page</title>
</head>

<body>
	<br>
	<h2>Home Page</h2>
	<hr>

	Welcome to the home page!
	<hr>
	<h3>
		User:
		<sec:authentication property="principal.username" />
	</h3>
	<h3>
		Roles:
		<sec:authentication property="principal.authorities" />
	</h3>

	<hr>
	

		<p>
			<a href="${pageContext.request.contextPath}/manager">This link is
				only for manager (only manager access)</a>
		</p>

	<h3>
		<a href="${pageContext.request.contextPath}/admin">Admin page link
			(only admin access)</a>
	</h3>
	<br>
	<br>
	<c:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout">

	</c:form>


</body>

</html>
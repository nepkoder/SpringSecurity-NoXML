<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page</h2>
	<hr>

	Welcome to the home page!
	<hr>
	<h3>
		User:
		<sec:authentication property="principal.username" />
	</h3>
	<br>
	<h3>
		Roles:
		<sec:authentication property="principal.authorities" />
	</h3>

	<br>
	<br>
	<c:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout">

	</c:form>


</body>

</html>
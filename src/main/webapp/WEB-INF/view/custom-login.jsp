<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="header.jsp"></jsp:include>

<title>Login Details</title>
</head>
<body>

	<div class="jumbotron">
		<form:form action="${pageContext.request.contextPath}/login"
			method="POST">
			<h1>System Login</h1>
			<div class="login-area">
				<p>Please provide your details</p>

				<!-- username field -->
				<div class="field">
					<label for="username">Username</label> <input type="text"
						 name="username" placeholder="Username"
						class="form-control username-field">
				</div>

				<!--  password field -->
				<div class="field">
					<label for="password">Password</label> <input type="password"
						 name="password" placeholder="Password"
						class="form-control password-field">
				</div>

			</div>

			<!-- end of content of login section here -->
			<div class="form-actions">
				<p class="reset-option">
					<a href="#">Forget your password ??</a>
				</p>
				<input type="submit" class="btn btn-primary btn-login" value="Login"/>
			</div>
		</form:form>
	</div>
	<div class="below-login">
		<p>
			Don't have account?<a href="#">Register </a>
		</p>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorHandler.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<h1>Log In</h1>
	<div class="wrapper">


		<form method="post" action="ValidateLogIn">

			<table cellspacing='20'>

				<tr>
					<td>User Name :</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan='2'><input type="submit" name="submit"
						class="submit" value="LogIn" /></td>
				</tr>
			</table>
		</form>
		<%
			if (request.getParameter("message") != null) {
		%>
		<p class="message"><%=request.getParameter("message")%></p>
		<%
			}
		%>
		<p>
			<a href="register.jsp">Register Here</a>
		</p>

	</div>
</body>
</html>
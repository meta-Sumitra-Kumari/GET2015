<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>	
	<head>
		<title>The Login Page</title>
		<meta charset="utf-8">
		<link href="css/stylelog.css" rel='stylesheet' type='text/css' />
		<meta charset="utf-8">
			
	</head>
	<body>
		<div class="login-form">
			<div class="head">
				<img src="images/mem2.jpg" alt=""/>
			</div>
			<form action="validate" method="post">
				<li>
					<input type="text" class="text" name="username" value="USERNAME" id="username" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'USERNAME';}" ><a href="#" class=" icon user"></a>
				</li>
				<li>
					<input type="password" value="Password" name="password" id="passwrd" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Password';}"><a href="#" class=" icon lock"></a>
				</li>
				<div class="p-container">
					<input type="submit"  value="SIGN IN" >
				</div>
				
			</form>
			<%
							if (request.getParameter("message") != null) {
						%>
						<p class="message"><%=request.getParameter("message")%></p>
						<%
							}
						%>
			
				
		</div>
</body>
</html>
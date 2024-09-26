<%@page
	import="com.metacube.cardekho.databaseconfiguration.ConnectionFactory"%>
<%@page import="com.metacube.cardekho.db.helper.CarPortalDao"%>
<%@page import="com.metacube.cardekho.model.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Car Details</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styleLogin.css">


</head>
<body>
	<header> <br />
	<span id="logo">Car Portal</span> <%
 	if (session.getAttribute("username") != null) {
 %>
	<div id="user">
		<%=session.getAttribute("username")%>&nbsp;&nbsp;<a href="Home.jsp">
			Logout!!</a>
	</div>
	<%
		}
	%> </header>
	<nav> <%
 	if (session.getAttribute("username") != null) {
 %> <a href="admin">Home</a> <%
 	} else {
 %> <a href="Login.jsp">Login</a> <%
 	}
 %> <span class="space"><a href="#">About Us</a></span> <span
		class="space"><a href="#">Contact Us</a></span> </nav>
	<div class="link">
		<span class="space"> <a href="addCar.jsp">Add New Car</a></span><br />
		<span class="space"> <a href="searchCar.jsp">Search Car</a></span><br />
		<span class="space"> <a href="EditCar.jsp">Update Car
				Details</a></span><br />
	</div>
	<div class="content">
		<h1>Edit Car Details</h1>
		<%
			if (request.getParameter("message") != null) {
		%>
		<p class="message"><%=request.getParameter("message")%></p>
		<%
			}
		%>
		<br />

		<%
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null) {
				connection = new ConnectionFactory().createConnection();
				new CarPortalDao(connection);
			}
			List<String> makeList = CarPortalDao
					.selectListOfMakeOfCar(connection);
		%>

		<div class="details">
			<form class="formclass" action='#' method="get">
				<select name='make'>
					<%
						if (request.getParameter("make") != null) {
					%>
					<option><%=request.getParameter("make")%></option>
					<%
						} else {
					%>
					<option>-Select Company-</option>

					<%
						}
						for (String str : makeList) {
					%>
					<option><%=str%></option>
					<%
						}
					%>
				</select> <input type='submit' value='get model'>
			</form>
			<br />
			<form class="formclass" action="editcar" method="post">

				<input type="hidden" name="make"
					value="<%=request.getParameter("make")%>"> <span
					class="space"> <%
 	if (request.getParameter("make") != null) {
 		List<String> modelList = CarPortalDao
 				.selectListOfModelOfCarBasedOnMake(connection,
 						(String) request.getParameter("make"));
 %> <select name='model'>
						<option>-select company first-</option>
						<%
							for (String str : modelList) {
						%>
						<option><%=str%></option>
						<%
							}
						%>
				</select> <%
 	} else {
 %> <select name='model'>
						<option>-select company first-</option>
				</select> <%
 	}
 %> <br /> <br /> <br /> 
 <input type="text" name="engineInCC"  placeholder="EngineInCC" pattern="^[0-9]+(.[0-9]{1,2})?$"> <br />
 <input type="text" name="fuelCapacity"  placeholder="Fuel Capacity" pattern="^[0-9]+(.[0-9]{1,2})?$"> <br />
 <input type="text" name="milage"  placeholder="Milage" pattern="^[0-9]+(.[0-9]{1,2})?$"> <br /> 
 <input	type="text" name="price"  placeholder="Price" pattern="^[0-9]+(.[0-9]{1,2})?$">
				</span>
				<div class="submit-design">
					<span class="space"> <input type="submit" name="Submit"
						value="Edit Car Detail">
					</span>
				</div>

			</form>
		</div>
	</div>
</body>
</html>

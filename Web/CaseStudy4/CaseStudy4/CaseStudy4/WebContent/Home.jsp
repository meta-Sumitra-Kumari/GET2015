<%@page import="com.metacube.cardekho.databaseconfiguration.ConnectionFactory"%>
<%@page import="com.metacube.cardekho.db.helper.CarPortalDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.*"%>
<%@page session="false"%>
<%
HttpSession session = request.getSession();
session.setAttribute("username",null);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<head>
		<title>CarPortal</title>
		<meta charset="utf-8">
		<link href="css/styleMain.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="container">
			<div id="top">
				Welcome to the amazing world of Cars...
			</div>
			<div id="header">
					<h1 class="header2">CAR Portal</h1>
				</div>
			<div id="navigation">
					<div id="invertedtabsline">&nbsp;</div>
					<div id="invertedtabs">
						<ul>
							<li style="margin-left: 1px"><a href="#"><span>Home</span></a></li>
							<li><a href="Login.jsp"><span>Login</span></a></li>
							<li><a href="#"><span>About</span></a></li>
							<li><a href="searchCar.jsp"><span>Car Search</span></a></li>
						</ul>
					</div>
						<br style="clear: left" />
			</div>
			<div id="content">
				<p>
				Let's explore the world of amazing car.<br />Just on one click search
				your dream car and book now on lowest prices.
				</p>
				<h2 class="header2">Search Car</h2>
				<br>
				<form action="searchcar" method="post">
					<input type="checkbox" name="search" value="make">Search By Make 
					<input type="checkbox" name="search" value="price">Search By budget<br/><br/>
					<input type="submit" value="Search">
				</form>
			
			
				<%
					List<String> makeList = null;
					if (request.getAttribute("display") != null) {
				%> 
				<br />
				<br />
			
				<%=request.getAttribute("display")%> 
				<% }
			 	if (request.getParameter("make") != null) {
			 		Connection connection = ConnectionFactory.getConnection();
			 		if (connection == null) {
			 			connection = new ConnectionFactory().createConnection();
			 			new CarPortalDao(connection);
			 		}
			 		makeList = CarPortalDao.selectListOfMakeOfCar(connection);
			 		List<String> modelList = CarPortalDao
			 				.selectListOfModelOfCarBasedOnMake(connection,
			 						(String) request.getParameter("make"));
				%> 
				<br />
				<form action='#' method="post">
					<select name='make'><br/><br/>
						<option><%=request.getParameter("make")%></option>
						<%
							for (String str : makeList) {
						%>
						<option><%=str%></option>
						<%
							}
						%>
					</select><br/> 
					<input type='submit' value='Get Model'><br/><br/>
				</form>
				<br />
				<form action='display' method="post">
					<input type="hidden" name="make" value="<%=request.getParameter("make")%>">
					<select name='model'><br/><br/>
						<option>-Select Model-</option><br/><br/>
						<%
							for (String str : modelList) {
						%>
						<option><%=str%></option>
						<%
							}
						%>
					</select> <br /> 
					<input type='submit' value='View'>
				</form>
				<%
					}
				%> 
				<p>&nbsp;</p>
			</div>
			<div id="sidebar">
					<h2 class="header2">Search Your Car</h2>
					<img src="images/download (1).jpg" width="100%" height="100%"/>
					<p >Now Buy car from your home.SEARCH...SELECT...BUY...and DRIVEEEEE.....  </p>
					<p >&nbsp;</p>
				 </div>
            <div class="clear" id="footer">
					<div align="center">Copyright 2015 <a href="#">www.carcapture.com</a> - All rights reserved |</div>
				</div>
		</div>
	</body>
</html>


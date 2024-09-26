<%@page import="com.metacube.cardekho.model.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page session="false"%>

<%
	HttpSession session = request.getSession();
	session.setAttribute("username", request.getAttribute("username"));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CarPortal</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styleLogin.css">
</head>
<body>
	<header> <br />
	<span id="logo">Car Portal</span>
	<div id="user">
		<%=request.getAttribute("username")%>&nbsp;&nbsp;<a href="Home.jsp">
			Logout!!</a>
	</div>
	</header>
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


	<%
		if (request.getAttribute("carList") != null) {
			List<Car> carList = (List<Car>) request.getAttribute("carList");
			for (Car car : carList) {
	%>
	<div class="offer_list clearfix" id="offer_list">

		<div class="offer_item clearfix" id="0">

			<div class="offer_aside">
				<h2><%=car.getMake()%></h2>
				<div class="offer_descr">
					<p><%=car.getModel()%></p>
				</div>
				<div class="offer_data">
					<div class="offer_price">
						$<%=car.getPrice()%></div>
					<span class="offer_miliage"><%=car.getMilage()%> KMPL</span> <span
						class="offer_regist">$<%=car.getOnRoadPrice()%></span>
				</div>
			</div>
			<div class="offer_image">
				<img src="<%=car.getImage_path()%>" alt="">
			</div>
		</div>
	</div>

	<%
		}
		}
	%>
</body>
</html>
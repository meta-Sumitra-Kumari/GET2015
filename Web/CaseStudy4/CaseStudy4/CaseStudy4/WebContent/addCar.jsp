<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
	<span id="logo">Car Portal</span> <%
 	if (session.getAttribute("username") != null) {
 %>
	<div id="user">
		<%=session.getAttribute("username")%>&nbsp;&nbsp;<a href="Home.jsp"> Logout!!</a>
	</div>
	<%
		}
	%> </header>
	<nav>
	<%
		if (session.getAttribute("username") != null) {
	%> <a href="admin">Home</a> 
	<%
		}else{
	%>
	<a href="Login.jsp">Login</a> 
	<%
		}
	%>
	<span class="space"><a
		href="#">About Us</a></span> <span class="space"><a
		href="#">Contact Us</a></span> </nav>

<div class="link">
		<span class="space">
		<a href="addCar.jsp" >Add New Car</a></span><br /> 
		<span class="space">
		<a href="searchCar.jsp">Search Car</a></span><br />
		<span class="space">
		<a href="EditCar.jsp">Update Car Details</a></span><br />
	</div>
	<div class="content">
		<h2>Add New Car</h2>
		<br/>
		<%
						if (request.getParameter("message") != null) {
					%>
					<p class="message"><%=request.getParameter("message")%></p>
					<%
						}
					%>
		<div class="details">

			<form class="formclass" action="addcar" method="get">
				<span class="space">
					<input type="text" name="make" placeholder="Make" autofocus  pattern="[A-Z_a-z]{0,}"/><br/>
					<input type="text" name="model" value="" placeholder="Model" autofocus pattern="[A-Z_a-z]{1,}"/> <br/>
					<input type="text" name="engineInCC" placeholder="EngineInCC" autofocus pattern="^[0-9]+(.[0-9]{1,2})?$"/><br/>
					<input type="text" name="fuelCapacity" placeholder="Fuel Capacity" autofocus pattern="^[0-9]+(.[0-9]{1,2})?$"/><br/>
					<input type="text" name="milage" placeholder="Milage" autofocus pattern="^[0-9]+(.[0-9]{1,2})?$"/> <br/>
					<input type="text" name="price" placeholder="Price" autofocus pattern="^[0-9]+(.[0-9]{1,2})?$"/>	<br/>
					<input type="text" name="roadTax" placeholder="Road Tax" autofocus pattern="^[0-9]+(.[0-9]{1,2})?$"/>
					</span>
				<div class="submit-design">
					<span class="space">
						<button name="Submit">Confirm Details</button>
					</span>
				</div>
			</form>
		</div>
	</div>
</body>
</html>    [0-9]+(.[0-9]{0,})
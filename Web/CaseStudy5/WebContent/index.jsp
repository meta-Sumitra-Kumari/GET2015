<%@page import="com.metacube.cardekho.service.CarPortalService"%>
<%@page import="com.metacube.cardekho.db.helper.CarPortalDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Portal</title>
</head>
<body>
	<%
		CarPortalService service = new CarPortalService();
		//create storage fo cars
		service.createStorageForCar();

		RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
		rd.forward(request, response);
	%>
</body>
</html>
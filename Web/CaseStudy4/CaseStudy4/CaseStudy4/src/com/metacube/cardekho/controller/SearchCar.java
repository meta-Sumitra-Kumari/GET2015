package com.metacube.cardekho.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.metacube.cardekho.databaseconfiguration.ConnectionFactory;
import com.metacube.cardekho.db.helper.CarPortalDao;
import com.metacube.cardekho.exception.CarDekhoSystemException;

/**
 * @author Sumitra
 * --Servlet to search a car on user basis
 *
 */
@WebServlet("/searchcar")
public class SearchCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String display = "";
		// displaying via make and model search
		if (search.equals("make")) {
			try {
				Connection connection = ConnectionFactory.getConnection();
				if (connection == null) {
					connection = new ConnectionFactory().createConnection();
				}
				List<String> makeList = CarPortalDao
						.selectListOfMakeOfCar(connection);
				display += "<form action='searchCar.jsp' method='get'><select name='make'><option>-Select Company First-</option>";

				for (String str : makeList) {
					display += "<option>" + str + "</option>";
				}

				display += "</select><br/><input type='submit' value='Get Model'></form><br/>"
						+ "<form action='display' method='post'><select name='model'><option>-Select Car Model-</option></select>"
						+ "<br /><br/><input type='submit' value='View'></form><br/>";

				request.setAttribute("makeList", makeList);

			} catch (CarDekhoSystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// displaying via budget
			display += "<form action='display' method='post'>"
					+ "<select name='price'><option value='500000'>Below 5,00,000</option>"
					+ "<option value='1000000'>Below 10,00,000</option>"
					+ "<option value='2500000'>Below 25,00,000</option>"
					+ "<option value='5000000'>Below 50,00,000</option>"
					+ "<option value='8000000'>Below 80,00,000</option></select>"
					+ "<br/><br/><input type='submit' value='View'></form>";
		}

		request.setAttribute("display", display);
		RequestDispatcher rd = request.getRequestDispatcher("/searchCar.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter("search");
		String display = "";
		if (search.equals("make")) {
			try {
				Connection connection = ConnectionFactory.getConnection();
				if (connection == null) {
					connection = new ConnectionFactory().createConnection();
				}
				List<String> makeList = CarPortalDao
						.selectListOfMakeOfCar(connection);
				display += "<br/><form action='Home.jsp' method='get'><select name='make'><option>-Select Company First-</option>";

				for (String str : makeList) {
					display += "<option>" + str + "</option>";
				}

				display += "</select><br/><input type='submit' value='Get Model'></form><br/>"
						+ "<form action='display' method='post'><select name='model'><option>-Select Car Model-</option></select>"
						+ "<br /><input type='submit' value='View'></form><br/>";

				request.setAttribute("makeList", makeList);

			} catch (CarDekhoSystemException e) {

				e.printStackTrace();
			}
		} else {
			display += "<form action='display' method='post'>"

					+ "<select name='price'><option value='500000'>Below 5,00,000</option>"
					+ "<option value='1000000'>Below 10,00,000</option>"
					+ "<option value='2500000'>Below 25,00,000</option>"
					+ "<option value='5000000'>Below 50,00,000</option>"
					+ "<option value='8000000'>Below 80,00,000</option></select>"
					+ "<br/><br/><input type='submit' value='View'></form>";
		}

		request.setAttribute("display", display);

		RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
		rd.forward(request, response);

	}

}

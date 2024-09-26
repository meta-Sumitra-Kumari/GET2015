package com.metacube.cardekho.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.cardekho.databaseconfiguration.ConnectionFactory;
import com.metacube.cardekho.db.helper.CarPortalDao;
import com.metacube.cardekho.exception.CarDekhoSystemException;
import com.metacube.cardekho.model.Car;

/**
 * Servlet implementation class DisplaySearchedCar for displaying the cars
 */
/**
 * @author Sumitra
 *
 */
@WebServlet("/display")
public class DisplaySearchedCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Car> carList = null;
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			if (connection == null) {
				connection = new ConnectionFactory().createConnection();
				new CarPortalDao(connection);
			}

		} catch (CarDekhoSystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// checking for all parameters

		if (request.getParameter("make") != null
				&& request.getParameter("model").equalsIgnoreCase(
						"-Select Model-")) {
			carList = CarPortalDao.selectCarBasedOnMake(connection,
					request.getParameter("make"));

		} else

		if (request.getParameter("model") != null) {
			carList = CarPortalDao
					.selectCarBasedOnMakeAndModel(connection,
							request.getParameter("make"),
							request.getParameter("model"));
		}

		else if (Double.parseDouble(request.getParameter("price")) != 0.0) {
			carList = CarPortalDao.selectListOfCarBasedOnBudget(connection,
					Double.parseDouble(request.getParameter("price")));
		}

		request.setAttribute("carList", carList);
		RequestDispatcher rd = request.getRequestDispatcher("/searchCar.jsp");
		rd.forward(request, response);

	}
}

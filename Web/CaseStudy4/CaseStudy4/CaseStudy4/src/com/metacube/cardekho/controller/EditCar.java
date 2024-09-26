package com.metacube.cardekho.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
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
 * @author Sumitra
 * --Servlet for editing the car
 *
 */
@WebServlet("/editcar")
public class EditCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCar() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		double price = Double.parseDouble((String) request
				.getParameter("price"));
		HttpSession session = request.getSession(true);
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			if (connection == null) {
				connection = new ConnectionFactory().createConnection();
				new CarPortalDao(connection);
			}
		} catch (CarDekhoSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int flag = 0;
		String message = null;
		// checking parameters
		if (request.getParameter("make").equals(null)
				|| request.getParameter("make").equals("")) {
			flag = 1;
			message += "Make field Empty";
		} else if (request.getParameter("model").equals(null)
				|| request.getParameter("model").equals("")) {
			flag = 1;
			message += "Model field Empty";
		} else if (request.getParameter("engineInCC").equals(null)
				|| request.getParameter("engineInCC").equals("")) {
			flag = 1;
			message += "EngineInCC field Empty";
		} else if (request.getParameter("fuelCapacity").equals(null)
				|| request.getParameter("fuelCapacity").equals("")) {
			flag = 1;
			message += "FuelCapacity field Empty";
		} else if (request.getParameter("milage").equals(null)
				|| request.getParameter("milage").equals("")) {
			flag = 1;
			message += "Milage field Empty";
		} else if (request.getParameter("price").equals(null)
				|| request.getParameter("price").equals("")) {
			flag = 1;
			message += "Price field Empty";
		}

		if (flag == 1) {
			// redirecting the response to log in page
			response.sendRedirect("EditCar.jsp?message="
					+ URLEncoder.encode(message, "UTF-8"));
		} else {
			// update of car detail in table
			List<Car> car = CarPortalDao.selectCarBasedOnMakeAndModel(
					connection, (String) request.getParameter("make"),
					(String) request.getParameter("model"));

			car.get(0).setEngineInCC(
					Double.parseDouble((String) request
							.getParameter("engineInCC")));
			car.get(0).setFuelCapacity(
					Double.parseDouble((String) request
							.getParameter("fuelCapacity")));
			car.get(0)
					.setMilage(
							Double.parseDouble((String) request
									.getParameter("milage")));
			car.get(0).setPrice(price);
			car.get(0).setOnRoadPrice();
			int update = CarPortalDao.updateCarDetails(connection, car.get(0));

			if (update == -1) {
				request.setAttribute("message", "Car not inserted");

				RequestDispatcher rd = request
						.getRequestDispatcher("/EditCar.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("username",
						session.getAttribute("username"));
				RequestDispatcher rd = request.getRequestDispatcher("/admin");
				rd.forward(request, response);
			}
		}

	}

}

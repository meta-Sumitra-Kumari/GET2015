package com.metacube.cardekho.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.cardekho.model.Car;
import com.metacube.cardekho.service.CarPortalService;
import com.metacube.cardekho.service.Validation;

/**
 * @author Sumitra --Servlet for editing the car
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
		HttpSession session = request.getSession(true);
		CarPortalService service = new CarPortalService();
		// Validation on Car details
		String message = Validation.validationOnCarDetails(
				request.getParameter("make"), request.getParameter("model"),
				request.getParameter("engineInCC"),
				request.getParameter("fuelCapacity"),
				request.getParameter("milage"), request.getParameter("price"),
				"abc");

		if (message.charAt(0) == '1') {
			// redirecting the response to Edit page for showing error
			response.sendRedirect("editCar.jsp?message="
					+ URLEncoder.encode(message.substring(1), "UTF-8"));
		} else {
			// getting car detail in table for this make and model
			List<Car> car = service.getListOfSearchedCarBasedOnMakeAndModel(
					(String) request.getParameter("make"),
					(String) request.getParameter("model"));
			// setting updated value
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
			car.get(0).setPrice(
					Double.parseDouble((String) request.getParameter("price")));
			car.get(0).setOnRoadPrice();
			// updating car details
			int update = service.editDetailsOfCar(car.get(0));

			if (update == 1) {
				request.setAttribute("username",
						session.getAttribute("username"));
				RequestDispatcher rd = request.getRequestDispatcher("/admin");
				rd.forward(request, response);
			} else {
				response.sendRedirect("EditCar.jsp?message="
						+ URLEncoder.encode("Car not inserted", "UTF-8"));

			}
		}

	}
}
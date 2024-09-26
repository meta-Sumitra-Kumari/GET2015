package com.metacube.cardekho.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.cardekho.model.Car;
import com.metacube.cardekho.service.CarPortalService;

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
		CarPortalService service=new CarPortalService();
		//search by model and make
		if (request.getParameter("model") != null) {
			//getting carlist for this make and model
			carList = service.getListOfSearchedCarBasedOnMakeAndModel(
							request.getParameter("make"),
							request.getParameter("model"));
		}
		//search by price 
		else if (Double.parseDouble(request.getParameter("price")) != 0.0) {
			//getting car list for car lower than this budget
			carList = service.getListOfSearchedCarBasedOnBudget(Double.parseDouble(request.getParameter("price")));
		}
		//request forwarded to searchcar page to display list of cars
		request.setAttribute("carList", carList);
		RequestDispatcher rd = request.getRequestDispatcher("/searchCar.jsp");
		rd.forward(request, response);

	}
}

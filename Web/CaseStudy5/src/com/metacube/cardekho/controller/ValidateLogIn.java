package com.metacube.cardekho.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.cardekho.service.Validation;

/**
 * @author Sumitra
 *
 *         Servlet implementation of validation of login and then redirecting it
 *         to the admin page
 */

@WebServlet("/validate")
public class ValidateLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// getting values from request
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String message=Validation.validationOnLoginOfAdmin(username, password);

				if (message.charAt(0)=='1') {
					// redirecting the response to log in page
					response.sendRedirect("login.jsp?message="
							+ URLEncoder.encode(message.substring(1), "UTF-8"));
				} else {
					// checking if user is validate or not


			if (username.equals("sumitra") && password.equals("sumitra")) {
				// if user is validate then redirect to Home page
				request.setAttribute("username", username);// setting employee
															// in request
				RequestDispatcher rd = request.getRequestDispatcher("/admin");
				rd.forward(request, response);

			} else {
				// if not valid user then display message on login page
				response.sendRedirect("Login.jsp?message="
						+ URLEncoder.encode("Invalid Username or Password",
								"UTF-8"));
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

/**
 * JSP - Assignments
Session 2
Duration (Number of Hrs)

	 	 	 	

Write a user registration application:
Contains a user registration information form (JSP page) that requests a servlet.
Contains a servlet that accepts the request sent by client and persists the information in the database tables.
Write a login page:
Contains a login jsp page which requires username and password.
The login page requests a servlet to validate the login credentials. The servlet calls the api to fetch the information saved in assignment #1 and then validates it (possibly username and password) against the login credentials.
In case of successful login the jsp page must be displayed showing the successfully logged in and in case of failure the login page 	must again be displayed to re-login.


Note:
In database tables, not all the registration information should be 	persisted. Just persist the username, password and email.
In Assignment #2, you need to make sure all the exceptions must be redirected to error handler jsp page.
 */
package com.metacube.registration.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sumitra
 *
 * Servlet implementation class ValidateForm
 */

public class ValidateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// getting all field values from request
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		int flag = 0;
		String message = "";
		//validating all fields
		if (username.equals(null) || username.equals("")) {
			flag = 1;
			message = "User Name field Empty";
		} else if (email.equals(null) || email.equals("")) {
			flag = 1;
			message += "Email field Empty";
		}
		// check for empty password field & length greater than 8
		else if (password.equals(null) || password.equals("")) {
			flag = 1;
			message += "Password field Empty";
		}
		else if (password.length()<8) {
			flag = 1;
			message += "Password length should be greater than 8";
		}
		// check for empty confirm password field
		else if (confirmPassword.equals(null) || confirmPassword.equals("")) {
			flag = 1;
			message += "Confirm Password field Empty";
		}
		// check for equality of password and confirm password
		else if (!password.equals(confirmPassword)) {
			flag = 1;
			message += "Password doesn't match";
		}

		if (flag == 1) {
			// redirecting the response to index page
			response.sendRedirect("register.jsp?message="
					+ URLEncoder.encode(message, "UTF-8"));
		} else {
			request.setAttribute(username, username);
			request.setAttribute(email, email);
			request.setAttribute(password, password);
			// redirecting the request to InsertUserIntoDatabase servlet
			request.getRequestDispatcher("InsertUserIntoDatabase").forward(request,
					response);
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

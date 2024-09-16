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
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.registration.databaseconfiguration.ConnectionUtil;
import com.metacube.registration.helper.UserRegisterationDao;
import com.metacube.registration.model.User;

/**
 * @author Sumitra
 * 
 *         Servlet implementation class InsertIntoDatabase
 */
public class InsertUserIntoDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// getting parameters from request
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Setting User Details
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		// getting Connection
		Connection connection = ConnectionUtil.getConnection();
		if (connection == null) {
			connection = new ConnectionUtil().createConnection();
			new UserRegisterationDao(connection);
		}

		// inserting user into database
		boolean flag = UserRegisterationDao.insertIntoUserTable(user,
				connection);
		if (flag) {// if user inserted then redirect to login page
			response.sendRedirect("login.jsp?message="
					+ URLEncoder.encode("Successfully Registered, now Login",
							"UTF-8"));
		} else {
			// if not created then display user already exist
			response.sendRedirect("register.jsp?message="
					+ URLEncoder.encode("User name Already Exist, Try Another",
							"UTF-8"));
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

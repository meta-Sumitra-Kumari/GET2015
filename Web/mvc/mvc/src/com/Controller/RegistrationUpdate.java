package com.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.EmployeeListMain;
import com.modal.Employee;

/**
 * @author Sumitra
 *
 *         --- Servlet implementation class RegistrationUpdate ---It include
 *         both updation and creation
 * 
 */
public class RegistrationUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationUpdate() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) ----Checking if employee id is to edit then replace it in
	 *      map else adding a new value in map
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConcurrentHashMap<Integer, Employee> employeeMapNew = EmployeeListMain
				.getAllEmployees();

		String name = request.getParameter("employeeName");
		int id = Integer.parseInt(request.getParameter("id"));
		int age = Integer.parseInt(request.getParameter("age"));

		if (employeeMapNew.containsKey(id)) {
			employeeMapNew.replace(id, employeeMapNew.get(id), employeeMapNew
					.get(id).replaceEmployee(name, age, id));
		} else {
			employeeMapNew.put(id, new Employee(name, age, id, new Date()));
		}

		RequestDispatcher requestDispacher = request
				.getRequestDispatcher("EmployeeDataFetchAndSend");
		requestDispacher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}

package com.metacube.cardekho.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;

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
 * Servlet implementation class AddCar
 */
/**
 * @author Sumitra
 * --Servlet class to add car in database using dao class and jsp
 *         when added by admin
 *
 */
@WebServlet("/addcar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int flag = 0;
		String message = "";
		Connection connection = null;
		try {
			// setting up the connection
			connection = ConnectionFactory.getConnection();
			if (connection == null) {
				connection = new ConnectionFactory().createConnection();
				new CarPortalDao(connection);
			}

		} catch (CarDekhoSystemException e) {

			e.printStackTrace();
		}
		// checking for all parameters (server side checking)
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
		} else if (request.getParameter("roadTax").equals(null)
				|| request.getParameter("roadTax").equals("")) {
			flag = 1;
			message += "RoadTax field Empty";
		}

		if (flag == 1) {
			// redirecting the response to log in page if there is an error
			response.sendRedirect("addCar.jsp?message="
					+ URLEncoder.encode(message, "UTF-8"));
		} else {
			// insertion of car in table
			int insert = CarPortalDao
					.insertIntoCarTable(
							new Car((String) request.getParameter("make"),
									(String) request.getParameter("model"),
									Double.parseDouble(request
											.getParameter("engineInCC")),
									Double.parseDouble(request
											.getParameter("fuelCapacity")),
									Double.parseDouble(request
											.getParameter("milage")), Double
											.parseDouble(request
													.getParameter("price")),
									Double.parseDouble(request
											.getParameter("roadTax")), ""),
							connection);
			if (insert == 1) {
				request.setAttribute("make", request.getParameter("make"));
				RequestDispatcher rd = request
						.getRequestDispatcher("/addImageOfCar.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "Car not inserted");

				RequestDispatcher rd = request
						.getRequestDispatcher("/addCar.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String image_path = uploadFile(request, response);
		HttpSession session = request.getSession(true);
		String make = (String) session.getAttribute("make");

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

		int insert = CarPortalDao.updateImagePathOfCar(connection, image_path,
				make);
		if (insert == 1) {
			request.setAttribute("username", session.getAttribute("username"));
			RequestDispatcher rd = request.getRequestDispatcher("/admin");
			rd.forward(request, response);
		} else {
			request.setAttribute("message", "Car Image not inserted");
			request.setAttribute("make", request.getParameter("make"));
			RequestDispatcher rd = request
					.getRequestDispatcher("/addImageOfCar.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * --function to upload image file
	 * 
	 * @param request
	 * @param response
	 * @return---String of file name
	 * @throws IOException
	 */
	private String uploadFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String saveFile = "";

		String contentType = request.getContentType();

		if ((contentType != null)
				&& (contentType.indexOf("multipart/form-data") >= 0)) {
			DataInputStream in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			while (totalBytesRead < formDataLength) {
				try {
					byteRead = in.read(dataBytes, totalBytesRead,
							formDataLength);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				totalBytesRead += byteRead;

			}

			String file = new String(dataBytes);
			saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
					saveFile.indexOf("\""));
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,
					contentType.length());
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			File ff = new File(
					"C:/Users/Sumitra/workspace/advancejava/CaseStudy4/CaseStudy4/CaseStudy4/WebContent/images"
							+ saveFile);
			FileOutputStream fileOut = null;
			try {
				fileOut = new FileOutputStream(ff);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fileOut.write(dataBytes, startPos, (endPos - startPos));

			fileOut.flush();
			fileOut.close();
		}
		return "images/" + saveFile;
	}

}

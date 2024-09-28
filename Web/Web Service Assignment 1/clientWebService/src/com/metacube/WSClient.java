package com.metacube;

import java.util.Scanner;

import com.metacube.webServices.TemperatureConvertor;
import com.metacube.webServices.TemperatureConvertorServiceLocator;

/**
 * @author Sumitra
 * --Class to access remotely server end service
 *
 */
public class WSClient {
	public static void main(String[] args) {
		// locating the web service by creating the object of service locator
		// and connecting it to the wsdl file of web service
		TemperatureConvertorServiceLocator CTCWebServiceImplServiceLocator = new TemperatureConvertorServiceLocator();
		CTCWebServiceImplServiceLocator
				.setTemperatureConvertorEndpointAddress("http://localhost:8080/SoapAssignment/services/TemperatureConvertor");

		try {
			// creating the object of web service class by the locator and
			// accessing it
			TemperatureConvertor calcCTCWebService = CTCWebServiceImplServiceLocator
					.getTemperatureConvertor();
			System.out.println("enter the value");
			Scanner scanner = new Scanner(System.in);
			double value = scanner.nextDouble();
			System.out.println(calcCTCWebService.temperatureConvertor(value));
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

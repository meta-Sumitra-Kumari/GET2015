package com.metacube.webServices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author 
 * --Sumitra Class for defining web service
 *
 */

@WebService
public class TemperatureConvertor {
	/**
	 * Function to be accessed remotely
	 * 
	 * @param tempInFahrenheit
	 *            --value of temperature to be converted in celcius
	 * @return---temperature value in celcius
	 */
	@WebMethod
	public static double temperatureConvertor(double tempInFahrenheit) {
		return ((tempInFahrenheit * (9 / 5.0)) + 32);

	}

}

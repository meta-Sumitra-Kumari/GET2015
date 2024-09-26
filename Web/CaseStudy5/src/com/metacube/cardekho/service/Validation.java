/**
 * 
 */
package com.metacube.cardekho.service;

/**
 * @author Sumitra
 *
 */
public class Validation {

	/**Validating Login fields for admin
	 * @param username :username of admin
	 * @param password :password for admin
	 * @return :message for login
	 */
	public static String validationOnLoginOfAdmin(String username,
			String password) {
		String message = "";
		int flag = 0;
		// validating username field
		if (username.equals(null) || username.equals("")) {
			flag = 1;
			message += "User Name field Empty<br>";
		} // check for empty password field
		if (password.equals(null) || password.equals("")) {
			flag = 1;
			message += "Password field Empty";
		}
		return flag + "" + message;

	}

	/**Validating Car Details
	 * @param make :company name of car
	 * @param model :model of car
	 * @param engineInCC :engine in cc of car
	 * @param fuelCapacity :fuel capacity of car
	 * @param milage :milage of car
	 * @param price :price of car
	 * @param roadTax :roadtax of car
	 * @return :message
	 */
	public static String validationOnCarDetails(String make,String model,String engineInCC,String fuelCapacity,String milage,String price,String roadTax) {

		int flag = 0;
		String message = "";
		// Validations for car company name
		if (make.equals(null)
				|| make.equals("")) {
			flag = 1;
			message += "Make field Empty<br>";
		} // Validations for Model
		if (model.equals(null)
				|| model.equals("")) {
			flag = 1;
			message += "Model field Empty<br>";
			// Validations for Engine in cc
		} 
		if (engineInCC.equals(null)
				|| engineInCC.equals("")) {
			flag = 1;
			message += "EngineInCC field Empty<br>";
			// Validations for Fuel Capacity
		} 
		if (fuelCapacity.equals(null)
				|| fuelCapacity.equals("")) {
			flag = 1;
			message += "FuelCapacity field Empty<br>";
			// Validations for Milage
		}
		if (milage.equals(null)
				|| milage.equals("")) {
			flag = 1;
			message += "Milage field Empty<br>";
			// Validations for price
		} 
		if (price.equals(null)
				|| price.equals("")) {
			flag = 1;
			message += "Price field Empty<br>";
			// Validations for roadTax
		}
		if (roadTax.equals(null) ||roadTax.equals("")) {
			flag = 1;
			message += "RoadTax field Empty";
		}
		return flag + "" + message;
	}

}

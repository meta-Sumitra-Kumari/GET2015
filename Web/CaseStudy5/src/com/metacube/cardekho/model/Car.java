package com.metacube.cardekho.model;

/**
 * @author Sumitra
 * --Pojo class for car
 *
 */
public class Car {
	private String make;
	private String model;
	private double engineInCC;
	private double fuelCapacity;
	private double milage;
	private double price;
	private double roadTax;
	private double onRoadPrice;
	private String image_path;



	/**
	 * @param make
	 * @param model
	 * @param engineInCC
	 * @param fuelCapacity
	 * @param milage
	 * @param price
	 * @param roadTax
	 * @param onRoadPrice
	 * @param image_path
	 */
	public Car(String make, String model, double engineInCC,
			double fuelCapacity, double milage, double price, double roadTax,
			 String image_path) {
		super();
		this.make = make;
		this.model = model;
		this.engineInCC = engineInCC;
		this.fuelCapacity = fuelCapacity;
		this.milage = milage;
		this.price = price;
		this.roadTax = roadTax;
		this.onRoadPrice = (price*roadTax)/100;
		this.image_path = image_path;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make
	 *            the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the engineInCC
	 */
	public double getEngineInCC() {
		return engineInCC;
	}

	/**
	 * @param engineInCC
	 *            the engineInCC to set
	 */
	public void setEngineInCC(double engineInCC) {
		this.engineInCC = engineInCC;
	}

	/**
	 * @return the fuelCapacity
	 */
	public double getFuelCapacity() {
		return fuelCapacity;
	}

	/**
	 * @param fuelCapacity
	 *            the fuelCapacity to set
	 */
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	/**
	 * @return the milage
	 */
	public double getMilage() {
		return milage;
	}

	/**
	 * @param milage
	 *            the milage to set
	 */
	public void setMilage(double milage) {
		this.milage = milage;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the roadTax
	 */
	public double getRoadTax() {
		return roadTax;
	}

	/**
	 * @param roadTax
	 *            the roadTax to set
	 */
	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	/**
	 * @return the onRoadPrice
	 */
	public double getOnRoadPrice() {
		return onRoadPrice;
	}

	/**
	 * calculates road price
	 * 
	 * @param onRoadPrice
	 *            the onRoadPrice to set
	 */
	public void setOnRoadPrice() {
		this.onRoadPrice = price + roadTax;
	}

	/**
	 * @return the image_path
	 */
	public String getImage_path() {
		return image_path;
	}

	/**
	 * @param image_path the image_path to set
	 */
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
	

}

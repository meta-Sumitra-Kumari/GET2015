package com.modal;

import java.util.Date;

/**
 * @author Sumitra Employee class containing details of employee and functions to
 *         get access to it
 *
 */
public class Employee {

	private String name = "";
	private int age;
	private int employeeID;
	private java.util.Date lastUpdated;
	private final java.util.Date dateOfRegistration = new Date();

	/**
	 * Constructor for employee
	 * 
	 * @param name
	 * @param age
	 * @param employeeID
	 * @param lastUpdated
	 */
	public Employee(String name, int age, int employeeID,
			java.util.Date lastUpdated) {
		super();
		this.name = name;
		this.age = age;
		this.employeeID = employeeID;
		this.lastUpdated = lastUpdated;
	}

	/**
	 * Function to re set the employee object value if it is edited
	 * 
	 * @param name
	 * @param age
	 * @param employeeID
	 * @return
	 */
	public Employee replaceEmployee(String name, int age, int employeeID) {
		this.name = name;
		this.age = age;
		this.employeeID = employeeID;
		this.lastUpdated = new Date();

		return this;
	}

	/**
	 * @return last updated value of date
	 */
	public java.util.Date getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated
	 *            --set last updated date
	 */
	public void setLastUpdated(java.util.Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Employee Name: " + name + "\nEmployee ID: " + employeeID
				+ "\nAge: " + age + "\nDate of Registration: "
				+ dateOfRegistration + "\n Last Updated: " + lastUpdated;

	}

	/**
	 * @return--name of employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            --set name of employee
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return---age of employee
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            ---set age of employee
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return---id of employee
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID
	 *            ---set employee id
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return---date of registration
	 */
	public java.util.Date getDateOfRegistration() {
		return dateOfRegistration;
	}

}

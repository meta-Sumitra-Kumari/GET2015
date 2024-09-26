/**
 * Case Study- Assignments
Phase 5
Duration (Number of Hrs)

Assignment 1: Implement CarSales website as designed in prototype in phase 3. 
Implement all the use cases as designed in phase 3. Follow the layered architecture as discussed in the class.
 Use all the design patterns as discussed ie MVC-2, Facade, DAO, VO, Service and Factory. 
 Following use cases are must for the implementation.

Create Car Use case
Edit Car Use case
Search Car based on certain features as defined in use case
Login for administrator
Create/Edit only for administrator

 */
package com.metacube.cardekho.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.metacube.cardekho.databaseconfiguration.ConnectionFactory;
import com.metacube.cardekho.facade.CarPortalFacade;
import com.metacube.cardekho.model.Car;

/**
 * @author Sumitra
 * 
 */
public class CarPortalService {

	/**
	 * Using facade class to create storage for car details
	 */
	public void createStorageForCar() {
		Connection connection = null;
		CarPortalFacade facade = new CarPortalFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//creating storage of car
			facade.createDatabaseAndCarTable(connection);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//finally close connection
			ConnectionFactory.closeConnection(connection);
		}

	}

	/**Using facade class to get list of cars
	 * @return :list of cars
	 */
	public List<Car> getListOfCarForAdminHome() {
		List<Car> carList = null;
		Connection connection = null;
		CarPortalFacade facade = new CarPortalFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//getting list of cars
			carList = facade.gettingListOfCar(connection);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//finally close connection
			ConnectionFactory.closeConnection(connection);
		}
		return carList;

	}

	/**Using facade class to get list of car based on make and model
	 * @param make:make of car
	 * @param model :model of car
	 * @return :list of company name of car
	 */
	public List<Car> getListOfSearchedCarBasedOnMakeAndModel(String make,
			String model) {
		List<Car> carList = null;
		Connection connection = null;
		CarPortalFacade facade = new CarPortalFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//getting list of car based on make and model of car
			carList = facade.gettingListOfSearchedCarByMakeAndModel(connection,
					make, model);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//finally close connection
			ConnectionFactory.closeConnection(connection);
		}
		return carList;
	}

	/**Using facade class to get list of car based on budget
	 * @param price :price of car
	 * @return: list of car
	 */
	public List<Car> getListOfSearchedCarBasedOnBudget(Double price) {
		List<Car> carList = null;
		Connection connection = null;
		CarPortalFacade facade = new CarPortalFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//getlist of car based on budget
			carList = facade
					.gettingListOfSearchedCarByBudget(connection, price);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//to close connection
			ConnectionFactory.closeConnection(connection);
		}
		return carList;
	}

	/**Using facade class to get list of company name for cars
	 * @return :list of company name of car
	 */
	public List<String> getListOfCompanyNameOfCar() {
		List<String> makeList = null;
		Connection connection = null;
		CarPortalFacade facade = new CarPortalFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//getting list of company name of car
			makeList = facade.gettingListOfCompanyOfCar(connection);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//finally close connection
			ConnectionFactory.closeConnection(connection);
		}
		return makeList;
	}

	/**Using facade class to get list of model of car based on company of car
	 * @param make :make of car
	 * @return :list of model of car for this make
	 */
	public List<String> getListOfModelOfCarBasedOnCompany(String make) {
		List<String> modelList = null;
		Connection connection = null;
		CarPortalFacade facade = new CarPortalFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//get list of model of car for this make
			modelList = facade.gettingListOfModelOfCar(connection, make);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//finally close connection
			ConnectionFactory.closeConnection(connection);
		}
		return modelList;
	}

	/**Using facade class to creat new car
	 * @param car :car to create
	 * @return : 1 if inserted
	 */
	public int creatingNewCar(Car car) {
		int insert = 0;
		Connection connection = null;
		CarPortalFacade facade = new CarPortalFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//to insert car in database
			insert = facade.createNewCar(connection, car);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//finally close connection
			ConnectionFactory.closeConnection(connection);
		}
		return insert;
	}

	/**Using facade class to insert image of new car 
	 * @param image_path :image path of car
	 * @param make :company of this car
	 * @param model:model of this car
	 * @return :1 if inserted
	 */
	public int insertingImageOfCar(String image_path, String make, String model) {
		int insert = 0;
		Connection connection = null;
		CarPortalFacade facade = new CarPortalFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//update image of car in database
			insert = facade.insertImageOfCarBasedOnMakeAndModel(connection,
					image_path, make, model);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//to close connection
			ConnectionFactory.closeConnection(connection);
		}
		return insert;
	}

	/**Using facade class to update details of car
	 * @param car :car to update
	 * @return :1 if updated
	 */
	public int editDetailsOfCar(Car car) {
		int result = 0;
		Connection connection = null;
		CarPortalFacade facade = new CarPortalFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//update details of car
			result = facade.updateCarDetail(connection, car);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//finally close connection
			ConnectionFactory.closeConnection(connection);
		}
		return result;
	}

}

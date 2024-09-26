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

package com.metacube.cardekho.facade;

import java.sql.Connection;
import java.util.List;

import com.metacube.cardekho.db.helper.CarPortalDao;
import com.metacube.cardekho.exception.CarDekhoSystemException;
import com.metacube.cardekho.model.Car;

/**
 * @author Sumitra
 * 
 */
public class CarPortalFacade {

	/**Using dao class to create Database And Car Table
	 * @param connection :connection
	 */
	public void createDatabaseAndCarTable(Connection connection) {
		//Database and Car Table created
		CarPortalDao carPortalDao = new com.metacube.cardekho.db.helper.CarPortalDao(connection);
		//inserting dummy data
		carPortalDao.insertIntoTableDefaultCar(connection);
	}

	/**Using dao class to getList of cars
	 * @param connection :connection
	 * @return
	 */
	public List<Car> gettingListOfCar(Connection connection) {
		//using car portal database
		CarPortalDao.useCarPortalDatabase(connection);
		// getting list of all cars
		return CarPortalDao.selectListOfCar(connection);
	}

	/**Using dao class to get List of searched car by make and model
	 * @param connection:connection
	 * @param make :make of car 
	 * @param model:model of car
	 * @return :list of car of this make and model
	 */
	public List<Car> gettingListOfSearchedCarByMakeAndModel(
			Connection connection, String make, String model) {
		//using car portal database
		CarPortalDao.useCarPortalDatabase(connection);
		// getting list of car based on make and model
		return CarPortalDao.selectCarBasedOnMakeAndModel(connection, make,
				model);
	}

	/**Using dao class to  get list of car based on price
	 * @param connection :connection
	 * @param price :price of car below which car we have to find
	 * @return :list of car below this price
	 */
	public List<Car> gettingListOfSearchedCarByBudget(Connection connection,
			double price) {
		//using car portal database
		CarPortalDao.useCarPortalDatabase(connection);
		// getting list of car based on budget
		return CarPortalDao.selectListOfCarBasedOnBudget(connection, price);
	}

	/**Using dao class to get list of make of car
	 * @param connection :connection
	 * @return :list of make
	 */
	public List<String> gettingListOfCompanyOfCar(Connection connection) {
		//using car portal database
		CarPortalDao.useCarPortalDatabase(connection);
		// Getting unique make of cars
		return CarPortalDao.selectListOfMakeOfCar(connection);
	}

	/**Using dao class to get list of model based on make of car
	 * @param connection:connection
	 * @param make:make of car
	 * @return: list of model based on this make
	 */
	public List<String> gettingListOfModelOfCar(Connection connection,
			String make) {
		//using car portal database
		CarPortalDao.useCarPortalDatabase(connection);
		// Getting model of car for this make
		return CarPortalDao.selectListOfModelOfCarBasedOnMake(connection, make);
	}

	/**Using dao class to insert car in table 
	 * @param connection :connection
	 * @param car :car to insert
	 * @return: return 1 if inserted car in table else throw exception
	 * @throws CarPortalException
	 */
	public int createNewCar(Connection connection, Car car)
			throws CarDekhoSystemException {
		//using car portal database
		CarPortalDao.useCarPortalDatabase(connection);
		int result = 0;
		try {
			//inserting car in table
			result = CarPortalDao.insertIntoCarTable(car, connection);
			if (result == 1) {//if car inserted successfully
				return result;
			} else {//if not inserted then create exception
				throw new CarDekhoSystemException("Car of " + car.getMake()
						+ " and " + car.getModel() + " already exists.");
			}
		} catch (CarDekhoSystemException e) {
			System.out.println("Exception while inserting Car as: "
					+ e.getMessage());
			throw e;
		}
	}

	/**Using dao class to insert image of car based on budget
	 * @param connection:connection
	 * @param image_path :image path
	 * @param make :make of car
	 * @param model :model of car
	 * @return :1 if inserted else exception
	 * @throws CarPortalException
	 */
	public int insertImageOfCarBasedOnMakeAndModel(Connection connection,
			String image_path, String make, String model)
			throws CarDekhoSystemException {
		int result = 0;
		//using car portal database
		CarPortalDao.useCarPortalDatabase(connection);
		try {
			//updating image path of new car inserted
			result = CarPortalDao.updateImagePathOfCar(connection, image_path,
					make, model);
			if (result == 1) {//if inserted successfully
				return result;
			} else {//if not updates then throw exception
				throw new CarDekhoSystemException("Image of Car of " + make
						+ " and " + model + " insertion failed.");
			}
		} catch (CarDekhoSystemException e) {
			System.out.println("Exception while inserting Car Image as: "
					+ e.getMessage());
			throw e;
		}
	}

	/**Using dao class to update car details
	 * @param connection :connection
	 * @param car :car to update
	 * @return :1 if updated else exception created
	 * @throws CarPortalException
	 */
	public int updateCarDetail(Connection connection, Car car)
			throws CarDekhoSystemException {
		int result = 0;
		//using car portal database
		CarPortalDao.useCarPortalDatabase(connection);
		try {
			//updating car details
			result = CarPortalDao.updateCarDetails(connection, car);
			if (result == 1) {//if updated then return 1
				return result;
			} else {//if not updated then throw exception
				throw new CarDekhoSystemException("Updation of Car of "
						+ car.getMake() + " and " + car.getModel() + " failed.");
			}
		} catch (CarDekhoSystemException e) {
			System.out.println("Exception while inserting Car :"
					+ e.getMessage());
			throw e;
		}
	}

}

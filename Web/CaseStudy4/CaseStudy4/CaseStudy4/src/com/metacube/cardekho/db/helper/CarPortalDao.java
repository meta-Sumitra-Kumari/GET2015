/**
 * 
 */
package com.metacube.cardekho.db.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.cardekho.model.Car;

/**
 * @author Sumitra Dao 
 * --class for establishing connection through database
 * 
 */
public class CarPortalDao {
	private static String CREATE_CAR_QUERY, INSERT_CAR_QUERY,
			CREATE_CARPORTEL_DATABASE_QUERY, USE_CARDEKHO_DATABASE_QUERY,
			SELECT_CAR_QUERY, UPDATE_CAR_QUERY, SELECT_CAR_BY_MAKE_MODEL_QUERY,
			SELECT_CAR_BUDGET_QUERY, SELECT_LIST_OF_MAKE, SELECT_LIST_OF_MODEL,
			UPDATE_IMAGE_PATH_OF_CAR_QUERY, SELECT_LIST_OF_CAR_BY_MAKE; // Query
	// Strings

	static {
		CREATE_CARPORTEL_DATABASE_QUERY = "CREATE DATABASE IF NOT EXISTS car_portel";
		USE_CARDEKHO_DATABASE_QUERY = "USE car_portel";
		CREATE_CAR_QUERY = "CREATE TABLE IF NOT EXISTS Car" + "("
				+ "make VARCHAR(20), " + "model VARCHAR(20), "
				+ "engine_in_cc DOUBLE, " + "fuel_capacity DOUBLE,"
				+ "milage DOUBLE," + "price DOUBLE," + "road_tax DOUBLE,"
				+ "on_road_price DOUBLE," + "image_path VARCHAR(40),"
				+ "PRIMARY KEY(make,model) )";
		INSERT_CAR_QUERY = "INSERT INTO Car(make, model, engine_in_cc, fuel_capacity, milage, price, road_tax,on_road_price,image_path) VALUES(?,?,?,?,?,?,?,?,?)";
		SELECT_CAR_QUERY = "SELECT * FROM Car";
		UPDATE_CAR_QUERY = "UPDATE Car SET engine_in_cc=?, fuel_capacity=?, milage=?, price=?,on_road_price=? WHERE make=? AND model=? ";
		SELECT_CAR_BUDGET_QUERY = "SELECT * FROM Car WHERE price<?";
		SELECT_CAR_BY_MAKE_MODEL_QUERY = "SELECT * FROM Car WHERE make=? AND model=?";
		SELECT_LIST_OF_MAKE = "SELECT make FROM Car";
		SELECT_LIST_OF_MODEL = "SELECT model FROM Car WHERE make=?";
		SELECT_LIST_OF_CAR_BY_MAKE = "SELECT * FROM Car WHERE make=?";
		UPDATE_IMAGE_PATH_OF_CAR_QUERY = "UPDATE Car SET image_path=? WHERE make=?";

	}

	/**
	 * Constructor connection: Connection of database
	 */
	/**
	 * Function for setting up database
	 * 
	 * @param connection
	 */
	public CarPortalDao(Connection connection) {

		Statement statement = null;
		try {
			statement = connection.createStatement();
			// Creating database and creating table user
			statement.execute(CREATE_CARPORTEL_DATABASE_QUERY);
			statement.execute(USE_CARDEKHO_DATABASE_QUERY);
			statement.execute(CREATE_CAR_QUERY);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Function to default set some cars
	 * 
	 * @param connection
	 */
	public void insertIntoTableDefaultCar(Connection connection) {
		if (connection != null) {
			insertIntoCarTable(new Car("Audi", "Audi-Q3", 12, 100, 50, 3200000,
					13, "images/prod_img_01.jpg"), connection);

			insertIntoCarTable(new Car("Audi-A7", "Audi-S", 16, 80, 80,
					8000000, 13, "images/prod_img_02.jpg"), connection);
			insertIntoCarTable(new Car("Ford", "Fiesta", 13, 120, 70, 10000000,
					13, "images/prod_img_03.jpg"), connection);
			insertIntoCarTable(new Car("Honda", "Juzz", 14, 150, 40, 9900000,
					13, "images/prod_img_04.jpg"), connection);
			insertIntoCarTable(new Car("Tata", "Nano", 21, 130, 30, 4300000,
					13, "images/prod_img_05.jpg"), connection);
		} else {
			System.out.println("Connection Error");
		}
	}

	/**
	 * To insert user into database
	 * 
	 * @param car
	 *            :user details
	 * @param connection
	 *            :connection of database
	 * @return :if data inserted then true else false
	 */
	/**
	 * function to insert car in db
	 * 
	 * @param car
	 *            ---car to insert
	 * @param connection
	 *            --connection
	 * @return--whether car is inserted or not
	 */
	public static int insertIntoCarTable(Car car, Connection connection) {

		PreparedStatement preparedStatement = null;

		try {
			// inserting user into user table
			preparedStatement = connection.prepareStatement(INSERT_CAR_QUERY);
			preparedStatement.setString(1, car.getMake());
			preparedStatement.setString(2, car.getModel());
			preparedStatement.setDouble(3, car.getEngineInCC());
			preparedStatement.setDouble(4, car.getFuelCapacity());
			preparedStatement.setDouble(5, car.getMilage());
			preparedStatement.setDouble(6, car.getPrice());
			preparedStatement.setDouble(7, car.getRoadTax());
			preparedStatement.setDouble(8, car.getOnRoadPrice());
			preparedStatement.setString(9, car.getImage_path());
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			return -1;
		}
	}

	/**
	 * Function to return list of car
	 * 
	 * @param connection
	 * @return--list of cars
	 */
	public static List<Car> selectListOfCar(Connection connection) {

		List<Car> carList = new ArrayList<Car>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// inserting user into user table
			preparedStatement = connection.prepareStatement(SELECT_CAR_QUERY);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				carList.add(new Car(resultSet.getString(1), resultSet
						.getString(2), resultSet.getDouble(3), resultSet
						.getDouble(4), resultSet.getDouble(5), resultSet
						.getDouble(6), resultSet.getDouble(7), resultSet
						.getString(9)));
			}
		} catch (SQLException e) {
		}
		return carList;
	}

	/**
	 * function to return list of make of cars
	 * 
	 * @param connection
	 * @return--list of make of cars
	 */
	public static List<String> selectListOfMakeOfCar(Connection connection) {

		List<String> makeList = new ArrayList<String>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// inserting user into user table
			preparedStatement = connection
					.prepareStatement(SELECT_LIST_OF_MAKE);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				makeList.add(resultSet.getString(1));

			}
		} catch (SQLException e) {
		}
		return makeList;
	}

	/**
	 * Function to display model of cars based on their make
	 * 
	 * @param connection
	 * @param make
	 *            --make of car
	 * @return--list of model of cars based on their make
	 */
	public static List<String> selectListOfModelOfCarBasedOnMake(
			Connection connection, String make) {

		List<String> modelList = new ArrayList<String>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// inserting user into user table
			preparedStatement = connection
					.prepareStatement(SELECT_LIST_OF_MODEL);
			preparedStatement.setString(1, make);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				modelList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
		}
		return modelList;
	}

	/**
	 * Function to select car based on budget
	 * 
	 * @param connection
	 * @param price
	 *            ---maximum price up to which we have to show
	 * @return---list of car based on budget
	 */
	public static List<Car> selectListOfCarBasedOnBudget(Connection connection,
			double price) {

		List<Car> list = new ArrayList<Car>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// inserting user into user table
			preparedStatement = connection
					.prepareStatement(SELECT_CAR_BUDGET_QUERY);
			preparedStatement.setDouble(1, price);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add(new Car(resultSet.getString(1),
						resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getDouble(4), resultSet.getDouble(5),
						resultSet.getDouble(6), resultSet.getDouble(7),
						resultSet.getString(9)));
			}
		} catch (SQLException e) {
		}
		return list;
	}

	/**
	 * function to display car based on model and make
	 * 
	 * @param connection
	 * @param make
	 *            --make of car
	 * @param model
	 *            --model of car
	 * @return--list of car based on make and model
	 */
	public static List<Car> selectCarBasedOnMakeAndModel(Connection connection,
			String make, String model) {
		List<Car> list = new ArrayList<Car>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// inserting user into user table
			preparedStatement = connection
					.prepareStatement(SELECT_CAR_BY_MAKE_MODEL_QUERY);
			preparedStatement.setString(1, make);
			preparedStatement.setString(2, model);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add(new Car(resultSet.getString(1),
						resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getDouble(4), resultSet.getDouble(5),
						resultSet.getDouble(6), resultSet.getDouble(7),
						resultSet.getString(9)));
			}
		} catch (SQLException e) {
		}
		return list;
	}

	/**
	 * function to display the car list based on make
	 * 
	 * @param connection
	 * @param make
	 *            --make of car
	 * @return---car list based on make of the car
	 */
	public static List<Car> selectCarBasedOnMake(Connection connection,
			String make) {
		List<Car> list = new ArrayList<Car>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// inserting user into user table
			preparedStatement = connection
					.prepareStatement(SELECT_LIST_OF_CAR_BY_MAKE);
			preparedStatement.setString(1, make);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				list.add(new Car(resultSet.getString(1),
						resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getDouble(4), resultSet.getDouble(5),
						resultSet.getDouble(6), resultSet.getDouble(7),
						resultSet.getString(9)));
			}
		} catch (SQLException e) {
		}
		return list;
	}

	/**
	 * Function to update the car
	 * 
	 * @param connection
	 * @param car
	 *            --car which is to be update
	 * @return--whether car is updated or not
	 */
	public static int updateCarDetails(Connection connection, Car car) {

		PreparedStatement preparedStatement = null;

		try {
			// inserting user into user table
			preparedStatement = connection.prepareStatement(UPDATE_CAR_QUERY);

			preparedStatement.setDouble(1, car.getEngineInCC());
			preparedStatement.setDouble(2, car.getFuelCapacity());
			preparedStatement.setDouble(3, car.getMilage());
			preparedStatement.setDouble(4, car.getPrice());
			preparedStatement.setDouble(5, car.getOnRoadPrice());

			preparedStatement.setString(6, car.getMake());
			preparedStatement.setString(7, car.getModel());
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			return -1;
		}
	}

	/**
	 * function to update image path of car
	 * 
	 * @param connection
	 * @param image_path
	 *            --image path
	 * @param make
	 *            --make of car
	 * @return--whether car is updated or not
	 */
	public static int updateImagePathOfCar(Connection connection,
			String image_path, String make) {

		PreparedStatement preparedStatement = null;

		try {
			// inserting user into user table
			preparedStatement = connection
					.prepareStatement(UPDATE_IMAGE_PATH_OF_CAR_QUERY);

			preparedStatement.setString(1, image_path);
			preparedStatement.setString(2, make);
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			return -1;
		}
	}

}

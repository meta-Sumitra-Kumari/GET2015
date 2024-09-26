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
 * @author Sumitra 
 * --class for establishing connection through database
 * 
 */
public class CarPortalDao {
	private static String CREATE_CAR_QUERY, INSERT_CAR_QUERY,
			CREATE_CARPORTEL_DATABASE_QUERY, USE_CARDEKHO_DATABASE_QUERY,
			SELECT_CAR_QUERY, UPDATE_CAR_QUERY, SELECT_CAR_BY_MAKE_MODEL_QUERY,
			SELECT_CAR_BUDGET_QUERY, SELECT_LIST_OF_MAKE, SELECT_LIST_OF_MODEL,
			UPDATE_IMAGE_PATH_OF_CAR_QUERY; // Query Strings

	static {
		CREATE_CARPORTEL_DATABASE_QUERY = "CREATE DATABASE IF NOT EXISTS car_portel";
		USE_CARDEKHO_DATABASE_QUERY = "USE car_portel";
		CREATE_CAR_QUERY = "CREATE TABLE IF NOT EXISTS Car" + "("
				+ "make VARCHAR(20), " + "model VARCHAR(20), "
				+ "engine_in_cc DOUBLE, " + "fuel_capacity DOUBLE,"
				+ "milage DOUBLE," + "price DOUBLE," + "road_tax DOUBLE,"
				+ "on_road_price DOUBLE," + "image_path VARCHAR(40)," +
						"PRIMARY KEY(make,model) )";
		INSERT_CAR_QUERY = "INSERT INTO Car(make, model, engine_in_cc, fuel_capacity, milage, price, road_tax,on_road_price,image_path) VALUES(?,?,?,?,?,?,?,?,?)";
		SELECT_CAR_QUERY = "SELECT * FROM Car";
		UPDATE_CAR_QUERY = "UPDATE Car SET engine_in_cc=?, fuel_capacity=?, milage=?, price=?,on_road_price=? WHERE make=? AND model=? ";
		SELECT_CAR_BUDGET_QUERY = "SELECT * FROM Car WHERE price<?";
		SELECT_CAR_BY_MAKE_MODEL_QUERY = "SELECT * FROM Car WHERE make=? AND model=?";
		SELECT_LIST_OF_MAKE="SELECT DISTINCT make FROM Car";
		SELECT_LIST_OF_MODEL="SELECT model FROM Car WHERE make=?";
		UPDATE_IMAGE_PATH_OF_CAR_QUERY="UPDATE Car SET image_path=? WHERE make=? AND model=?";

	}

	/**Creating and using database and creating car table here
	 * Constructor connection: Connection of database
	 */
	public CarPortalDao(Connection connection) {

		Statement statement = null;
		try {
			statement = connection.createStatement();
			// Creating database and creating table user
			statement.execute(CREATE_CARPORTEL_DATABASE_QUERY);
			//Use query For car portal Database
			useCarPortalDatabase(connection);
			//create car table
			statement.execute(CREATE_CAR_QUERY);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	/**To use car portal Database for further query
	 * @param connection :connection
	 */
	public static void useCarPortalDatabase(Connection connection){
		Statement statement = null;
		try {
			statement = connection.createStatement();
			//use query for carportal database
			statement.execute(USE_CARDEKHO_DATABASE_QUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/**Inserting dummy data in car table
	 * @param connection :connection
	 */
	public void insertIntoTableDefaultCar(Connection connection) {
		if(connection!=null){
		insertIntoCarTable(new Car("Audi", "Audi-Q3", 12, 100, 50, 3200000, 13,"images/prod_img_01.jpg"), connection);
		
		insertIntoCarTable(new Car("Audi-A7", "Audi-S", 16, 80, 80, 8000000, 13,"images/prod_img_02.jpg"), connection);
		insertIntoCarTable(new Car("Ford", "Fiesta", 13, 120, 70, 10000000, 13,"images/prod_img_03.jpg"), connection);
		insertIntoCarTable(new Car("Honda", "Juzz", 14, 150, 40, 9900000, 13,"images/prod_img_04.jpg"), connection);
		insertIntoCarTable(new Car("Tata", "Nano", 21, 130, 30, 4300000, 13,"images/prod_img_05.jpg"), connection);
		}else{
			System.out.println("Connection Error");
		}
	}
	

	/**
	 * To insert car into database
	 * 
	 * @param car:car details
	 * @param connection:connection of database
	 * @return :if data inserted then 1 else -1
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

	/**for selecting all cars from database
	 * @param connection :connection
	 * @return : list of cars
	 */
	public static List<Car> selectListOfCar(Connection connection) {

		List<Car> carList = new ArrayList<Car>();//List of car
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(SELECT_CAR_QUERY);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				//setting car in list
				carList.add(new Car(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getDouble(4),resultSet.getDouble(5),resultSet.getDouble(6),resultSet.getDouble(7),resultSet.getString(9)));
			}
		} catch (SQLException e) {
		}
		return carList;
	}

	/**To get list of make from database
	 * @param connection :connection
	 * @return :list of make of car
	 */
	public static List<String> selectListOfMakeOfCar(Connection connection) {

		List<String> makeList = new ArrayList<String>(); //list of make

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
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

	/**To get list of model from database
	 * @param connection :connection
	 * @return :list of model of car
	 */
	public static List<String> selectListOfModelOfCarBasedOnMake(
			Connection connection, String make) {

		List<String> modelList = new ArrayList<String>();//list of model

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
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

	/**getting list of car based on price
	 * @param connection:connection
	 * @param price:price 
	 * @return :list of car
	 */
	public static List<Car> selectListOfCarBasedOnBudget(Connection connection,
			double price) {

		List<Car> list = new ArrayList<Car>();//list of car
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement(SELECT_CAR_BUDGET_QUERY);
			preparedStatement.setDouble(1, price);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				//adding car to list
				list.add(new Car(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getDouble(4),resultSet.getDouble(5),resultSet.getDouble(6),resultSet.getDouble(7),resultSet.getString(9)));
			}
		} catch (SQLException e) {
		}
		return list;
	}

	/**Getting list of car based on make and model
	 * @param connection :connection
	 * @param make :make of car
	 * @param model :model of car
	 * @return :list of car
	 */
	public static List<Car> selectCarBasedOnMakeAndModel(Connection connection,String make,String model) {
		List<Car> list = new ArrayList<Car>();//list of  car
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement(SELECT_CAR_BY_MAKE_MODEL_QUERY);
			preparedStatement.setString(1, make);
			preparedStatement.setString(2, model);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				//adding car to list
				list.add(new Car(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getDouble(4),resultSet.getDouble(5),resultSet.getDouble(6),resultSet.getDouble(7),resultSet.getString(9)));
			}
		} catch (SQLException e) {
		}
		return list;
	}

	/**To update car details
	 * @param connection :connection
	 * @param car :car detail
	 * @return :if updated then 1 else -1
	 */
	public static int updateCarDetails(Connection connection, Car car) {

		
		PreparedStatement preparedStatement = null;

		try {
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
	
	/**To update image path of car based on make of car
	 * @param connection:connection
	 * @param image_path :image path
	 * @param make :make of car
	 * @return :if updated then 1 else -1 
	 */
	public static int updateImagePathOfCar(Connection connection, String image_path,String make,String model){

		
		PreparedStatement preparedStatement = null;

		try {
			// inserting user into user table
			preparedStatement = connection.prepareStatement(UPDATE_IMAGE_PATH_OF_CAR_QUERY);

			preparedStatement.setString(1, image_path);
			preparedStatement.setString(2, make);
			preparedStatement.setString(3, model);
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			return -1;
		}
	}

}

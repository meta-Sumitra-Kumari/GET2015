package com.metacube.registration.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.metacube.registration.model.User;

/**
 * @author Sumitra
 *
 */
public class UserRegisterationDao {
	private static String createUserTableQuery, insertInUserTableQuery, createUserRegistrationDatabaseQuery,
			useUserRegistrationDatabaseQuery, isUserValidateQuery; // Query Strings

	static {
		createUserRegistrationDatabaseQuery = "CREATE DATABASE IF NOT EXISTS user_registration";
		useUserRegistrationDatabaseQuery = "USE user_registration";
		createUserTableQuery = "CREATE TABLE IF NOT EXISTS User" + "("
				+ "user_id INT AUTO_INCREMENT PRIMARY KEY, "
				+ "username VARCHAR(20), " + "email VARCHAR(20),"
				+ "password VARCHAR(20) )";
		insertInUserTableQuery = "INSERT INTO user(username,email, password) VALUES (?,?,?)";
		isUserValidateQuery = "SELECT user_id FROM user WHERE username=? and password=?";
	}

	/**
	 * Constructor
	 * connection: Connection of database 
	 */
	public UserRegisterationDao(Connection connection) {
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			//Creating database and creating table user
			statement.execute(createUserRegistrationDatabaseQuery);
			statement.execute(useUserRegistrationDatabaseQuery);
			statement.execute(createUserTableQuery);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	/**To insert user into database
	 * @param user :user details
	 * @param connection :connection of database
	 * @return :if data inserted then true else false
	 */
	public boolean insertIntoUserTable(User user,Connection connection) {

		boolean flag = true;
		PreparedStatement preparedStatement = null;

		try {
			//inserting user into user table
			preparedStatement = connection.prepareStatement(insertInUserTableQuery);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * @param user :user detail to validate 
	 * @param connection :connection of database
	 * @return :if user valid then true else false
	 */
	public static boolean isValidUser(User user,Connection connection) {

		boolean flag = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//Query to validate user
			preparedStatement = connection.prepareStatement(isUserValidateQuery);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				flag = true;
			} 
		} catch (SQLException e) {
		}
		return flag;
	}

}

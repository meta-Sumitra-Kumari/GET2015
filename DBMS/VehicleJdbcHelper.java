
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Sumitra
 * 
 *         Class to creating ,inserting and deleting from vehicle table
 *
 */
public class VehicleJdbcHelper {

	/**
	 * ---Function to create vehicle table
	 * 
	 * @param objVehicle
	 * @return---created or not
	 * @throws VehicleManagementException
	 */
	public static boolean createVehicleTable(Vehicle objVehicle)
			throws VehicleManagementException {
		boolean bool = false;
		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "CREATE TABLE IF NOT EXISTS Vehicle" + "("
				+ "vehicle_id INT AUTO_INCREMENT PRIMARY KEY, "
				+ "make VARCHAR(20), " + "model VARCHAR(20), "
				+ "engine_in_cc DOUBLE, " + "fuel_capacity DOUBLE,"
				+ "milage DOUBLE," + "price DOUBLE," + "road_tax DOUBLE,"
				+ "created_by VARCHAR(20),"
				+ "created_time TIMESTAMP DEFAULT NOW()" + " )";
		try {
			stmt = con.createStatement();
			bool = stmt.execute(query);

			if (objVehicle instanceof Car)
				CarJdbcHelper.createCarTable();
			else if (objVehicle instanceof Bike)
				BikeJdbcHelper.createBikeTable();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			closeAll(con,stmt,null);
		}
		return bool;
	}

	/**
	 * @param objVehicle
	 * @return---whether inserted or not
	 * @throws VehicleManagementException
	 */
	public static String insertInVehicleTable(Vehicle objVehicle)
			throws VehicleManagementException {
		int countVehicle = 0, countCar = 0, countBike = 0;
		String str = null;
		Connection con = null;
		PreparedStatement ps = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "INSERT INTO Vehicle (vehicle_id, make, model, engine_in_cc, fuel_capacity, milage, price, road_tax, created_by) VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			ps = (PreparedStatement) con.prepareStatement(query);
			/* set variable in prepared statement */
			ps.setInt(1, objVehicle.getVehicleId());
			ps.setString(2, objVehicle.getMake());
			ps.setString(3, objVehicle.getModel());
			ps.setDouble(4, objVehicle.getEngineInCC());
			ps.setDouble(5, objVehicle.getFuelCapacity());
			ps.setDouble(6, objVehicle.getMilage());
			ps.setDouble(7, objVehicle.getPrice());
			ps.setDouble(8, objVehicle.getRoadTax());
			ps.setString(9, objVehicle.getCreatedBy());
			countVehicle = ps.executeUpdate();
			if (countVehicle > 0) {
				if (objVehicle instanceof Car) {
					countCar = CarJdbcHelper
							.insertInCarTable(((Car) objVehicle));
					if (countCar > 0)
						str = "Car created Successfully";
					else
						str = "Could not create Car";
				} else if (objVehicle instanceof Bike) {
					countBike = BikeJdbcHelper
							.insertInBikeTable(((Bike) objVehicle));
					if (countBike > 0)
						str = "Bike created Successfully";
					else
						str = "Could not create Bike";
				}
			} else
				str = "Could not create vehicle";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			closeAll(con,null,ps);
		}

		return str;
	}

	/**
	 * Function to delete all vehicles
	 * 
	 * @throws VehicleManagementException
	 */
	@SuppressWarnings("resource")
	public static void deleteAllVehicles() throws VehicleManagementException {

		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();
		String query1 = "DROP TABLE Bike";
		String query2 = "DROP TABLE Car";
		String query3 = "DROP TABLE Vehicle";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query1);
			stmt = con.createStatement();
			stmt.executeUpdate(query2);
			stmt = con.createStatement();
			stmt.executeUpdate(query3);

		} catch (SQLException e) {

			e.printStackTrace();

		}
		finally{
			closeAll(con,stmt,null);
		}
		
	}
	static void closeAll(Connection con, Statement stmt,PreparedStatement ps)
	{
		 {
				/* close connection */
				try {
					if (con != null) {
						con.close();
					}
					if (stmt != null) {
						stmt.close();
					}
					if(ps!=null){
						ps.close();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

}


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Sumitra class for creating ,inserting and deleting from car table
 */
public class CarJdbcHelper {

	/**
	 * Class to create car table
	 * 
	 * @throws VehicleManagementException
	 */
	
	
	 
	public static void createCarTable() throws VehicleManagementException {
		 Connection con = null;
		 Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "CREATE TABLE IF NOT EXISTS Car"
				+ "("
				+ "car_id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "ac tinyint(1),"
				+ "power_steering tinyint(1),"
				+ "accessory_kit tinyint(1),"
				+ "vehicle_id INT,"
				+ "CONSTRAINT `vehicle_key` FOREIGN KEY (vehicle_id) REFERENCES Vehicle (vehicle_id) ON DELETE CASCADE"
				+ ")";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			closeAll(con,stmt,null,null);
		}
	}

	/**
	 * 
	 * ---Function to insert in table
	 * 
	 * @param objCar
	 *            ----object of car type
	 * @return----whether inserted or not
	 * @throws VehicleManagementException
	 */
	public static int insertInCarTable(Car objCar)
			throws VehicleManagementException {
		int countCar = 0;
		 Connection con = null;
		 PreparedStatement ps = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "INSERT INTO Car ( ac, power_steering, accessory_kit, vehicle_id ) VALUES (?,?,?,?)";

		try {
			ps = (PreparedStatement) con.prepareStatement(query);
			/* set variable in prepared statement */
			ps.setBoolean(1, objCar.isAC());
			ps.setBoolean(2, objCar.isPowerSteering());
			ps.setBoolean(3, objCar.isAccessoryKit());
			ps.setInt(4, objCar.getVehicleId());
			countCar = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			closeAll(con,null,null,ps);
		}
		return countCar;
	}

	/**
	 * 
	 * Function to delete car from table car
	 * 
	 * @param vehicleId
	 * @throws VehicleManagementException
	 */
	@SuppressWarnings("resource")
	public static void deleteCarTable(int vehicleId)
			throws VehicleManagementException {
		 Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "SELECT vehicle_id FROM Car WHERE vehicle_id = "
				+ vehicleId;
		try {
			stmt = con.createStatement();
			/* execute query using statement */
			rs = stmt.executeQuery(query);
			if (rs.next() == false) {
				System.out.println("Id doesnot exist");
				return;
			} else {
				stmt = null;
				query = "DELETE FROM Vehicle WHERE vehicle_id = " + vehicleId;
				try {
					stmt = con.createStatement();
					stmt.executeUpdate(query);
					System.out.println("Car deleted");
				} catch (SQLException e) {
					throw new VehicleManagementException("Cannot delete car : "
							+ e);
				}
			}
		} catch (SQLException e) {
			throw new VehicleManagementException("Cannot delete car : " + e);
		} finally {
			/* close connection */
			closeAll(con,stmt,rs,null);
		}

	}
	static void closeAll(Connection con ,Statement stmt, ResultSet rs,PreparedStatement ps)
	{
		try {
			if (con != null) {
				con.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

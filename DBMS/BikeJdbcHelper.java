import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Sumitra ---class for creating ,inserting and deleting from bike table
 *
 */
public class BikeJdbcHelper {

	/**
	 * 
	 * ---Class to create bike table
	 * 
	 * @throws VehicleManagementException
	 */
	 

	
	public static void createBikeTable() throws VehicleManagementException {
		Connection con = null;
		 Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "CREATE TABLE IF NOT EXISTS Bike"
				+ "("
				+ "bike_id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "self_start tinyint(1),"
				+ "helmet_price DOUBLE,"
				+ "vehicle_id INT,"
				+ "CONSTRAINT `vehicle_key1` FOREIGN KEY (vehicle_id) REFERENCES Vehicle (vehicle_id) ON DELETE CASCADE"
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
	 * ---Class to insert in bike
	 * 
	 * @param objBike
	 *            -----bike as an object
	 * @return---whether inserted or not
	 * @throws VehicleManagementException
	 */
	public static int insertInBikeTable(Bike objBike)
			throws VehicleManagementException {
		int countBike = 0;
		Connection con = null;
		 PreparedStatement ps = null;
		
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();

		String query = "INSERT INTO Bike ( self_start, helmet_price, vehicle_id ) VALUES (?,?,?)";

		try {
			ps = (PreparedStatement) con.prepareStatement(query);
			/* set variable in prepared statement */
			ps.setBoolean(1, objBike.getSelfStart());
			ps.setDouble(2, objBike.getHelmetPrice());
			ps.setInt(3, objBike.getVehicleId());
			countBike = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			closeAll(con,null,null,ps);
		}
		return countBike;
	}

	/**
	 * 
	 * Function to delete from bike
	 * 
	 * @param vehicleId
	 *            ----vehicle id to delete
	 * @throws VehicleManagementException
	 */
	@SuppressWarnings("resource")
	public static void deleteBikeTable(int vehicleId)
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
				String query1 = "DELETE FROM Vehicle WHERE vehicle_id = "
						+ vehicleId;
				try {
					stmt = con.createStatement();
					stmt.executeUpdate(query1);
					System.out.println("Bike deleted");
				} catch (SQLException e) {
					throw new VehicleManagementException(
							"Cannot delete bike : " + e);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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

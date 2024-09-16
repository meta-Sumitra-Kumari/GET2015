import java.util.List;
import java.util.Scanner;

/**
 * @author Sumitra Main class to perform all operations
 *
 */
public class VehicleReadMain {
	public static void main(String args[]) throws VehicleManagementException {
		Scanner scan = new Scanner(System.in);

		// reading from XML
		StaxParser objSaxParser = new StaxParser();
		String filePath = "C:/Users/Sumitra/workspace/Vehicles/src/vehicle.xml";
		List<Vehicle> readVehicleFromConfig = objSaxParser.readConfig(filePath);
		System.out.println("reading value from file");
		for (Vehicle objVehicle : readVehicleFromConfig) {
			System.out.println(objVehicle);

			// create table
			VehicleJdbcHelper.createVehicleTable(objVehicle);

			// insert in table
			String str = VehicleJdbcHelper.insertInVehicleTable(objVehicle);
			System.out.println(str);
		}
		int tempVar;
		// Performing delete from tables
		do {

			System.out.println("ENTER what you want to delete");
			System.out.println("1. Delete car ");
			System.out.println("2. Delete bike ");
			System.out.println("3. Deleting all vehicles");
			int choice1;
			do {// Validation

				while (!scan.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					scan.next(); // this is important!
				}
				choice1 = scan.nextInt();
			} while (choice1 <= 0);
			switch (choice1) {

			case 1:
				System.out.println("Enter id");
				int vehicleId = scan.nextInt();
				CarJdbcHelper.deleteCarTable(vehicleId);
				break;
			case 2:

				System.out.println("Enter id");
				int vehicleId1 = scan.nextInt();
				BikeJdbcHelper.deleteBikeTable(vehicleId1);

				break;

			case 3:
				VehicleJdbcHelper.deleteAllVehicles();
				System.out.println("all vehicles are deleted ");
				break;
			default:
				System.out.println("You have entered wrong value");

			}
			System.out.println("Press 0 if you want to continue");

			do {// Validation

				while (!scan.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					scan.next(); // this is important!
				}
				tempVar = scan.nextInt();
			} while (tempVar < 0);

		} while (tempVar == 0);
		VehicleJdbcHelper.deleteAllVehicles();
		scan.close();
	}
}

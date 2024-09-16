/**
 * @author Sumitra ---Class to create vehicle
 *
 */
public class VehicleHelper {
	/**
	 * 
	 * 
	 * Function to create vehicle,car and bike object
	 * 
	 * @param vehicleType
	 *            ---Type of vehicle
	 * @param make
	 *            ---make of vehicle
	 * @param model
	 *            ---model of vehicle
	 * @return----Vehicle object
	 */
	public static Vehicle createVehicle(VehicleType vehicleType, String make,
			String model) {
		if (VehicleType.CAR.equals(vehicleType)) {
			Car car = new Car();
			car.setMake(make);
			car.setModel(model);
			return car;
		} else {

			Bike bike = new Bike();
			bike.setModel(model);
			bike.setMake(make);
			return bike;
		}
	}

}

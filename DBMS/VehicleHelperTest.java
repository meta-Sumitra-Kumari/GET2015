import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Sumitra---To test vehicle helper class
 * 
 */
public class VehicleHelperTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	// checking for car type object
	public void test() {

		assertNotNull(VehicleHelper.createVehicle(VehicleType.CAR, "Verna",
				"verna23"));

	}

	@Test
	// checking for bike type object
	public void test1() {

		assertNotNull(VehicleHelper.createVehicle(VehicleType.BIKE, "Honda",
				"honda23"));

	}

	@Test
	public void test2() {

		Set<Vehicle> vehicle = new HashSet<Vehicle>();
		Vehicle vehicle1 = VehicleHelper.createVehicle(VehicleType.BIKE,
				"Honda", "honda34");
		vehicle.add(vehicle1);
		Vehicle vehicle2 = VehicleHelper.createVehicle(VehicleType.CAR,
				"Verna", "verna104");
		vehicle.add(vehicle2);
		Vehicle vehicle3 = VehicleHelper.createVehicle(VehicleType.CAR,
				"Verna", "verna104");
		vehicle.add(vehicle3);
		assertEquals("correct", 2, vehicle.size());

	}

	@Test
	public void test3() {

		Set<Vehicle> vehicle1 = new HashSet<Vehicle>();
		Vehicle vehicle4 = VehicleHelper.createVehicle(VehicleType.BIKE,
				"Honda", "honda34");
		vehicle1.add(vehicle4);
		Vehicle vehicle5 = VehicleHelper.createVehicle(VehicleType.CAR,
				"Verna", "verna104");
		vehicle1.add(vehicle5);
		Vehicle vehicle6 = VehicleHelper.createVehicle(VehicleType.CAR, "Audi",
				"audi104");
		vehicle1.add(vehicle6);
		assertEquals("correct", 3, vehicle1.size());

	}

}

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Sumitra---To test vehicle printer
 * 
 */
public class VehicleDetailPrinterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// checking for object of bike
		String object2 = "make:Verna,model:verna23";
		String object1 = VehiclePrinter.printVehicleSpecification(VehicleHelper
				.createVehicle(VehicleType.BIKE, "Verna", "verna23"));
		System.out.println("object" + object1);
		assertEquals(object1, object2);
	}

}

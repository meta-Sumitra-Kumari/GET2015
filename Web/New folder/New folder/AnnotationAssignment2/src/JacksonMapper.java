import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author  Sumitra
 * ----Class  to map the java objects to json objects and vice-versa 
 *
 */
public class JacksonMapper {
	/**
	 * @param args
	 * Main Function
	 */
	public static void main(String args[]) {
		System.out.println("parsing the objects");
		toJSON(); // converting Java object to JSON String
		toJava(); // parsing JSON file to create Java object
	}

	/**
	 * Method to parse JSON String into Java Object using Jackson Parser.
	 *
	 */
	public static void toJava() {
		// this is the key object to convert JSON to Java
		ObjectMapper mapper = new ObjectMapper();

		try {
			File json = new File("employee1.json");

			Employee employee1 = mapper.readValue(json, Employee.class);
			System.out.println("Java object created from JSON String :");
			System.out.println(employee1.toString());
		} catch (JsonGenerationException ex) {
			ex.printStackTrace();
		} catch (JsonMappingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}

	/**
	 * Java method to convert Java Object into JSON String with help of Jackson
	 * API.
	 *
	 */
	public static void toJSON() {
		Employee employee = new Employee();

		// our bridge from Java to JSON and vice versa
		ObjectMapper mapper = new ObjectMapper();
		employee.setEmployeeName("Sumitra");
		employee.setEmployeeId(12);
		employee.setEmailId("sumitra@hmail.com");
		employee.setDateOfBirth("02-06-1992");
		employee.setDateOfJoining("03-08-2015");
		employee.setCtcPerAnnum(20000);
		try {
			File json = new File("employee.json");

			mapper.writeValue(json, employee);

			System.out
					.println("Java object converted to JSON String, written to file");
			System.out.println(mapper.writeValueAsString(employee));

		} catch (JsonGenerationException ex) {
			ex.printStackTrace();
		} catch (JsonMappingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}
	




}

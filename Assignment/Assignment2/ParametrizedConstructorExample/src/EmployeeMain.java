
/**
 * @author Sumitra
 * Class to use parameterized constructor
 *
 */
public class EmployeeMain {

	public static void main(String[] args) {
		Employee employee=new Employee();
		employee.setEmployee_id(1);
		employee.setName("arushi");
		employee.setSalary(50000);
		// setting parameters one by one can be replaced by using parameterized constructor
		Employee employee1=new Employee(2,"aj",70000);
		System.out.println(employee.toString());
		System.out.println(employee1.toString());
		
		
		
		
	}

}


/**
 * @author Sumitra
 * pojo class for employee
 *
 */
public class Employee {
	int employee_id;
	String name;
	int salary;
	/**
	 * @return the employee_id
	 */
	public int getEmployee_id() {
		return employee_id;
	}
	/**
	 * @param employee_id the employee_id to set
	 */
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int employee_id, String name, int salary) {
		
		this.employee_id = employee_id;
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
		
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", name=" + name
				+ ", salary=" + salary + "]";
	}
	
	
	
	
	

}

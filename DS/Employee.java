
/**
 * @author Sumitra
 *this is the POGO class for employee which contain all information
 */
public class Employee {
String employeeName;
int employeeId;
String employeeAdress;
public Employee(String employeeName, int employeeId, String employyeAdress) {
	super();
	this.employeeName = employeeName;
	this.employeeId = employeeId;
	this.employeeAdress = employyeAdress;
}

public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeAdress() {
	return employeeAdress;
}
public void setEmployeeAdress(String employeeAdress) {
	this.employeeAdress = employeeAdress;
}
/**
 * this method is to print whole information about employee.
 */
	public void show()
{
	System.out.println(getEmployeeId() + "  "
			+ getEmployeeName() + "  "
			+ getEmployeeAdress());
}
}

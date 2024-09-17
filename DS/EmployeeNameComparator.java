import java.util.Comparator;


/**
 * @author Sumitra
 *this is the comparator class 
 *which will compare according to name.
 */
public class EmployeeNameComparator implements Comparator<Object>{
	

	@Override
	public int compare(Object arg0, Object arg1) {
		Employee e1=(Employee) arg0;
		Employee e2=(Employee) arg1;
		return e1.getEmployeeName().compareTo(e2.getEmployeeName()); 
		
	}
}

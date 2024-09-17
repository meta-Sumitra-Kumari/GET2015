import java.util.Comparator;



/**
 * @author Sumitra
 *this is the comaprator class 
 *which will compare according to employee id.
 */
public class EmployeeIdComparator implements Comparator<Object>{
	public int compare(Object o1, Object o2) {
		Employee e1=(Employee) o1;
		Employee e2=(Employee) o2;
		if(e1.getEmployeeId()==e2.getEmployeeId())
		{
		return 0;
		}
		if(e1.getEmployeeId()>e2.getEmployeeId())
			{
			return 1;
			}
		
			return -1;
		
	}
}

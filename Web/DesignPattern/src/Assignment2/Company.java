import java.util.ArrayList;
import java.util.List;

/**
 * @author Sumitra this is comapny class to add the engineer in the list
 */
public class Company {
	static List<Engineer> frontendengineerList = new ArrayList<Engineer>();
	static List<Engineer> backendengineerList = new ArrayList<Engineer>();
	/**
	 * 
	 * @param engineer
	 *            -- object of engineer to add engineer in list
	 */
	public void add(Engineer engineer) {
		if(engineer instanceof FrontEndEngineer){
			frontendengineerList.add(engineer);
		}else
		{
			backendengineerList.add(engineer);
		}
		
	}

	/**
	 * 
	 * @return list of engineer
	 */
	public List<Engineer> getFrontEndEngineer() {
		return frontendengineerList;
	}
	public List<Engineer> getBackEndEngineer() {
		return backendengineerList;
	}
}

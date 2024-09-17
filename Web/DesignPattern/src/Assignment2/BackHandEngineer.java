/**
 * @author Sumitra this class is backEndEngineer and implementing interface
 *         engineer and defining all the method and setting role of engineer as
 *         backendengineer
 */
public class BackEndEngineer implements Engineer {

	String name;
	String role;

	/**
	 * return name of engineer
	 */
	public String getName() {

		return name;
	}

	/**
	 * return role of engineer
	 */
	public String getRole() {

		return role;
	}

	/**
	 * set name of engineer
	 */
	public void setName(String name) {
		this.name = name;

	}

	/**
	 * set role of engineer as backendengineer
	 */
	public void setRole() {
		this.role = Role.BackEndEngineer.toString();

	}

}

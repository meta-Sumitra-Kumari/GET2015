/**
 * @author Sumitra --this class is frontEndEngineer implementing Engineer and
 *         defining all the methods and it set the role of engineer as
 *         frontendengineer
 */
public class FrontEndEngineer implements Engineer {
	String name;
	String role;

	/*
	 * return --name of engineer
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

	/*
	 * set name of engineer
	 */
	public void setName(String name) {
		this.name = name;

	}

	/**
	 * set role of engineer as frontendengineer
	 */
	public void setRole() {
		this.role = Role.FrontEndEngineer.toString();

	}

}

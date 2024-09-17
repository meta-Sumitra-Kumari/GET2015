import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sumitra this is the factory class to implement the factory method
 */
public class Factory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		String role;
		char choice;
		Company company = new Company();
		// getting instance of company

		do {
			System.out.println("1 ->To add Engineer");
			System.out.println("2 ->to print list of Front end Engineer");

			System.out.println("3 ->to print list of Back end Engineer");

			int doChoice;
			do {// Validation

				System.out.println("enter integer value");
				while (!scanner.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					scanner.next();
				}
				doChoice = scanner.nextInt();
			} while (doChoice < 0);
			Engineer engineer = null;
			switch (doChoice) {
			case 1:
				System.out.println("enter name");
				name = scanner.next();
				System.out.println("enter role of engineer");
				role = scanner.next();
				// according to role object of engineer is instantiated.
				if (role.equalsIgnoreCase(Role.FrontEndEngineer.toString())) {
					// object of front end engineer is created
					engineer = new FrontEndEngineer();
				} else if (role.equalsIgnoreCase(Role.BackEndEngineer
						.toString())) {
					// object of back end engineer is created
					engineer = new BackEndEngineer();
				} else {
					// otherwise no object is created
					System.out.println("enter valid role for engineer");
					break;
				}
				engineer.setName(name);
				engineer.setRole();
				company.add(engineer);
				break;
			case 2:
				// to print the list of front end engineer
				List<Engineer> engineerList = company.getFrontEndEngineer();
				Iterator<Engineer> itr = engineerList.iterator();
				int i = 1;
				while (itr.hasNext()) {
					Engineer engineer2 = itr.next();
					
						System.out.println("Id ->" + i++);
						System.out.println("Name ->" + engineer2.getName());
						System.out.println("Role ->" + engineer2.getRole());
						System.out.println("--------------");
					
				}
				// if no front end engineer is available
				if (engineerList.isEmpty()) {
					System.out.println("No FrontEndEngineer Available");
					System.out.println("----------");
				}
				break;
			case 3:
				// to print the list of back end engineer
				List<Engineer> engineerList1 = company.getBackEndEngineer();
				Iterator<Engineer> itr1 = engineerList1.iterator();
				int id = 1;
				while (itr1.hasNext()) {
					Engineer engineer2 = itr1.next();
					
						System.out.println("ID ->" + id++);
						System.out.println("Name ->" + engineer2.getName());
						System.out.println("Role ->" + engineer2.getRole());
						System.out.println("-------------");
					
				}
				// if no back end engineer is available
				if (engineerList1.isEmpty()) {
					System.out.println("No BackEndEngineer Available");
					System.out.println("--------------");
				}
				break;
			default:
				System.out.println("Entered wrong chocie");
			}
			System.out.println("want to continue(y/n)");
			choice = scanner.next().charAt(0);
		} while (choice == 'y' || choice == 'Y');

		scanner.close();
	}

}

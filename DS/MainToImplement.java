import java.util.ArrayList;
import java.util.Collections;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
enum condition{
	add,sortById,sortByName;
}

/**
 * @author Sumitra
 *Create a custom class say Employee with fields as empId, name and address. Create a collection of this employee class. EmpId of the class with be unique.
- Perform sorting on this collection i.e natural order.
- Perform sorting on this collection based on the employee Name. (ascending order by Employee Name)
- Create a collection for these employees to avoid any duplicate employee entry. (Employee having same empId will consider as duplicate. If one try to add the same employe again it should avoid that.)
Note: Add at least 5 employees to the collection. Create a separate programme for the above three points.

 */
public class MainToImplement {

	public static <T> void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);
		Employee e1;
		Character choice = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		Character choose = null;
		do {
			System.out.println("enter 1 to add");
			System.out.println("enter 2 to sort by employee Id");
			System.out.println("enter 3 to sort by name");
			System.out.println("enter your choice");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				//to add employee in list
				do {
					int inserted = 0;
					System.out.println("enter name");
					String name = scanner.next();
					System.out.println("enter employee Id");
					int employeeId = scanner.nextInt();
					System.out.println("enter address");
					String employeeAddress = scanner.next();
					e1 = new Employee(name, employeeId, employeeAddress);
					Iterator<Employee> itr = employeeList.iterator();
					while (itr.hasNext()) {
						Employee e2 = itr.next();
						if (e2.getEmployeeId() == e1.getEmployeeId()) {
							inserted = 1;
							System.out.println("already exist in the list");
						}
					}
					if (inserted != 1) {
						employeeList.add(e1);
					}
					System.out.println("do you want to continue");
					choice = scanner.next().charAt(0);

				} while (choice == 'Y' || choice == 'y');
				break;
			case 2:
				//to sort by employeeId

				Collections.sort(employeeList, new EmployeeIdComparator());

				Iterator<Employee> itr = employeeList.iterator();
				while (itr.hasNext()) {
					Employee e2 = itr.next();
					e2.show();
				}
				break;
			case 3:
				//to sort by employeeName
				Collections.sort(employeeList, new EmployeeNameComparator());
				Iterator<Employee> itra = employeeList.iterator();
				while (itra.hasNext()) {
					Employee e2 = itra.next();
					e2.show();
				}
				break;
			default:
				System.out.println("entered wrong choice");
				break;
			}
			System.out.println("Do you want to continue");
			System.out.println("enter y to contiue");
			choose = scanner.next().charAt(0);
		} while (choose == 'Y' || choose == 'y');
		scanner.close();
	}
}

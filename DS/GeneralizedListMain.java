import java.util.Scanner;

/**
 * Main Class for generalized list
 * 
 * @author Sumitra
 *
 */
public class GeneralizedListMain {

	public static void main(String[] args) {

		System.out.println("Enter expression \n");
		Scanner scan = new Scanner(System.in);
		String inputList = scan.next();
		int choice;
		char mainChoice;
		while (Validation.isExpression(inputList) != true) {
			System.out.println("Enter Valid Expression");

			inputList = scan.next();
		}
		GeneralizedList generalizedList = new GeneralizedList(inputList);

		do {// Menu

			System.out.println("Menu :");
			System.out.println("1.Enter to Display the linked list");
			System.out.println("2.To calculate Sum of the list");
			System.out.println("3.To calculate Maximum from list");
			System.out.println("4.To Search an element");

			choice = Validation.checkingChoice();

			switch (choice) {
			case 1:// to display list
				System.out.println(generalizedList);
				break;
			case 2:
				// sum of list
				System.out.println("Sum of list is : "
						+ generalizedList.calculateSum());

				break;
			case 3:
				// Maximum from expression
				System.out.println("Maximum Element from list :"
						+ generalizedList.calculateMax());
				break;
			case 4:
				// Searching value from expression
				System.out.println("Enter value to search \n");

				System.out.println("Value Found :"
						+ generalizedList.searchValue(Validation
								.checkingChoice()));
				break;

			default:
				System.out.println("Enter Correct Choice");
			}
			mainChoice = Validation.checkingString();
		} while (mainChoice == 'Y');
		scan.close();

	}

}

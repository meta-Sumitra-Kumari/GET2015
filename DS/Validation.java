import java.util.Scanner;

/**
 * Utility Class to validate expression
 * 
 * @author Sumitra
 *
 */
public class Validation {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Method to validate expression
	 * 
	 * @param expression
	 *            : expression to validate
	 * @return true if validated, false otherwise
	 */
	public static boolean isExpression(String expression) {
		if (expression == null)
			return false;
		char[] expressionArray = expression.toCharArray();
		int length = expressionArray.length;
		int openCount = 0, closeCount = 0;

		// checking for starting and ending brackets
		if (expressionArray[length - 1] == ')') {
			if (expressionArray[0] != '(') {

				return false;
			}
		}

		if (expressionArray[0] == '(') {
			if (expressionArray[length - 1] != ')') {
				return false;
			}
		}

		if (expressionArray[0] != '(') {
			return false;
		}
		// checking if list is empty
		if (length <= 2) {
			System.out.println("list can't be empty");
			return false;

		}

		/* validation for checking if element is not separated by"," or not */
		for (int i = 0; i < (length - 1); i++) {

			if ((Character.isDigit(expressionArray[i]))) {
				if (expressionArray[i + 1] == '(') {
					return false;
				}
			}
			if (expressionArray[i] == ')') {
				if (expressionArray[i + 1] == '(') {
					return false;
				}
			}
			if (expressionArray[i] == ',') {
				if (expressionArray[i + 1] == ',') {
					return false;
				}
			}

		}

		// checking for specific symbols to be there
		for (char c : expressionArray) {
			if (!Character.isDigit(c) && (c != ',') && (c != '(') && (c != ')')) {
				return false;
			}
		}

		/* Validation for acceptable symbols number or open and closed braces */
		for (char c : expressionArray) {
			if ((Character.isDigit(c)) && (c == ',')) {
				continue;
			} else {
				if (c == '(')
					openCount++;
				else if (c == ')')
					closeCount++;
			}
		}
		if (openCount == closeCount) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * checking input is integer or not
	 * 
	 * @param value
	 *            :value to get
	 * @return :an integer value
	 */
	public static int checkingChoice() {
		int value;
		do {// Validation
			while (!scanner.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				scanner.next(); // this is important!
			}
			value = scanner.nextInt();
		} while (value < 0);
		return value;
	}

	/**
	 * checking input is String or not
	 * 
	 * @param value
	 *            :value to get
	 * @return :return a char value
	 */
	public static char checkingString() {
		char value;
		do {// validation
			System.out.println("Do you want to continue?(Y/N)");
			while (!scanner.hasNext()) {
				System.out.println("That's not a character!");
				scanner.next(); // this is important!

			}
			value = scanner.next().toUpperCase().charAt(0);
			if (value == 'N')
				break;
		} while (value != 'Y');
		return value;
	}

}

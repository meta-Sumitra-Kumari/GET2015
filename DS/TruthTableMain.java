

import java.util.Scanner;

/**
 * @author Sumitra
 *
 */
public class TruthTableMain {

	public static void main(String[] args) {
		String infixExpression = "";
		Scanner sc = new Scanner(System.in);
		do {
			// expression must be in proper infix form
			System.out
					.println("Enter valid boolean expression in infix form : ");
			infixExpression = sc.next();
		} while (!ValidationTable.isExpression(infixExpression));

		TruthTableGenerator tableGenerator = new TruthTableGenerator();
		String postfixString = tableGenerator
				.infixToPostfixConversion(infixExpression);
		// converting expression to post fix form
		String string = tableGenerator.getVariablesInExpresssion(postfixString);
		// getting unique operands

		System.out.println("\nTruth Table : ");
		tableGenerator.generateTruthTable(postfixString, string);
		// creating truth table
		sc.close();
	}
}

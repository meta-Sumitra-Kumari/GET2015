

import java.util.Stack;

/**
 * @author Sumitra
 *
 */
public class TruthTableGenerator {
	private Stack<Character> infix;

	/**
	 * Constructor calling
	 */
	public TruthTableGenerator() {
		infix = new Stack<Character>();
	}

	/**
	 * Function to check precedence of operator and setting precedence of
	 * operands as 0
	 * 
	 * @param charInfix
	 *            :symbol
	 * @return :precedence
	 */
	public int checkPrecedence(char charInfix) {
		int precedence = 0;
		switch (charInfix) {
		case '~':
			precedence = 5;
			break;

		case '&':
			precedence = 4;
			break;

		case '|':
			precedence = 3;
			break;

		case '(':
			precedence = 2;
			break;

		case ')':
			precedence = 1;
			break;

		default:
			precedence = 0;
		}
		return precedence;
	}

	/**
	 * Function to convert expression from infix to postfix
	 * 
	 * @param booleanExpression
	 *            :expression to be evaluated
	 * @return :return an infix expression
	 */
	public String infixToPostfixConversion(String booleanExpression) {
		int precedence;
		String strPostfix = "";
		Character item;
		for (int index = 0; index < booleanExpression.length(); index++) {
			char charInfix = booleanExpression.charAt(index);

			precedence = checkPrecedence(charInfix);// checking precedence

			if (precedence == 0) { // if item in input string is character
				strPostfix = strPostfix + charInfix;
			} else if (precedence == 2) { // if item is = '(' , push it
				infix.push(charInfix);
			} else if (precedence == 1) // if item is = ')' , pop items till '('
										// comes, and pop '(' also
			{
				while (infix.peek() != '(') {
					item = infix.pop();
					strPostfix = strPostfix.concat(item.toString());
				}
				item = infix.pop();
			} else {// for operator checking precedence
				infixToPostfix(precedence, charInfix);
			}
		}

		// pops operators left in stack
		while (infix.isEmpty() == false) {
			strPostfix += infix.pop();
		}
		return strPostfix;

	}

	/**
	 * Function to put operands in infix expression to post fix as per their
	 * priority
	 * 
	 * @param precedence
	 *            :precedence of character
	 * @param charInfix
	 *            :character to be checked
	 * @return :postfix string
	 */
	private String infixToPostfix(int precedence, char charInfix) {
		String strPostfix = "";
		if (infix.isEmpty() == false) {
			while (infix.isEmpty() == false) {
				if (infix.peek().equals("(") || infix.peek().equals(")")) {
				} // do nothing
				else {
					// if incoming char has lower precedence then char at top of
					// stack, then pop element from stack
					if (checkPrecedence(infix.peek().toString().charAt(0)) >= precedence) {
						Character item = infix.pop();
						strPostfix = strPostfix.concat(item.toString());
					} else
						break;
				}
			}
			infix.push(charInfix); // push incoming char, after items in stack
									// of greater precedence were popped
		} else {
			// if stack is empty, push item in it
			infix.push(charInfix);
		}
		return strPostfix;
	}

	/**
	 * Function to get all unique variables in expression
	 * 
	 * @param postfixExpression
	 *            :postfix expression
	 * @return :string of unique variables
	 */
	public String getVariablesInExpresssion(String postfixExpression) {
		String str = "";
		for (int index = 0; index < postfixExpression.length(); index++) {
			if (postfixExpression.charAt(index) != '&'
					&& postfixExpression.charAt(index) != '|'
					&& postfixExpression.charAt(index) != '~') {

				if (!str.contains(postfixExpression.charAt(index) + "")) {
					str += postfixExpression.charAt(index);
				}
			}
		}
		return str;
	}

	/**
	 * Function to evaluates post fix Expression and as per it,setting values in
	 * truth table
	 * 
	 * @param postfixExpression
	 *            :post fix expression
	 * @param str
	 *            :variables String
	 */
	public void generateTruthTable(String postfixExpression, String str) {
		boolean bool[] = new boolean[str.length()], result, itemFirst, itemSecond, answer;
		int position;
		char charPostfix;
		Stack<Boolean> postfix = null;
		// Variables of expression
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) + "\t");
		}
		System.out.println("Output");
		// creating truth table
		for (int i = 0; i < (int) Math.pow(2, str.length()); i++) {
			for (int j = str.length() - 1; j >= 0; j--) {
				bool[j] = ((i / (int) Math.pow(2, j)) % 2) != 0;
				System.out.print(bool[j] + "\t");
			}

			postfix = new Stack<Boolean>();
			result = false;
			for (int index = 0; index < postfixExpression.length(); index++) {
				charPostfix = postfixExpression.charAt(index);
				if (charPostfix != '&' && charPostfix != '|'
						&& charPostfix != '~') {// for variables in expression
					position = str.indexOf(charPostfix);
					postfix.push(bool[str.length() - 1 - position]);
				} else {// for operators
					itemFirst = postfix.pop();
					itemSecond = false;
					if (charPostfix != '~') {// if not ~ operator then get
												// second element
						itemSecond = postfix.pop();
					}
					switch (charPostfix) {
					case '&':// for and operation
						result = itemFirst & itemSecond;
						break;
					case '|':// for or operation
						result = itemFirst | itemSecond;
						break;
					case '~':// for not operation
						result = !itemFirst;
						break;
					}
					postfix.push(result);
				}

			}
			answer = postfix.pop();// getting answer of expression
			System.out.print(answer + "\n");
		}
	}

}

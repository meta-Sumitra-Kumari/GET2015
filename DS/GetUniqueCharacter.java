import java.util.Scanner;

/**
 * @author Sumitra Write a method that takes a string and returns the number of
 *         unique characters in the string. It is expected that a string with
 *         the same character sequence may be passed several times to the
 *         method. Since the counting operation can be time consuming, the
 *         methods should cache the results, so that when the methods is given a
 *         string previously encountered, it will simply retrieve the stored
 *         result. Use collection and maps where appropriate.
 */
public class GetUniqueCharacter {
	public static void main(String arg[]) {
		UniqueCharacter unique = new UniqueCharacter();
		Scanner scanner = new Scanner(System.in);
		Character choice = null;
		do {
			System.out.println("enter the string");
			String input = scanner.nextLine();
			input = input.replaceAll("\\s", "");
			int size = unique.checkUnique(input);
			System.out.println(size);
			System.out.println("want to continue press y");
			choice = scanner.next().charAt(0);
			scanner.nextLine();
		} while (choice == 'Y' || choice == 'y');
		scanner.close();
	}
}

import java.util.Scanner;

/**
 * @author Sumitra Write a program to print disorderly provided role numbers of
 *         n students in ascending series using tree sort?
 */
public class TakeInput {
	public static void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);
		BinarySearchTreeForStudent binary = new BinarySearchTreeForStudent();
		Character choice = null;
		do {
			System.out.println("1. to add");
			System.out.println("2 to show");
			System.out.println("Choose");
			int choose = scanner.nextInt();
			Character choiceAgain = null;
			switch (choose) {
			case 1:
				do {
					System.out.println("enter name");
					String name = scanner.next();
					System.out.println("enter roll no");
					int rollNo = scanner.nextInt();
					Student student = new Student(name, rollNo);
					binary.insert(student);
					System.out.println("want to add more");
					System.out.println("press Y");
					choiceAgain = scanner.next().charAt(0);
				} while (choiceAgain == 'y' || choiceAgain == 'Y');
				break;
			case 2:
				System.out.println(binary.inorder());
				break;
			default:
				System.out.println("entered wrong choice");
				break;
			}
			System.out.println("Do you want to continue");
			System.out.println("press Y");
			choice = scanner.next().charAt(0);
		} while (choice == 'Y' || choice == 'y');
		scanner.close();
	}
}

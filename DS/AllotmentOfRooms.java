import java.util.Scanner;

/**
 * @author Sumitra
 *Write a program to allot rooms in guest house. rooms can be identified by their room number and allotment is based age of Guest. (Use Hash Table techniques for allocation)
	Given : There are N numbers of rooms and K is the count of guests, where N is a prime number and N > K
 */
public class AllotmentOfRooms {

	/**
	 * 
	 */	static Scanner scanner = new Scanner(System.in);
	 static HashMapOperations hasmap = new HashMapOperations();
	public static void main(String[] args) {
		
	
		char ch;
		do{
		System.out.println("\nHash Table Operations\n");
		System.out.println("1. book room ");
		System.out.println("2. remove");
		System.out.println("3. room status");
		System.out.println("4. clear");
		System.out.println("5. status of all rooms");
		

		int choice;
		do {// Validation

			while (!scanner.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				scanner.next(); // this is important!
			}
			choice = scanner.nextInt();
		} while (choice <= 0);


		switch (choice) {
		case 1:

			bookRoom();
			
			break;
		case 2:
			remove();
			break;
		case 3:
			roomStatus();
			break;
		case 4:
			 hasmap.clear();
			System.out.println("Hash Table Cleared\n");
			break;
		case 5:
			hasmap.display();
			break;
		default:
			System.out.println("Wrong Entry \n ");
			break;
		}
		 System.out.println("\nDo you want to continue (Type y or n) \n");
         ch = scanner.next().charAt(0);                        
     } while (ch == 'Y'|| ch == 'y');  

		scanner.close();
	}
	static void bookRoom()
	{
		System.out.println("enter your name");

		String name = scanner.next();
		System.out.println("Enter your age");
		int age;
		do {// Validation

			while (!scanner.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				scanner.next(); // this is important!
			}
			age = scanner.nextInt();
		} while (age <= 0);
		hasmap.put(age, name);
	}
	static void remove()
	{
		System.out.println("Enter room to make free");
		int room;
		do {// Validation

			while (!scanner.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				scanner.next(); // this is important!
			}
			room = scanner.nextInt();
		} while (room < 0);
		hasmap.deleteRoom( room);
		System.out.println("Room is free now");
	}
	static void roomStatus()
	{
		System.out.println("Enter room  to check its details");
		int check_Room;
		do {// Validation

			while (!scanner.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				scanner.next(); // this is important!
			}
			check_Room = scanner.nextInt();
		} while (check_Room <= 0);
		hasmap.get(check_Room);
	}

}

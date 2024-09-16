import java.util.Scanner;

/**
 * @author Sumitra Write a program the binary search function and its loop
 *         invariants in a way so that it will always find the leftmost
 *         occurrence of x in the array in case the occurrences are not unique .
 */
public class BinarySearch {

	static int index = -1;
	static int size;

	public static void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter size");
		size = scanner.nextInt();
		int a[] = new int[size];
		System.out.println("enter array");
		for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextInt();
		}
		System.out.println("1. Left most occurance");
		System.out.println("2. for right most occurance");
		System.out.println("choose ");
		int check = scanner.nextInt();
		System.out.println("enter element you want to search");
		int search = scanner.nextInt();

		System.out.println("index is 	->"
				+ binarySearch(search, 0, size - 1, check, a));

		scanner.close();
	}

	public static int binarySearch(int search, int min, int max, int check,
			int a[]) {
		if (min <= max) {

			int mid = (min + max) / 2;
			if (a[mid] == search) {
				// if the element is present in mid.
				index = mid;
				if (check == 1) {
					// check whether they are present on left side.

					left(search, min, max, mid, check, a);
				} else {
					// to check whether the element is present in right side.
					right(search, min, max, mid, check, a);
				}

				return index;
			} else

			if (a[mid] > search) {
				// if the element is smaller than mid then traverse in left hand
				// side
				binarySearch(search, 0, mid, check, a);
			} else {
				// if the element is greater then mid then traverse in right
				// hand side.
				binarySearch(search, mid + 1, max, check, a);
			}
		}
		return index;

	}

	// to check the element in left most side.
	public static void left(int search, int min, int max, int mid, int check,
			int a[]) {
		if (a[0] == search) {
			index = 0;
		} else if (a[mid - 1] == search && min != max) {
			index = -1;
			binarySearch(search, 0, mid, check, a);
		}
	}

	// to check the element in right most side.
	public static void right(int search, int min, int max, int mid, int check,
			int a[]) {
		if (a[max] == search) {
			index = max;
		} else if (a[mid + 1] == search && min != max && mid + 1 <= max) {
			index = -1;
			binarySearch(search, mid + 1, max, check, a);
		}

	}
}

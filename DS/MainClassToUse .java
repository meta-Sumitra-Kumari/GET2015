package Sorting;

import java.util.Scanner;

/**
 * @author Sumitra Write a sorting system, which takes input from user and
 *         provide a sorted list. Here User could choose if he want to go with
 *         Comparison Sorting Or Linear Sorting. Given Conditions: 1 - For
 *         comparison sorting system will use Bubble Sort or Quick Sort
 *         techniques (When less number of inputs (input elements <= 10) use
 *         Bubble Sort else Quicksort) 2 - For linear sorting system will use
 *         Counting Sort or Radix Sort techniques (When large inputs(more than 2
 *         digit) use Radix Sort else Counting Sort)
 * 
 *         (System should be intelligent to pick suitable techniques for sort as
 *         per provided input )
 * 
 *         Expected output : System has used XYZ sorting technique and sorted
 *         list as below : n , n+1, ........... K -1, K
 */
public class MainClassToUse {
	public static void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);
		Character choose = 0;
		do {
			System.out.println("enter size");
			int size = scanner.nextInt();
			int a[] = new int[size];
			System.out.println("enter element");
			for (int i = 0; i < a.length; i++) {
				a[i] = scanner.nextInt();
			}
			System.out.println("choose the type of sort");
			System.out.println("1. for Comparison sort");
			System.out.println("2. for linear sort");
			System.out.println("enter choice");
			int choice = scanner.nextInt();
			if (choice == 1) {
				// if comparison sort is selected.
				if (a.length < 10) {
					BubbleSort bubble = new BubbleSort();
					bubble.bubbleSort(a);
				} else {
					QuickSort quick = new QuickSort();
					quick.sort(a, 0, size - 1);
				}
			} else if (choice == 2) {
				// if linear sort is selected.
				int max = a[0];
				for (int i = 1; i < a.length; i++) {
					if (max < a[i]) {
						max = a[i];
					}
				}
				int count = 0;
				while (max != 0) {
					max = max / 10;
					count++;
				}
				if (count <= 2) {
					CountingSort counting = new CountingSort();
					counting.countingSort(a);
				} else {
					RadixSort radix = new RadixSort();
					radix.radixSort(a);
				}
			} else {
				System.out.println("wrong input");
			}
			System.out.println("output is");
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}
			System.out.println("Do you want to continue(y/n)");
			choose = scanner.next().charAt(0);
		} while (choose == 'Y' || choose == 'y');
		scanner.close();
	}
}

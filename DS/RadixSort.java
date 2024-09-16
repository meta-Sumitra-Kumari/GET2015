package Sorting;

/**
 * @author Sumitra this is to implement radix sort. this is used when value of
 *         element is greater than 100.
 */
public class RadixSort {

	public void radixSort(int a[]) {
		int max = a[0];

		for (int i = 1; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		int divide = 10;

		int newA[] = new int[a.length];
		int copy[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			copy[i] = a[i];
			// System.out.println(copy[i]);
		}
		while (max != 0) {
			int k = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < a.length; j++) {
					if (a[j] % 10 == i) {
						newA[k] = copy[j];
						k++;

					}
				}
			}
			for (int i = 0; i < a.length; i++) {
				copy[i] = newA[i];
				a[i] = newA[i] / divide;

			}
			max = max / 10;
			divide = divide * 10;

		}
		for (int i = 0; i < a.length; i++) {
			a[i] = newA[i];
		}
	}
}

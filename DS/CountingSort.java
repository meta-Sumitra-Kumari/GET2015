package Sorting;

/**
 * @author Sumitra this class is to implement counting sort. this will be done
 *         in linear sorting when value of element is not greater than 100.
 *
 */
public class CountingSort {
	/**
	 * 
	 * @param a
	 *            array to sort .
	 */
	public void countingSort(int a[]) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		int newA[] = new int[max + 1];
		for (int i = 0; i < newA.length; i++) {
			newA[i] = 0;
		}
		for (int i = 1; i < newA.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i == a[j]) {
					newA[i] += 1;
				}
			}
		}

		int j = 0;
		for (int i = 1; i < newA.length; i++) {

			while (newA[i] != 0) {
				a[j] = i;
				newA[i] -= 1;
				j++;
			}

		}
	}
}

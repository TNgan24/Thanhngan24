package lab4;

public class Task1 {

	public static void selectionSort(int[] array) {
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] > array[maxIndex]) {

					maxIndex = j;

				}

			}
			int temp = array[maxIndex];
			array[maxIndex] = array[i];
			array[i] = temp;

		}
	}

	public static void bubbleSort(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

				}
			}

		}
	}

	public static void insertionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;

		}

	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public static void main(String[] args) {
		int[] array = { 64, 34, 25, 12, 22, 11, 90 };

		System.out.println("Original array:");
		printArray(array);

		selectionSort(array);

		System.out.println("\nArray after selection sort (descending order):");
		printArray(array);

		// bubbleSort;

		bubbleSort(array);
		System.out.println("\nArray after bubble sort (descending order):");
		printArray(array);

		// insertionSort

		insertionSort(array);
		System.out.println("\nArray after insertionSort  (descending order):");
		printArray(array);

	}
}

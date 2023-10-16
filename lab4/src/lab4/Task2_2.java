package lab4;

import java.util.Arrays;

public class Task2_2 {

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int start, int end) {
		if (start < end) {

			int pivotIndex = getPivot_MedianOfThree(array, start, end);

			int partitionIndex = partition(array, start, end, pivotIndex);

			quickSort(array, start, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, end);
		}
	}

	private static int partition(int[] array, int start, int end, int pivotIndex) {

		swap(array, pivotIndex, end);

		int pivot = array[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (array[j] <= pivot) {
				i++;
				swap(array, i, j);
			}
		}

		swap(array, i + 1, end);

		return i + 1;
	}

	// chọn phẩn tử trên điểm trung bình
	private static int getPivot_MedianOfThree(int[] array, int start, int end) {
		int mid = start + (end - start) / 2;

		if (array[start] > array[mid]) {
			swap(array, start, mid);
		}
		if (array[start] > array[end]) {
			swap(array, start, end);
		}
		if (array[mid] > array[end]) {
			swap(array, mid, end);
		}

		// đặt đường trung tuyến ở cuối để làm trục
		swap(array, mid, end - 1);

		return end - 1;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 7, 2, 9, 1, 5, 6 };
		quickSort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
	}
}
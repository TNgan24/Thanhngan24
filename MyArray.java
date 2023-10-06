package lab3;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i; // target found at current index
			}
		}
		return -1; // target not found in the array
	}

	public int recursiveLinearSearch(int target) {

		return recursiveLinearSearch(target, 0);
	}

	private int recursiveLinearSearch(int target, int index) {
		if (index >= array.length) {
			return -1; // target not found in the array
		} else if (array[index] == target) {
			return index; // target found at current index
		} else {
			return recursiveLinearSearch(target, index + 1); // search in the rest of the array
		}

	}

	public static int iterativeBinarySearch(int target, int[] array) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid;
			}

			if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	public static int recursiveBinarySearch(int target, int[] array) {
		return recursiveBinarySearchHelper(target, array, 0, array.length - 1);
	}

	private static int recursiveBinarySearchHelper(int target, int[] array, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = left + (right - left) / 2;

		if (array[mid] == target) {
			return mid;
		} else if (array[mid] < target) {
			return recursiveBinarySearchHelper(target, array, mid + 1, right);
		} else {
			return recursiveBinarySearchHelper(target, array, left, mid - 1);
		}
	}

	public int BinarySearchHelper(int target, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (target == array[mid])
			return mid;
		if (target < array[mid]) {
			return BinarySearchHelper(target, low, mid - 1);
		} else {
			return BinarySearchHelper(target, mid + 1, high);
		}
	}

	// descending order array
	public int recursiveBinarySearchDescendingOrder(int target) {
		return BinarySearchDescendingOrderHelper(target, 0, array.length - 1);
	}

	public int BinarySearchDescendingOrderHelper(int target, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (target == array[mid])
			return mid;
		if (target > array[mid]) {
			return BinarySearchDescendingOrderHelper(target, low, mid - 1);
		} else {
			return BinarySearchDescendingOrderHelper(target, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int target = 20;
		int target1 = 45;
		int target2 = 15;

		MyArray myArray = new MyArray(array);

		int index1 = myArray.iterativeLinearSearch(target1);
		System.out.println("Index of " + target1 + ": " + index1);

		int index3 = myArray.iterativeLinearSearch(target2);
		System.out.println("Index of " + target2 + ": " + index3);

		int iterativeResult = iterativeBinarySearch(target, array);
		System.out.println("Iterative Binary Search Result: " + iterativeResult);

		int recursiveResult = recursiveBinarySearch(target, array);
		System.out.println("Recursive Binary Search Result: " + recursiveResult);
	}
}

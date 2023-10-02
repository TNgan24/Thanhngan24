package lab2;

import java.util.Arrays;

public class Task1_3 {

	public static int[] generateNextRow(int[] preRow) {
		int[] result = new int[preRow.length + 1];
		result[0] = 1;
		result[result.length - 1] = 1;
		for (int i = 1; i < result.length - 1; i++) {
			result[i] = preRow[i - 1] + preRow[i];

		}
		return result;
	}

	public static int[] getPascalTriangle(int n) {
		if (n == 1)
			return new int[] { 1 };
		else
			for (int i = 0; i < n; i++) {

			}

		return null;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1 };
		int[] arr1 = new int[] { 1, 2, 1 };
		System.out.println(Arrays.toString(generateNextRow(arr)));
		System.out.println(Arrays.toString(generateNextRow(arr1)));
	}

}

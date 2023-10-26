package lab5;

public class Task1_3 {
	public static int[][] multiply(int[][] a, int[][] b) {
		int rowsA = a.length;
		int columnsA = a[0].length;
		int columnsB = b[0].length;

		if (columnsA!= b.length) {
			throw new IllegalArgumentException(
					"Number of columns in the first matrix must be equal to the number of rows in the second matrix");
		}

		int[][] result = new int[rowsA][columnsB];

		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < columnsB; j++) {
				for (int k = 0; k < columnsA; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] matrixA = { { 6, 6, 10 }, { 4, 7, 6 } };//2x3 matrix
		int[][] matrixB = { { 2, 3}, { 3, 6},{6,7}};//3x2 matrix

		int[][] result = multiply(matrixA, matrixB);

		// Displaying the result
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}

			System.out.println();
		}

	}

}

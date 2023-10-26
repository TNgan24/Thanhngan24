package lab5;

public class Task1_2 {
	public static int [][]subtract(int[][]a, int [][]b ){
		int rows = a.length;
		int columns = a[0].length;

		// kiểm tra ma trận có cùng kích thước không
		if (a.length != b.length || a[0].length != b[0].length) {
			throw new IllegalArgumentException("Matrices must have the same dimensions");
		}

		int[][] result = new int[rows][columns];

		// trừ ma trận
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}
		return result;
		
	}
	public static void main(String[] args) {
		int[][] matrixA = { { 7, 6, 10 }, { 4, 7, 6 } };
		int[][] matrixB =  {{ 2, 3, 7 },{3,6,2}};

		int[][] result = subtract(matrixA, matrixB);

		// Displaying the result
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}

			System.out.println();
		}
	}

}

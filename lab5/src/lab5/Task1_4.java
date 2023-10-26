package lab5;

public class Task1_4 {
	

	    public static int[][] transpose(int[][] a) {
	        int rows = a.length;
	        int columns = a[0].length;

	        int[][] result = new int[columns][rows];

	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                result[j][i] = a[i][j];
	            }
	        }

	        return result;
	    }

	    public static void printMatrix(int[][] matrix) {
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                System.out.print(matrix[i][j] + " ");
	            }
	            System.out.println();
	        }
	        
	    }

	    public static void main(String[] args) {
	        int[][] originalMatrix = {
	                {1, 2, 3},
	                {4, 5, 6},
	                {7, 8, 9}
	        };

	        int[][] transposedMatrix = transpose(originalMatrix);

	        // Display the original matrix
	        System.out.println("Original Matrix:");
	        printMatrix(originalMatrix);

	        // Display the transposed matrix
	        System.out.println("\nTransposed Matrix:");
	        printMatrix(transposedMatrix);
	    }
	}




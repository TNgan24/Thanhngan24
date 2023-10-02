package lab2;

public class Task1_4 {
	public static void solveTowersOfHanoi(int dick, char source, char dest, char spare) {
		if (dick == 1) {
			System.out.println("Move disk 1 from " + source + " to " + spare);
		} else {
			solveTowersOfHanoi(dick - 1, source, spare, dest);
			System.out.println("Move disk " + dick + " from " + source + " to " + spare);
			solveTowersOfHanoi(dick - 1, dest, source, spare);
		}
	}

	public static void main(String[] args) {
		int numDisks = 3; 
		char source = 'A'; 
		char dest = 'B'; 
		char spare = 'C';
		solveTowersOfHanoi(numDisks, source, dest, spare);
	}

}

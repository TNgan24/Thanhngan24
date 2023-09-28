package lab1;

import java.util.Arrays;

public class MyArray {

	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// Method mirror that outputs the contents of an array in a
	// reverse order like a mirror
	// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int[] mirroredArray = new int[array.length * 2];
		int index = 0;

		for (int i = 0; i < array.length; i++) {
			mirroredArray[index] = array[i];
			mirroredArray[mirroredArray.length - 1 - index] = array[i];
			index++;

		}

		return mirroredArray;

	}

	// removes all duplicate elements from an array and returns a
	// new array
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8
	public int[] removeDuplicates() {
		Arrays.sort(array);
		int countElement = 0;
		int[] arrNewDuplicate = new int[array.length - 3];
		arrNewDuplicate[0] = array[0];

		for (int i = 1; i < array.length; i++) {
			boolean isDuplicate = false;
			for (int j=1;j<countElement;j++) {
				if (arrNewDuplicate[j]==array[i]) {
					isDuplicate=true;
					break;
				}
			}
			if(!isDuplicate) {
				arrNewDuplicate[countElement++]= array[i];
			}
		}
		return arrNewDuplicate;
		
	}
	
	

	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };
		MyArray at = new MyArray(array);
		int[] mirror = at.mirror();
		System.out.println(Arrays.toString(mirror));

		int [] arrayDuplicate = { 1,2,3,4,5,7,3,4};
		MyArray myArrDuplicate = new MyArray(arrayDuplicate);
		int[] arrNewDuplicate = myArrDuplicate.removeDuplicates();
		System.out.println(Arrays.toString(arrNewDuplicate));
	}

}

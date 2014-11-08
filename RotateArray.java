/*
 * Given an array of integer, rotate it at position 3 of index
 * for example, input: "12345", int: 3, left rotate position 3
 * output: 45123
 */

public class RotateArray{
	public int[] rotate_by_recursion(int[] array, int rotatenumber) {
		rotateHelper(array, 0, array.length - 1, rotatenumber);
		return array;
	}

	public void rotateHelper(int[] array, int start, int end, int rotatenumber) {
		if (start == end) {
			return;
		}
		// switch number 
		int switchNumber = Math.min(rotatenumber, array.length - rotatenumber - start);

		for (int i = 0; i < switchNumber; i++) {
			int temp = array[start + i];
			array[start + i] = array[array.length - rotatenumber + i];
			array[array.length - rotatenumber + i] = temp;
		}

		rotateHelper(array, start + switchNumber, end, switchNumber);
	}

	public static void main(String[] args) {
		RotateArray test = new RotateArray();
		int[] array = {1,2,3,4,5,6,7};
		int[] a = test.rotate_by_recursion(array, 6);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
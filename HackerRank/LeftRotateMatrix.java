
public class LeftRotateMatrix {
	public static void main(String[] args) {

		int[][] arr = {
				{11,12,13,14},
				{21,22,23,24},
				{31,32,33,34},
				{41,42,43,44}
		};
		
		rotate(arr);
		MatrixOperations.display(arr);
	}

	private static void rotate(int[][] arr) {
		transpose(arr);
		reverse(arr);
	}

	private static void transpose(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = row; col < arr[0].length; col++) {
				swap(arr, row, col, col, row);
			}
		}
	}

	private static void reverse(int[][] arr) {
		int lc = 0;
		int rc = arr[0].length - 1;

		while (lc < rc) {
			for (int row = 0; row < arr.length; row++) {
				swap(arr, row, lc, row, rc);
			}

			lc++;
			rc--;
		}
	}

	private static void swap(int[][] arr, int r1, int c1, int r2, int c2) {
		int temp = arr[r1][c1];
		arr[r1][c1] = arr[r2][c2];
		arr[r2][c2] = temp;
	}
}

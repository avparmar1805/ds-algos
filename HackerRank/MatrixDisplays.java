
public class MatrixDisplays {
	public static void main(String[] args) {

		int[][] arr = { 
				{ 11, 12, 13, 14 }, 
				{ 21, 22, 23, 24 }, 
				{ 31, 32, 33, 34 }, 
				{ 41, 42, 43, 44 } };

		// waveDisplay(arr);
		spiralDisplay(arr);
	}

	private static void spiralDisplay(int[][] arr) {
		int cmin = 0;
		int cmax = arr[0].length - 1;
		int rmin = 0;
		int rmax = arr.length - 1;

		int counter = 0;
		while (counter < arr.length * arr[0].length) {
			// left wall
			for (int row = rmin; row <= rmax; row++) {
				System.out.print(arr[row][cmin] + " ");
				counter++;
			}
			cmin++;
			// bottom wall
			for (int col = cmin; col <= cmax; col++) {
				System.out.print(arr[rmax][col] + " ");
				counter++;
			}
			rmax--;
			// right wall
			for (int row = rmax; row >= rmin; row--) {
				System.out.print(arr[row][cmax] + " ");
				counter++;
			}
			cmax--;
			// top wall
			for (int col = cmax; col >= cmin; col--) {
				System.out.print(arr[rmin][col] + " ");
				counter++;
			}
			rmin++;
		}
	}

	private static void waveDisplay(int[][] arr) {
		int rows = arr.length - 1;
		boolean isDown = true;
		int counter = 0;
		int currCol = 0;
		while (counter < arr.length * arr[0].length) {
			if (isDown) {
				for (int r = 0; r <= rows; r++) {
					System.out.print(arr[r][currCol] + " ");
					counter++;
				}
			} else {
				for (int r = rows; r >= 0; r--) {
					System.out.print(arr[r][currCol] + " ");
					counter++;
				}
			}

			isDown = !isDown;
			currCol++;
		}
	}
}

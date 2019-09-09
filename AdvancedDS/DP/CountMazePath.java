package DP;

public class CountMazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 15;
		System.out.println(cmpt(n, n));
	}

	public static int cmpt(int dr, int dc) {
		int[][] f = new int[dr + 1][dc + 1];

		for (int row = dr; row >= 0; row--) {
			for (int col = dc; col >= 0; col--) {

				if (row == dr && col == dc) {
					f[row][col] = 1;
				} else if (row == dr) {
					f[row][col] = f[row][col + 1];
				} else if (col == dc) {
					f[row][col] = f[row + 1][col];
				} else {
					f[row][col] = f[row + 1][col] + f[row][col + 1];
				}

			}
		}

		return f[0][0];
	}

}

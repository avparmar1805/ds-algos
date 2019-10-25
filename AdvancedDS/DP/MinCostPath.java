package DP;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}

	private int mcp(int[][] arr) {
		int[][] f = new int[arr.length][arr[0].length];

		for (int i = f.length - 1; i >= 0; i--) {
			for (int j = f[0].length - 1; j >= 0; j--) {
				if (i == f.length - 1 && j == f[0].length - 1) {

				} else if (i == f.length - 1) {
					f[i][j] = arr[i][j] + arr[i][j + 1];
				} else if (j == f[0].length - 1) {
					f[i][j] = arr[i][j] + arr[i + 1][j];
				} else {
					f[i][j] = arr[i][j] + Math.min(arr[i + 1][j], arr[i][j + 1]);
				}
			}
		}
		
		return f[0][0];
	}

}

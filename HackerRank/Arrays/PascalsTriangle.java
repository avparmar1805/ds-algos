package Arrays;

public class PascalsTriangle {
	public static void main(String[] args) {
		int[][] retArr = solve(3);
		System.out.println(retArr[2][1]);

	}
	
	private static int[][] solve(int A) {
		int[][] retArr;
		if(A == 0) {
			retArr = new int[1][];
			retArr[0] = new int[1];
			retArr[0][0] = 0;
			return retArr;
		} 
		if(A == 1) {
			retArr = new int[1][];
			retArr[0] = new int[1];
			retArr[0][0] = 1;
			return retArr;
		}
		
		retArr = new int[A][];

		retArr[0] = new int[1];
		retArr[0][0] = 1;

		retArr[1] = new int[2];
		retArr[1][0] = 1;
		retArr[1][1] = 1;

		for (int i = 2; i < A; i++) {
			retArr[i] = new int[i + 1];
			retArr[i][0] = 1;
			for (int j = 1; j < i; j++) {
				retArr[i][j] = retArr[i - 1][j] + retArr[i - 1][j - 1];
			}
			retArr[i][i] = 1;
		}
		return retArr;
	}
}


public class MinNumberInfiniteGrid {
	public static void main(String args[]) {
		int[] A = { 4, 8, -7, -5, -13, 9, -7, 8 };
		int[] B = { 4, -15, -10, -3, -13, 12, 8, -8 };
		int min = 0;
		for (int i = 0; i < A.length - 1; i++) {
			int a = A[i];
			int b = B[i];

			int c = A[i + 1];
			int d = B[i + 1];

			int x = Math.abs(a - c);
			int y = Math.abs(b - d);
			min += Math.max(x, y);
		}
		
	}
}

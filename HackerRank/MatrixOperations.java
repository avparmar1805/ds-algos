
public class MatrixOperations {
	public static void main(String[] args) {
		int[][] mat1 = { { 10, 0, 1 }, { 2, 0, 1 } }; // 2*3

		int[][] mat2 = { { 10, 0, 1,1 }, { 2, 0, 1,2 }, { 2, 0, 1, 3 } }; // 3*4

		Multiply(mat1, mat2);
	}

	private static void Multiply(int[][] mat1, int[][] mat2) {
		int r1 = mat1.length;
		int c1 = mat1[0].length;
		int c2 = mat2[0].length;

		int[][] res = new int[r1][c2];

		for (int r = 0; r < res.length; r++) {
			for (int c = 0; c < res[0].length; c++) {
				for(int cd = 0; cd< c1; cd++) {
					res[r][c] += mat1[r][cd]*mat2[cd][c];
				}
			}
		}
		
		display(res);
	}
	
	public static void display(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
}

package Feb11;

public class MatrixMultiplication {
	public static void main(String[] args) {
		int[][] mat1 = { 
				{ 10, 0, 1 }, 
				{ 2, 0, 1 } 
			}; // 2*3

		int[][] mat2 = { 
				{ 10, 0, 1 }, 
				{ 2, 0, 1 }, 
				{ 2, 0, 1 }
			}; // 3*3
		

		Multiply(mat1, mat2);
	}

	public static void Multiply(int[][] mat1, int[][] mat2) {
		int rows1 = mat1.length;
		int cols1 = mat1[0].length;
		int rows2 = mat2.length;
		int cols2 = mat2[0].length;
		int[][] prd = new int[cols1][rows2];

		int sum = 0;
		if (cols1 != rows2) {
			System.out.println("Cannot be multiplied");
		} else {
			for (int i = 0; i < rows1; i++) {
				for (int j = 0; j < cols2; j++) {
					for (int k = 0; k < cols1; k++) {
						sum = sum + mat1[i][k] * mat2[k][j];
					}
					System.out.print(sum + " ");
					sum = 0;
				}
				System.out.println();
			}
		}
	}
}

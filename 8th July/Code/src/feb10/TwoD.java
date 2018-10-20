package feb10;

public class TwoD {

	public static void main(String[] args) {
//		int[][] arr = new int[3][4];
//		
//		int rows = arr.length;
//		int cols = arr[0].length;
//		System.out.println(rows);
//		System.out.println(cols);
//		
//		display(arr);
		
//		int[][] arr = {
//				{11, 12, 13, 14},
//				{21, 22, 23, 24},
//				{31, 32, 33, 34}
//		};
//		display(arr);
		
		int[][] mat1 = {
				{10, 0, 1},
				{0, 2, 20}
		};
		int[][] mat2 = {
				{0, 1, 0, 1},
				{2, 2, 0, 2},
				{0, 3, 3, 0},
		};
		
		display(mat1);
		System.out.println("**************************");
		display(mat2);
		System.out.println("**************************");
		matrixmultiply(mat1, mat2);
	}
	
	public static void display(int[][] arr){
		int rows = arr.length;
		int cols = arr[0].length;
		
		for(int row = 0; row < rows; row++){
			for(int col = 0; col < cols; col++){
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	public static void matrixmultiply(int[][] mat1, int[][] mat2){
		int row1 = mat1.length;
		int col1 = mat1[0].length;
		int row2 = mat2.length;
		int col2 = mat2[0].length;
		
		if(col1 == row2){
			int[][] prd = new int[row1][col2];
			
			for(int i = 0; i < prd.length; i++){
				for(int j = 0; j < prd[0].length; j++){
					for(int k = 0; k < row2; k++){
						prd[i][j] = prd[i][j] + mat1[i][k] * mat2[k][j];
					}
				}
			}
			
			display(prd);
		} else {
			System.out.println("Can't be multiplied");
		}
	}

}

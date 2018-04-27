package Arrays;

public class MaxSubSequenceOfArray {
	public static void main (String[] args) {
		int[][] array = {
				{1, 1, 1, 1, 1, 0},
				{1, 0, 0, 1, 0, 0},
				{1, 1, 0, 1, 1, 1},
				{1, 1, 1, 1, 0, 1},
				{0, 1, 1, 1, 1, 0},
				{0, 1, 1, 1, 0, 1},
		};
		
		maxSizeSquareSubmatrix(array);
	}
	
	public static void maxSizeSquareSubmatrix(int[][] arr){
		int[][] strg = new int[arr.length][arr[0].length];
		
		int omax = 0;
		int omrow = -1;
		int omcol = -1;
		
		for(int row = arr.length - 1; row >= 0; row--){
			for(int col = arr[0].length - 1; col >= 0; col--){
				int rp1 = row + 1;
				int cp1 = col + 1;
				
				if(arr[row][col] == 0){
					continue;
				}
				
				if(rp1 == arr.length && cp1 == arr[0].length){
					// last cell
					strg[row][col] = arr[row][col];
				} else if(rp1 == arr.length){
					// last row
					strg[row][col] = arr[row][col];
				} else if(cp1 == arr[0].length){
					// last col
					strg[row][col] = arr[row][col];
				} else {
					strg[row][col] = 1 + Math.min(strg[row][cp1], 
										 Math.min(strg[rp1][col], strg[rp1][cp1]));
				}
				
				if(strg[row][col] > omax){
					omax = strg[row][col];
					omrow = row;
					omcol = col;
				}
			}
		}
		
		System.out.println(omax + " size square starting in [" + omrow + "-" + omcol + "]");
	}
}

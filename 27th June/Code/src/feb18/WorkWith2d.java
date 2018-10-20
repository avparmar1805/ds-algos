package feb18;

public class WorkWith2d {

	public static void main(String[] args) {
//		int[][] arr = { { 11, 12, 13, 14, 15, 16 }, { 21, 22, 23, 24, 25, 26 }, { 31, 32, 33, 34, 35, 36 },
//				{ 41, 42, 43, 44, 45, 46 }, { 51, 52, 53, 54, 55, 56 }, { 61, 62, 63, 64, 65, 66 }, };
////		spiral(arr);
//		shellRotate(arr, 2, 3);
//		
//		
//		for(int row = 0; row < arr.length; row++){
//			for(int col = 0; col < arr[0].length; col++){
//				System.out.print(arr[row][col] + " ");
//			}
//			System.out.println();
//		}
		
		int[][] arr = {
				{1, 1, 1, 1, 1, 0},
				{1, 0, 0, 1, 0, 0},
				{1, 1, 0, 1, 1, 1},
				{1, 1, 1, 1, 0, 1},
				{0, 1, 1, 1, 1, 0},
				{0, 1, 1, 1, 0, 1},
		};
		maxSizeSquareSubmatrix(arr);
		
	}

	public static void spiral(int[][] arr) {
		int counter = 1;
		int tne = arr.length * arr[0].length;

		int rmin = 0, cmin = 0;
		int rmax = arr.length - 1, cmax = arr[0].length - 1;
		while (counter <= tne) {
			// lW
			for (int row = rmin; counter <= tne && row <= rmax; row++) {
				System.out.print(arr[row][cmin] + " ");
				counter++;
			}
			cmin++;

			// bw
			for (int col = cmin; counter <= tne && col <= cmax; col++) {
				System.out.print(arr[rmax][col] + " ");
				counter++;
			}
			rmax--;

			// rw
			for (int row = rmax; counter <= tne && row >= rmin; row--) {
				System.out.print(arr[row][cmax] + " ");
				counter++;
			}
			cmax--;

			// tw
			for (int col = cmax; counter <= tne && col >= cmin; col--) {
				System.out.print(arr[rmin][col] + " ");
				counter++;
			}
			rmin++;
		}

		System.out.println(".");
	}

	public static void shellRotate(int[][] arr, int sno, int d) {
		int rmin = sno - 1;
		int cmin = sno - 1;
		int rmax = arr.length - sno;
		int cmax = arr[0].length - sno;

		int tne = 2 * (rmax - rmin + cmax - cmin);
		int[] lina = new int[tne];

		// filling linear array from shell
		int counter = 0;
		// lW
		for (int row = rmin; counter <= tne && row <= rmax; row++) {
			lina[counter] = arr[row][cmin];
			counter++;
		}
		cmin++;

		// bw
		for (int col = cmin; counter <= tne && col <= cmax; col++) {
			lina[counter] = arr[rmax][col];
			counter++;
		}
		rmax--;

		// rw
		for (int row = rmax; counter <= tne && row >= rmin; row--) {
			lina[counter] = arr[row][cmax];
			counter++;
		}
		cmax--;

		// tw
		for (int col = cmax; counter <= tne && col >= cmin; col--) {
			lina[counter] = arr[rmin][col];
			counter++;
		}
		rmin++;

		// rotate
		feb10.WorkWithArrays.rotate(lina, d);

		// fill the box from linear array
		rmin--;
		cmin--;
		rmax++;
		cmax++;
		counter = 0;

		// lW
		for (int row = rmin; counter <= tne && row <= rmax; row++) {
			arr[row][cmin] = lina[counter];
			counter++;
		}
		cmin++;

		// bw
		for (int col = cmin; counter <= tne && col <= cmax; col++) {
			arr[rmax][col] = lina[counter];
			counter++;
		}
		rmax--;

		// rw
		for (int row = rmax; counter <= tne && row >= rmin; row--) {
			arr[row][cmax] = lina[counter];
			counter++;
		}
		cmax--;

		// tw
		for (int col = cmax; counter <= tne && col >= cmin; col--) {
			arr[rmin][col] = lina[counter];
			counter++;
		}
		rmin++;

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

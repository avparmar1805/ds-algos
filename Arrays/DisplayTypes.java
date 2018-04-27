package Arrays;

public class DisplayTypes {
	public static void main (String[] args) {
		int[][] arr = {
				{11,12,13},
				{21,22,23},
				{31,32,33},
				{41,42,43},
				{51,52,53}
		};
		
		//WaveDisplay(arr);
		SpiralDisplay(arr);
	}
	
	public static void SpiralDisplay(int[][] arr) {
		int rmin = 0;
		int cmin = 0;
		int rmax = arr.length-1;
		int cmax = arr[0].length-1;
		
		int n = 0;
		int tne = arr.length*arr[0].length;
		
		while(n < tne) {
			
			//Left wall
			for(int i = rmin;n < tne && i <= rmax; i++) {
				System.out.print(arr[i][cmin] + " ");
				n++;
			}
			cmin++;
			//Bottom wall
			for(int i = cmin; n < tne && i <= cmax; i++) {
				System.out.print(arr[rmax][i] + " ");
				n++;
			}
			rmax--;
			// Right Wall
			for(int i = rmax; n < tne && i >= rmin; i--) {
				System.out.print(arr[i][cmax] + " ");
				n++;
			}
			cmax--;
			// Top Wall
			for(int i = cmax;n < tne && i >= cmin; i--) {
				System.out.print(arr[rmin][i] + " ");
				n++;
			}
			rmin++;
		}
			
	}
	
	public static void WaveDisplay(int[][] arr) {
		boolean isDown = true;
		int row = 0;
		int col = 0;
		int n = 0;
		
		while(n != 16) {
			
			System.out.print(arr[row][col] + " ");
			if(isDown) {
				row++;
			} else {
				row--;
			}
			if(row > 3 || row < 0) {
				
				isDown = !isDown;
				if(isDown) {
					row++;
				} else {
					row--;
				}
				col++;
			} 
			
			
			n++;
		}
		
	}
}

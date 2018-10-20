package feb17;

public class WorkWithTwodArrays {

	public static void main(String[] args) {
//		int[][] maze = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
//		exitPoint(maze);
		int[][] arr = {
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34},
				{41, 42, 43, 44}
		};
		wave(arr);
	}

	public static void exitPoint(int[][] maze) {
		int row = 0, col = 0;
		int dir = 0; // 0123 => eswn
		while (true) {
			dir = (dir + maze[row][col]) % 4;

			if (dir == 0) {
				if (col != maze[0].length - 1) {
					col++;
				} else {
					System.out.println(row + " " + col);
					break;
				}
			} else if (dir == 1) {
				if (row != maze.length - 1) {
					row++;
				} else {
					System.out.println(row + " " + col);
					break;
				}
			} else if (dir == 2) {
				if (col != 0) {
					col--;
				} else {
					System.out.println(row + " " + col);
					break;
				}
			} else {
				if (row != 0) {
					row--;
				} else {
					System.out.println(row + " " + col);
					break;
				}
			}
		}

	}

	public static void wave(int[][] arr){
		for(int col = 0; col < arr[0].length; col++){
			if(col % 2 == 0){
				for(int row = 0; row < arr.length; row++){
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for(int row = arr.length - 1; row >= 0; row--){
					System.out.print(arr[row][col] + " ");
				}
			}
		}
		
		System.out.println(".");
	}
}

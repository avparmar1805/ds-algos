package Arrays;

public class MazeQn {
	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };

		exitPoint(maze);
	}

	public static void exitPoint(int[][] maze) {
		int direction = 0;
		int row = 0;
		int col = 0;

		while (row < 4 && col < 4 && row > -1 && col > -1) {
			if (maze[row][col] == 1) {
				System.out.println("Found 1 row = " + row + "col = " + col);

				direction = (direction + maze[row][col]) % 4;
			}
			if (direction == 0) {
				col++;
			} else if (direction == 1) {
				row++;
			} else if (direction == 2) {
				col--;
			} else if (direction == 3) {
				row--;
			}
			System.out.println("direction =" + direction);
		}
		
		if(row == 4) {
			System.out.println("Row = "+ row--);
			System.out.println("Col = "+ col);
		} else if(row == -1) {
			System.out.println("Row = "+ row++);
			System.out.println("Col = "+ col);
		}
		if(col == 4) {
			System.out.println("Row = "+ row);
			System.out.println("Col = "+ col--);
		} else if(col == -1) {
			System.out.println("Row = "+ row);
			System.out.println("Col = "+ col++);
		}
		
	}

}

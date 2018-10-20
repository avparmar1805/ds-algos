package mar25;

public class RecursionCtd {

	public static void main(String[] args) {



		// rule 1 -> 4 directions
		// rule 2 -> single step
		// rule 3 -> obstacles
		// int[][] maze = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1,
		// 1, 0, 1 } };
		// boolean[][] visited = new boolean[maze.length][maze[0].length];
		// floodfill(0, 0, maze, visited, "");

//		boolean[] boxes = new boolean[4];
//		int r = 2;
		// placeRQueensInNBoxes(boxes, r, 0, "");
//		placeRQueensInNBoxesCombinations(boxes, r, 0, "", -1);
		int[] denoms = {2, 3, 5, 6};
		int amt = 10;
		coinChangeCombinations(denoms, amt, "", 0);
	}

	public static void floodfill(int sr, int sc, int[][] maze, boolean[][] visited, String psf) {
		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			System.out.println(psf);
			return;
		}

		if (isThisAnInValidSpot(sr, sc, maze, visited) == true) {
			return;
		}

		visited[sr][sc] = true;

		floodfill(sr, sc - 1, maze, visited, psf + "l");
		floodfill(sr + 1, sc, maze, visited, psf + "d");
		floodfill(sr, sc + 1, maze, visited, psf + "r");
		floodfill(sr - 1, sc, maze, visited, psf + "u");

		visited[sr][sc] = false;
	}

	public static boolean isThisAnInValidSpot(int row, int col, int[][] maze, boolean[][] visited) {
		if (row < 0) {
			return true;
		} else if (row >= maze.length) {
			return true;
		} else if (col < 0) {
			return true;
		} else if (col >= maze[0].length) {
			return true;
		} else if (maze[row][col] == 0) {
			return true;
		} else if (visited[row][col] == true) {
			return true;
		} else {
			return false;
		}
	}

	static int counter = 0;

	public static void placeRQueensInNBoxes(boolean[] boxes, int r, 
											int qno, String psf) {
		if (qno == r) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		for (int bno = 0; bno < boxes.length; bno++) {
			if (boxes[bno] == false) {
				boxes[bno] = true;
				placeRQueensInNBoxes(boxes, r, qno + 1, psf + "q" + qno + "b" + bno + " ");
				boxes[bno] = false;
			}
		}

	}

	public static void placeRQueensInNBoxesCombinations(boolean[] boxes, 
			int r, int qno, String psf, int lqpb) {
		if (qno == r) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		for (int bno = lqpb + 1; bno < boxes.length; bno++) {
			if (boxes[bno] == false) {
				boxes[bno] = true;
				placeRQueensInNBoxesCombinations(boxes, r, qno + 1, 
						psf + "q" + qno + "b" + bno + " ", bno);
				boxes[bno] = false;
			}
		}

	}

	public static void coinChangePermutations(int[] denoms, int amt, String psf) {
		if(amt == 0){
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}
		
		for (int i = 0; i < denoms.length; i++) {
			if (denoms[i] <= amt) {
				coinChangePermutations(denoms, amt - denoms[i], psf + " " + denoms[i]);
			}
		}
	}

	public static void coinChangeCombinations(int[] denoms, int amt, 
											  String psf, int lpi) {
		if(amt == 0){
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}
		
		for(int i = lpi; i < denoms.length; i++){
			if(denoms[i] <= amt){
				coinChangeCombinations(denoms, amt - denoms[i], 
									   psf + " " + denoms[i], i);
			}
		}
	}
}

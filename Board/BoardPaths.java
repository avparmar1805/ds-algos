package Board;

public class BoardPaths {
	public static void main(String[] args) {
		// printBoardPaths16(0, 10, "");
		int[] ladders = new int[16];
		ladders[2] = 13;
		ladders[3] = 11;
		ladders[5] = 7;
		// printBoardPathsUsingLadder(0, 15, "", ladders);

		// printMazePaths(0, 0, 2, 2, "");
		printMazePathsWithMultipleStepsForRectangle(0, 0, 3, 2, "");
	}

	public static void printMazePathsWithMultipleSteps(int sr, int sc, int dr, int dc, String psf) {

		if (sr == dr && sc == dc) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		for (int i = 1; i <= dr; i++) {
			if (sc + i <= dc)
				printMazePathsWithMultipleSteps(sr, sc + i, dr, dc, psf + "h" + i);

			if (sr + i <= dr)
				printMazePathsWithMultipleSteps(sr + i, sc, dr, dc, psf + "v" + i);

			if (sc + i <= dc && sr + i <= dr) {
				printMazePathsWithMultipleSteps(sr + i, sc + i, dr, dc, psf + "d" + i);
			}
		}
	}

	public static void printMazePathsWithMultipleStepsForRectangle(int sr, int sc, int dr, int dc, String psf) {

		if (sr == dr && sc == dc) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		for (int move = 1; move <= dr - sr; move++) {
			printMazePathsWithMultipleStepsForRectangle(sr + move, sc, dr, dc, psf + "v" + move);
		}

		for (int move = 1; move <= dc - sc; move++) {
			printMazePathsWithMultipleStepsForRectangle(sr, sc + move, dr, dc, psf + "h" + move);
		}

		// diagonal
		for (int move = 1; move <= dr - sr && move <= dc - sc; move++) {
			printMazePathsWithMultipleStepsForRectangle(sr + move, sc + move, dr, dc, psf + "d" + move);
		}
	}

	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

		if (sr == dr && sc == dc) {
			count++;
			System.out.println(count + " " + psf);
			return;
		}

		if (sc + 1 <= dc)
			printMazePaths(sr, sc + 1, dr, dc, psf + "h");

		if (sr + 1 <= dr)
			printMazePaths(sr + 1, sc, dr, dc, psf + "v");

		if (sc + 1 <= dc && sr + 1 <= dr) {
			printMazePaths(sr + 1, sc + 1, dr, dc, psf + "d");
		}
	}

	static int count = 0;

	public static void printBoardPathsUsingLadder(int src, int dest, String psf, int[] ladder) {
		if (src == dest) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		if (src == 0) {
			printBoardPathsUsingLadder(1, dest, psf + 1, ladder);
			printBoardPathsUsingLadder(1, dest, psf + 6, ladder);
		} else if (ladder[src] != 0) {
			String npsf = psf + "[" + src + "->" + ladder[src] + "]";
			printBoardPathsUsingLadder(ladder[src], dest, npsf, ladder);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				int inter = src + dice;
				if (inter <= dest) {
					printBoardPathsUsingLadder(inter, dest, psf + dice, ladder);
				}
			}
		}
	}

	public static void printBoardPaths16(int src, int dest, String psf) {

		if (src == dest) {
			count++;
			System.out.println(count + ". " + psf);
		}

		for (int dice = 1; dice <= 6; dice++) {
			int inter = src + dice;
			if (src == 0 && (dice == 1 || dice == 6)) {
				if (inter <= dest)
					printBoardPaths16(1, dest, psf + dice);

			} else if (src > 0 && inter <= dest) {
				printBoardPaths16(inter, dest, psf + dice);
			}
		}
	}
}

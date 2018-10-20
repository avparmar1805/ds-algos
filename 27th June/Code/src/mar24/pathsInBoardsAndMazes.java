package mar24;

public class pathsInBoardsAndMazes {

	public static void main(String[] args) {
		// printBoardPaths16(0, 10, "");

		// int[] ladders = new int[16];
		// ladders[2] = 13;
		// ladders[3] = 11;
		// ladders[5] = 7;
		// printBoardPaths16WithLadder(0, 15, "", ladders);
		// printMazePathsWD(0, 0, 2, 2, "");
		printMazePathsWDMultiSteps(0, 0, 3, 2, "");
	}

	static int count = 0;

	public static void printBoardPaths(int src, int dest, String psf) {
		if (src == dest) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			int inter = src + dice;
			if (inter <= dest) {
				printBoardPaths(inter, dest, psf + dice);
			}
		}
	}

	public static void printBoardPathsReactive(int src, int dest, String psf) {
		if (src == dest) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		if (src > dest) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			int inter = src + dice;
			printBoardPathsReactive(inter, dest, psf + dice);
		}
	}

	public static void printBoardPaths16(int src, int dest, String psf) {
		if (src == dest) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		if (src == 0) {
			printBoardPaths16(1, dest, psf + 1);
			printBoardPaths16(1, dest, psf + 6);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				int inter = src + dice;
				if (inter <= dest) {
					printBoardPaths16(inter, dest, psf + dice);
				}
			}
		}
	}

	public static void printBoardPaths16WithLadder(int src, int dest, String psf, int[] ladders) {
		if (src == dest) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		if (src == 0) {
			printBoardPaths16WithLadder(1, dest, psf + 1, ladders);
			printBoardPaths16WithLadder(1, dest, psf + 6, ladders);
		} else if (ladders[src] != 0) {
			String npsf = psf + "[" + src + " -> " + ladders[src] + "]";
			printBoardPaths16WithLadder(ladders[src], dest, npsf, ladders);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				int inter = src + dice;
				if (inter <= dest) {
					printBoardPaths16WithLadder(inter, dest, psf + dice, ladders);
				}
			}
		}
	}

	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		if (sc <= dc - 1) {
			printMazePaths(sr, sc + 1, dr, dc, psf + "h");
		}

		if (sr <= dr - 1) {
			printMazePaths(sr + 1, sc, dr, dc, psf + "v");
		}
	}

	public static void printMazePathsReactive(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}
		
		if(sr > dr || sc > dc){
			return;
		}

		printMazePathsReactive(sr, sc + 1, dr, dc, psf + "h");
		printMazePathsReactive(sr + 1, sc, dr, dc, psf + "v");
	}

	public static void printMazePathsWD(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		if (sc <= dc - 1) {
			printMazePathsWD(sr, sc + 1, dr, dc, psf + "h");
		}

		if (sr <= dr - 1) {
			printMazePathsWD(sr + 1, sc, dr, dc, psf + "v");
		}

		if (sr <= dr - 1 && sc <= dc - 1) {
			printMazePathsWD(sr + 1, sc + 1, dr, dc, psf + "d");
		}
	}

	public static void printMazePathsWDMultiSteps(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			count++;
			System.out.println(count + ". " + psf);
			return;
		}

		// horizontal moves
		for (int move = 1; move <= dc - sc; move++) {
			printMazePathsWDMultiSteps(sr, sc + move, dr, dc, psf + "h" + move);
		}

		// vertical moves
		for (int move = 1; move <= dr - sr; move++) {
			printMazePathsWDMultiSteps(sr + move, sc, dr, dc, psf + "V" + move);
		}

		// diagonal move
		for (int move = 1; move <= dr - sr && move <= dc - sc; move++) {
			printMazePathsWDMultiSteps(sr + move, sc + move, dr, dc, psf + "D" + move);
		}
	}
}

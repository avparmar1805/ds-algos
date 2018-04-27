package Recursion;

public class RecursionFinalStretch {
	public static void main(String[] args) {
		// nqueens(new boolean[4][4], 0, "", -1);
		// nqueensProactive(new boolean[4][4], 0, "", -1);

		//nqueesnLikeSubsequence(new boolean[4][4], 0, 0, "");
		
		nKnightsProactive(new boolean[3][3], 0, "", -1);
	}

	static int counter = 0;

	public static void nKnightsProactive(boolean[][] board, int qno, String psf, int lqpb) {

		if (qno == board.length) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		for (int bno = lqpb + 1; bno < board.length * board.length; bno++) {

			int row = bno / board.length;
			int col = bno % board.length;
			if (board[row][col] == false && isKnightSafe(board, row, col)) {
				board[row][col] = true;
				nKnightsProactive(board, qno + 1, psf + " " + bno, bno);
				board[row][col] = false;
			}
		}
	}
	
	public static void nqueensProactive(boolean[][] board, int qno, String psf, int lqpb) {

		if (qno == board.length) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		for (int bno = lqpb + 1; bno < board.length * board.length; bno++) {

			int row = bno / board.length;
			int col = bno % board.length;
			if (board[row][col] == false && isQueenSafe(board, row, col)) {
				board[row][col] = true;
				nqueensProactive(board, qno + 1, psf + " " + bno, bno);
				board[row][col] = false;
			}
		}
	}

	public static void nqueens(boolean[][] board, int qno, String psf, int lqpb) {

		if (qno == board.length) {
			counter++;
			if (isBoardValid(board)) {
				System.out.println(counter + ". " + psf);
			}
			return;
		}

		for (int bno = lqpb + 1; bno < board.length * board.length; bno++) {

			int row = bno / board.length;
			int col = bno % board.length;
			if (board[row][col] == false) {
				board[row][col] = true;
				nqueens(board, qno + 1, psf + " " + bno, bno);
				board[row][col] = false;
			}
		}
	}

	public static boolean isBoardValid(boolean[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col]) {
					if (!isQueenSafe(board, row, col)) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static boolean isQueenSafe(boolean[][] board, int row, int col) {
		int[][] dirs = { { -1, 0 }, // north
				{ -1, +1 }, // ne
				{ 0, +1 }, // e
				{ +1, +1 }, // se
				{ +1, 0 }, // south
				{ +1, -1 }, // south west
				{ 0, -1 }, // west
				{ -1, -1 } // north west
		};

		for (int dir = 0; dir < dirs.length; dir++) {
			int radius = 1;
			while (true) {
				int rowDash = row + radius * dirs[dir][0];
				int colDash = col + radius * dirs[dir][1];
				if (rowDash < 0 || rowDash >= board.length) {
					break;
				}

				if (colDash < 0 || colDash >= board.length) {
					break;
				}

				if (board[rowDash][colDash]) {
					return false;
				}
				radius++;
			}

		}

		return true;
	}

	public static void nqueesnLikeSubsequence(boolean[][] board, int bno, int qno, String psf) {

		if (qno == board.length) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}
		if (bno < board.length * board.length) {
			// queen is not considering to sit
			nqueesnLikeSubsequence(board, bno + 1, qno, psf);

			// queen is considering to sit

			int row = bno / board.length;
			int col = bno % board.length;
			if (board[row][col] == false && isQueenSafe(board, row, col)) {
				board[row][col] = true;
				nqueesnLikeSubsequence(board, bno + 1, qno + 1, psf + " " + bno);
				board[row][col] = false;
			}
		}
	}

	public static boolean isKnightSafe(boolean[][] board, int row, int col) {
		int[][] dirs = { { -2, +1 }, // northeast
				{ -1, +2 }, // eastnorth
				{ +1, +2 }, // esouth
				{ +2, +1 }, // se
				{ +2, -1 }, // southwest
				{ +1, -2 }, // westsouth
				{ -1, -2 }, // west north
				{ -2, -1 } // north west
		};

		for (int dir = 0; dir < dirs.length; dir++) {
			int radius = 1;
			while (true) {
				int rowDash = row + radius * dirs[dir][0];
				int colDash = col + radius * dirs[dir][1];
				if (rowDash < 0 || rowDash >= board.length) {
					break;
				}

				if (colDash < 0 || colDash >= board.length) {
					break;
				}

				if (board[rowDash][colDash]) {
					return false;
				}
				radius++;
			}

		}

		return true;
	}
	
}

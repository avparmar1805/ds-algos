package mar31;

public class RecursionFinalStretch {

	public static void main(String[] args) {

		int n = 3;

		long start = System.currentTimeMillis();
		// nqueensproactive(new boolean[n][n], 0, "", -1);
//		nqueensLikeASubsequence(new boolean[n][n], 0, 0, "");
		nknightsproactive(new boolean[n][n], 0, "", -1);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	static int counter = 0;

	public static void nqueensreactive(boolean[][] board, int qno, String psf, int lqpb) {
		if (qno == board.length) {
			if (theBoardIsValid(board) == true) {
				counter++;
				System.out.println(counter + ". " + psf);
			}
			return;
		}
		// print only the valid combinations
		// produce all combinations -> n^2cn

		for (int bno = lqpb + 1; bno < board.length * board.length; bno++) {
			int rno = bno / board.length;
			int cno = bno % board.length;

			if (board[rno][cno] == false) {
				board[rno][cno] = true;
				nqueensreactive(board, qno + 1, psf + " " + bno, bno);
				board[rno][cno] = false;
			}
		}

	}

	public static void nqueensproactive(boolean[][] board, int qno, String psf, int lqpb) {
		if (qno == board.length) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		for (int bno = lqpb + 1; bno < board.length * board.length; bno++) {
			int rno = bno / board.length;
			int cno = bno % board.length;

			if (board[rno][cno] == false && isTheQueenSafe(board, rno, cno) == true) {
				board[rno][cno] = true;
				nqueensproactive(board, qno + 1, psf + " " + bno, bno);
				board[rno][cno] = false;
			}
		}

	}

	public static void nqueensLikeASubsequence(boolean[][] board, int bno, int qno, String psf) {
		if (qno == board.length) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		if (bno < board.length * board.length && qno < board.length) {
			// queen decided not sit in the box
			nqueensLikeASubsequence(board, bno + 1, qno, psf);

			// queen is considering to sit

			int row = bno / board.length;
			int col = bno % board.length;
			if (board[row][col] == false && isTheQueenSafe(board, row, col) == true) {
				board[row][col] = true;
				nqueensLikeASubsequence(board, bno + 1, qno + 1, psf + " " + bno);
				board[row][col] = false;
			}
		}
	}

	private static boolean theBoardIsValid(boolean[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == true) {
					if (isTheQueenSafe(board, row, col) == false) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private static boolean isTheQueenSafe(boolean[][] board, int row, int col) {
		int[][] dirs = { { -1, 0 }, // north
				{ -1, +1 }, // ne
				{ 0, +1 }, // e
				{ +1, +1 }, // se
				{ +1, 0 }, // s
				{ +1, -1 }, // sw
				{ 0, -1 }, // w
				{ -1, -1 } // nw
		};

		for (int dir = 0; dir < dirs.length; dir++) {
			int radius = 1;
			while (true) {
				int rdash = row + radius * dirs[dir][0];
				int cdash = col + radius * dirs[dir][1];

				if (rdash < 0 || rdash >= board.length) {
					break;
				}

				if (cdash < 0 || cdash >= board.length) {
					break;
				}

				if (board[rdash][cdash] == true) {
					return false;
				}

				radius++;
			}
		}

		return true;
	}

	public static void pbp(int s, int d, String psf) {
		if (s == d) {
			System.out.println(psf);
			return;
		}

		if (s > d) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			int inter = s + dice;
			pbp(inter, d, psf + " " + dice);
		}
	}

	public static void nknightsproactive(boolean[][] board, int qno, String psf, int lqpb) {
		if (qno == board.length) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		for (int bno = lqpb + 1; bno < board.length * board.length; bno++) {
			int rno = bno / board.length;
			int cno = bno % board.length;

			if (board[rno][cno] == false && isTheKnightSafe(board, rno, cno) == true) {
				board[rno][cno] = true;
				nknightsproactive(board, qno + 1, psf + " " + bno, bno);
				board[rno][cno] = false;
			}
		}

	}

	private static boolean isTheKnightSafe(boolean[][] board, int rno, int cno) {
		int[][] dirs = { { -1, +2 }, // north
				{ -1, -2 }, // ne
				{ 1, +2 }, // e
				{ +1, -2 }, // se
				{ +2, +1 }, // s
				{ +2, -1 }, // sw
				{ -2, +1 }, // w
				{ -2, -1 } // nw
		};

		for (int dir = 0; dir < dirs.length; dir++) {
			int rdash = rno + dirs[dir][0];
			int cdash = cno + dirs[dir][1];

			if (rdash < 0 || rdash >= board.length) {
				continue;
			}

			if (cdash < 0 || cdash >= board.length) {
				continue;
			}

			if (board[rdash][cdash] == true) {
				return false;
			}
		}

		return true;

	}

}

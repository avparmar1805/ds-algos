package DP;

public class MinPalindromicString {
	public static void main(String[] args) {
		String str = "abccbc";
		boolean[][] pssMatrix = palindromicSSMatrix(str);
		int[][] qb = new int[str.length()][str.length()];
		int cuts = MPS(str, 0, str.length() - 1, qb, pssMatrix);
		int[] arr = {10,20,30,40,50,60};
		MCM(arr, 0, str.length() - 1, new int[str.length()][str.length()]);
		System.out.println(MCM(arr, 0, str.length() - 1, new int[str.length()][str.length()]));

	}

	static int counter = 0;

	public static int MCM(int[] dims, int si, int ei, int[][] qb) {
		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		if (qb[si][ei] != 0) {
			return qb[si][ei];
		}
		for (int cut = si + 1; cut < ei - 1; cut++) {
			int leftCost = MCM(dims, si, cut, qb);
			int rightCost = MCM(dims, cut, ei, qb);

			int prodCost = dims[cut] * dims[si] * dims[ei];

			int tc = leftCost + rightCost + prodCost;

			if (tc < min) {
				min = tc;
				qb[si][ei] = min;
			}

		}

		return min;
	}

	public static int MPS(String str, int si, int ei, int[][] qb, boolean[][] pssMatrix) {

		if (pssMatrix[si][ei]) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		int strCuts = 0;

		if (qb[si][ei] != 0) {
			return qb[si][ei];
		}
		counter++;
		System.out.println(counter + "th call");
		for (int i = si; i < ei; i++) {

			int leftStrCuts = MPS(str, si, i, qb, pssMatrix);
			int rightStrCuts = MPS(str, i + 1, ei, qb, pssMatrix);

			strCuts = leftStrCuts + rightStrCuts + 1;

			if (strCuts < min) {
				min = strCuts;
				qb[si][ei] = min;
			}
		}

		return min;
	}

	public static boolean[][] palindromicSSMatrix(String str) {
		boolean[][] pssMatrix = new boolean[str.length()][str.length()];

		for (int gap = 0; gap <= str.length() - 1; gap++) {
			int si = 0;
			int ei = si + gap;

			while (ei <= str.length() - 1) {

				if (gap == 0) {
					pssMatrix[si][ei] = true;
				} else if (gap == 1) {
					pssMatrix[si][ei] = str.charAt(si) == str.charAt(ei);
				} else {
					pssMatrix[si][ei] = str.charAt(si) == str.charAt(ei) && pssMatrix[si + 1][ei - 1];
				}

				si++;
				ei++;
			}
		}

		return pssMatrix;
	}

	public static boolean isPalindrome(String s, int si, int ei) {
		int leftCounter = si;
		int rightCounter = ei;

		while (leftCounter <= rightCounter) {
			char leftChar = s.charAt(leftCounter);
			char rightChar = s.charAt(rightCounter);

			if (leftChar != rightChar) {
				return false;
			}

			leftCounter++;
			rightCounter--;
		}

		return true;
	}
}

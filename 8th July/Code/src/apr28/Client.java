package apr28;

public class Client {

	public static void main(String[] args) {

		// System.out.println(eggDrop(2, 64, new int[3][65]));
		// int[] arr = { 10, 20, 30, 40, 11, 5, 32, -53, -82, 2000, 48, 501, 92,
		// 63, 77, 45, 66, 50, 60, 70 };
		// int tar = 2045;
		// Boolean[][] pqb = new Boolean[arr.length + 1][1000000];
		// Boolean[][] nqb = new Boolean[arr.length + 1][1000000];
		// System.out.println(targetSum(arr, 0, tar, pqb, nqb));

		// int[] wts = {2, 4, 6, 2, 1};
		// int[] prices = {5, 20, 100, 15, 75};
		// int cap = 7;
		// System.out.println(knapSack(wts, prices, cap));

		// String s1 = "aeassldkfjaklsdflaksdkdljfbg";
		// String s2 = "dlkfklasd'kfdalskjlkasdjeg";
		//
		// System.out.println(lcs(s1, s2, new int[s1.length() + 1][s2.length() +
		// 1]));

//		String s = "abcgbbca";
//		System.out.println(lps(s, 0, s.length() - 1, new int[s.length()][s.length()]));
		
		System.out.println(editDistance("zcgd", "abcd", new int[5][5]));
	}

	// min number of trials required to find the critical floor
	// given e number of eggs and f number of floors
	// The plan should be a guaranteed plan
	public static int eggDrop(int e, int f, int[][] qb) {
		if (e == 1) {
			return f;
		} else if (f == 0 || f == 1) {
			return f;
		}

		if (qb[e][f] != 0) {
			return qb[e][f];
		}

		int best = Integer.MAX_VALUE;
		for (int k = 1; k <= f; k++) {
			int mteb = eggDrop(e - 1, k - 1, qb);
			int mtes = eggDrop(e, f - k, qb);
			int worse = Math.max(mtes, mteb);

			// best of the worse, best on the day we are out of luck
			if (worse < best) {
				best = worse;
			}
		}

		qb[e][f] = best + 1;
		return best + 1;
	}

	static int counter = 0;

	public static boolean targetSum(int[] arr, int vidx, int tar, Boolean[][] pqb, Boolean[][] nqb) {
		if (vidx == arr.length) {
			return tar == 0;
		}

		if (tar >= 0) {
			if (pqb[vidx][tar] != null) {
				return pqb[vidx][tar];
			}
		} else if (tar < 0) {
			if (nqb[vidx][-tar] != null) {
				return nqb[vidx][-tar];
			}
		}

		boolean resyes = targetSum(arr, vidx + 1, tar - arr[vidx], pqb, nqb);
		boolean resno = targetSum(arr, vidx + 1, tar, pqb, nqb);

		if (tar >= 0) {
			pqb[vidx][tar] = resno || resyes;
			return pqb[vidx][tar];
		} else {
			nqb[vidx][-tar] = resno || resyes;
			return nqb[vidx][-tar];
		}
	}

	// max price in the bag
	public static int knapSack(int[] wts, int[] prices, int cap) {
		int[][] strg = new int[wts.length][cap + 1];

		for (int r = 0; r < strg.length; r++) {
			for (int c = 0; c < strg[r].length; c++) {
				// r is the item, and c is the capacity
				if (c == 0) { // capacity is 0
					strg[r][c] = 0;
				} else if (r == 0) {
					if (wts[r] <= c) {
						strg[r][c] = prices[r];
					}
				} else {
					int maxPriceYes = Integer.MIN_VALUE;
					if (wts[r] <= c) {
						maxPriceYes = strg[r - 1][c - wts[r]] + prices[r];
					}

					int maxPriceNo = strg[r - 1][c] + 0;

					strg[r][c] = Math.max(maxPriceNo, maxPriceYes);
				}
			}
		}

		return strg[strg.length - 1][strg[0].length - 1];
	}

	public static int lcs(String s1, String s2, int[][] qb) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (qb[s1.length()][s2.length()] != 0) {
			return qb[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);

		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);

		if (ch1 == ch2) {
			qb[s1.length()][s2.length()] = 1 + lcs(ros1, ros2, qb);
		} else {
			int f1 = lcs(s1, ros2, qb);
			int f2 = lcs(ros1, s2, qb);

			qb[s1.length()][s2.length()] = Math.max(f1, f2);
		}

		return qb[s1.length()][s2.length()];
	}

	public static int lps(String s, int si, int ei, int[][] qb) {
		if (si == ei) {
			return 1;
		} else if (si > ei) {
			return 0;
		}

		if (qb[si][ei] != 0) {
			return qb[si][ei];
		}

		char chf = s.charAt(si);
		char che = s.charAt(ei);

		int ans = 0;

		if (chf == che) {
			ans = 2 + lps(s, si + 1, ei - 1, qb);
		} else {
			int f1 = lps(s, si + 1, ei, qb);
			int f2 = lps(s, si, ei - 1, qb);
			ans = Math.max(f1, f2);
		}

		qb[si][ei] = ans;
		return ans;
	}

	public static int editDistance(String s1, String s2, int[][] qb) {
		if(s1.length() == 0){
			return s2.length(); // add
		}
		
		if(s2.length() == 0){
			return s1.length(); // remove
		}
		
		if(qb[s1.length()][s2.length()] != 0){
			return qb[s1.length()][s2.length()];
		}
		
		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);

		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);

		int ans = 0;
		
		if (ch1 == ch2) {
			ans = editDistance(ros1, ros2, qb);
		} else {
			int fadd = 1 + editDistance(s1, ros2, qb);
			int frep = 1 + editDistance(ros1, ros2, qb);
			int frem = 1 + editDistance(ros1, s2, qb);

			ans = Math.min(fadd, Math.min(frep, frem));
		}

		qb[s1.length()][s2.length()] = ans;
		return ans;
	}

}

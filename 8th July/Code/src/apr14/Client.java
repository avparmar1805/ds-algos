package apr14;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
		// int n = 30;

		// long start = System.currentTimeMillis();
		// System.out.println(Fib(n));
		// System.out.println(FibMem(n, new int[n + 1]));
		// System.out.println(fibI(n));
		// System.out.println(fibSlider(n));
		// System.out.println(cbpmem(0, n, new int[n + 1]));
		// System.out.println(cmpmem(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(cbpi(n));
		// System.out.println(cbpSlider(n));
		// System.out.println(cmpi(n, n));
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);

//		int[][] arr = { { 1, 2, 3, 1 }, { 2, 0, 5, 2 }, { 7, 1, 1, 1 }, { 0, 0, 4, 2 } };
//		System.out.println(mcp(arr, 0, 0, new int[arr.length + 1][arr[0].length + 1]));
//		mcpTab(arr);
		
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
		lisTab(arr);
	}

	static int counter = 0;

	public static int Fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = Fib(n - 1);
		int fnm2 = Fib(n - 2);
		int fn = fnm1 + fnm2;

		counter++;
		System.out.println(counter + ". f(" + n + ") = " + fn);
		return fn;
	}

	public static int FibMem(int n, int[] qb) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (qb[n] != 0) {
			return qb[n];
		}

		int fnm1 = FibMem(n - 1, qb);
		int fnm2 = FibMem(n - 2, qb);
		int fn = fnm1 + fnm2;

		qb[n] = fn;
		return fn;
	}

	public static int cbp(int s, int d) {
		if (s == d) {
			return 1;
		}

		int cstod = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int i = s + dice;
			if (i <= d) {
				int citod = cbp(i, d);
				cstod += citod;
			}
		}

		return cstod;
	}

	public static int cbpmem(int s, int d, int[] qb) {
		if (s == d) {
			return 1;
		}

		if (qb[s] != 0) {
			return qb[s];
		}

		int cstod = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int i = s + dice;
			if (i <= d) {
				int citod = cbpmem(i, d, qb);
				cstod += citod;
			}
		}

		qb[s] = cstod;
		return cstod;
	}

	public static int cmp(int sr, int sc, int dr, int dc) {
		if (sr == dr && sc == dc) {
			return 1;
		}

		int cstod = 0;
		int chtod = 0;
		int cvtod = 0;

		if (sc < dc) {
			chtod = cmp(sr, sc + 1, dr, dc);
		}

		if (sr < dr) {
			cvtod = cmp(sr + 1, sc, dr, dc);
		}

		cstod = chtod + cvtod;

		return cstod;
	}

	public static int cmpmem(int sr, int sc, int dr, int dc, int[][] qb) {
		if (sr == dr && sc == dc) {
			return 1;
		}

		if (qb[sr][sc] != 0) {
			return qb[sr][sc];
		}

		int cstod = 0;
		int chtod = 0;
		int cvtod = 0;

		if (sc < dc) {
			chtod = cmpmem(sr, sc + 1, dr, dc, qb);
		}

		if (sr < dr) {
			cvtod = cmpmem(sr + 1, sc, dr, dc, qb);
		}

		cstod = chtod + cvtod;

		counter++;
		System.out.println(counter + ". f(" + sr + ", " + sc + ") = " + cstod);
		qb[sr][sc] = cstod;
		return cstod;
	}

	public static int fibI(int n) {
		int[] f = new int[n + 1];

		f[0] = 0;
		f[1] = 1;

		for (int x = 2; x < f.length; x++) {
			f[x] = f[x - 1] + f[x - 2];
		}

		return f[n];
	}

	public static int cbpi(int n) {
		int[] f = new int[n + 1];

		f[n] = 1;
		for (int x = n - 1; x >= 0; x--) {
			for (int dice = 1; dice <= 6; dice++) {
				if (x + dice < f.length) {
					f[x] += f[x + dice];
				}
			}
		}

		return f[0];
	}

	public static int cmpi(int dr, int dc) {
		int[][] arr = new int[dr + 1][dc + 1];

		for (int r = dr; r >= 0; r--) {
			for (int c = dc; c >= 0; c--) {
				int rp1 = r + 1;
				int cp1 = c + 1;

				if (r == dr && c == dc) {
					// last cell
					arr[r][c] = 1;
				} else if (r == dr) {
					// last row except last cell
					arr[r][c] = arr[r][cp1];
				} else if (c == dc) {
					// last column except last cell
					arr[r][c] = arr[rp1][c];
				} else {
					arr[r][c] = arr[r][cp1] + arr[rp1][c];
				}
			}
		}

		return arr[0][0];
	}

	public static int fibSlider(int n) {
		int[] s = new int[2];

		s[0] = 0; // f0
		s[1] = 1; // f1

		for (int slideCount = 1; slideCount <= n; slideCount++) {
			// before s0 <- fx, s1 <- fxp1
			int nv = s[0] + s[1]; // nv <- fxp2
			s[0] = s[1]; // s0 <- fxp1
			s[1] = nv; // s1 <- fxp2
			// after s0 <- fxp1, s1 <- fxp2
		}

		return s[0];
	}

	public static int cbpSlider(int n) {
		int[] s = new int[6];

		s[0] = 1; // s0 is fn
		s[1] = 0; // s1 is fnp1
		s[2] = 0; // s2 is fnp2
		s[3] = 0; // s3 is fnp3
		s[4] = 0; // s4 is fnp4
		s[5] = 0; // s5 is fnp5

		for (int cs = 1; cs <= n; cs++) {
			int nv = s[0] + s[1] + s[2] + s[3] + s[4] + s[5];
			s[5] = s[4];
			s[4] = s[3];
			s[3] = s[2];
			s[2] = s[1];
			s[1] = s[0];
			s[0] = nv;
		}

		return s[0];
	}

	public static int mcp(int[][] arr, int sr, int sc, int[][] qb) {
		if (sr == arr.length - 1 && sc == arr[0].length - 1) {
			return arr[sr][sc];
		}

		if (qb[sr][sc] != 0) {
			return qb[sr][sc];
		}

		int ch = Integer.MAX_VALUE;
		int cv = Integer.MAX_VALUE;

		if (sc + 1 < arr[0].length) {
			ch = mcp(arr, sr, sc + 1, qb);
		}

		if (sr + 1 < arr.length) {
			cv = mcp(arr, sr + 1, sc, qb);
		}

		int mycost = Math.min(ch, cv) + arr[sr][sc];

		// counter++;
		// System.out.println(counter + " " + sr + " " + sc );
		qb[sr][sc] = mycost;
		return mycost;
	}

	public static void mcpTab(int[][] cost) {
		int[][] min = new int[cost.length][cost[0].length];
		String[][] path = new String[cost.length][cost[0].length];

		for (int r = cost.length - 1; r >= 0; r--) {
			for (int c = cost[0].length - 1; c >= 0; c--) {
				int r1 = r + 1;
				int c1 = c + 1;

				if(r == cost.length - 1 && c == cost[0].length - 1){
					min[r][c] = cost[r][c];
					path[r][c] = "";
				} else if(r == cost.length - 1){
					min[r][c] = min[r][c1] + cost[r][c];
					path[r][c] = "H" + path[r][c1];
				} else if(c == cost[0].length - 1){
					min[r][c] = min[r1][c] + cost[r][c];
					path[r][c] = "V" + path[r1][c];
				} else {
					if(min[r1][c] < min[r][c1]){
						min[r][c] = min[r1][c] + cost[r][c];
						path[r][c] = "V" + path[r1][c];
					} else {
						min[r][c] = min[r][c1] + cost[r][c];
						path[r][c] = "H" + path[r][c1];
					}
				}
			}
		}
		
		System.out.println(min[0][0] + " via " + path[0][0]);
	}

	public static void lisTab(int[] arr){
		int[] lengthListEndingAt = new int[arr.length];
		String[] contentLisEndingAt = new String[arr.length];
		
		lengthListEndingAt[0] = 1;
		contentLisEndingAt[0] = arr[0] + "";
		
		int overallLongestLISLength = Integer.MIN_VALUE;
		String overAllLongestLIS = "";
		
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					if(lengthListEndingAt[j] > lengthListEndingAt[i]){
						lengthListEndingAt[i] = lengthListEndingAt[j];
						contentLisEndingAt[i] = contentLisEndingAt[j];
					}
				}
			}
			
			lengthListEndingAt[i]++;
			contentLisEndingAt[i] += " " + arr[i];
			
			if(lengthListEndingAt[i] > overallLongestLISLength){
				overallLongestLISLength = lengthListEndingAt[i];
				overAllLongestLIS = contentLisEndingAt[i];
			}
		}
		
		System.out.println(overAllLongestLIS);
		System.out.println(overallLongestLISLength);
	}
}

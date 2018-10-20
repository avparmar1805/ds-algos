package apr22;

public class mpc {

	public static void main(String[] args) {
//		String str = "abccbc";
//		int[][] qb = new int[str.length()][str.length()];
//		boolean[][] pssmatrix = palindromicSSMatrix(str);
//		System.out.println(mpc(str, 0, str.length() - 1, qb, pssmatrix));
		
		int[] dims = {10, 20, 30, 40, 50, 60};
		System.out.println(mcm(dims, 0, dims.length - 1, new int[dims.length][dims.length]));
	}
	
	static int counter = 0;
	public static int mpc(String str, int si, int ei, 
						  int[][] qb, boolean[][] pssmatrix){
		if(pssmatrix[si][ei] == true){
			return 0;
		}
		
		if(qb[si][ei] != 0){
			return qb[si][ei];
		}
		
		int min = Integer.MAX_VALUE;
		for(int cp = si; cp < ei; cp++){
			int lmpc = mpc(str, si, cp, qb, pssmatrix);
			int rmpc = mpc(str, cp + 1, ei, qb, pssmatrix);
			int tmpc = lmpc + rmpc + 1;
			
			if(tmpc < min){
				min = tmpc;
			}
		}
		
		qb[si][ei] = min;
		return min;
	}

	public static boolean[][] palindromicSSMatrix(String str){
		boolean[][] mat = new boolean[str.length()][str.length()];
		
		for(int gap = 0; gap <= str.length() - 1; gap++){
			int si = 0;
			int ei = si + gap;
			
			while(ei <= str.length() - 1){
				if(gap == 0){
					mat[si][ei] = true;
				} else if(gap == 1){
					mat[si][ei] = str.charAt(si) == str.charAt(ei);
				} else {
					mat[si][ei] = str.charAt(si) == str.charAt(ei) &&
								  mat[si + 1][ei - 1] == true;
				}
				
				si++;
				ei++;
			}
		}
		
		return mat;
	}

	public static int mcm(int[] dims, int si, int ei, int[][] qb){
		if(si + 1 == ei){
			return 0;
		}
		
		if(qb[si][ei] != 0){
			return qb[si][ei];
		}
		
		int min = Integer.MAX_VALUE;
		for(int cp = si + 1; cp <= ei - 1; cp++){
			int lpc = mcm(dims, si, cp, qb);
			int rpc = mcm(dims, cp, ei, qb);
			int pc = dims[si] * dims[ei] * dims[cp];
			int tc = lpc + rpc + pc;
			
			if(tc < min){
				min = tc;
			}
		}
		
		qb[si][ei] = min;
		return min;
	}
}

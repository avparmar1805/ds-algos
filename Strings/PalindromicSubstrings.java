package Strings;

public class PalindromicSubstrings {
	public static void main(String[] args) {
		String str = "abaaba";
		int n = str.length();
		boolean[][] arr = new boolean[n][n];
		palindromicSubstrings(arr);
	}

	public static void Display(boolean[][] arr) {
		for (int i = 0; i <= arr.length - 1; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void palindromicSubstrings(boolean[][] arr) {

		// Make boxes = true where si=ei
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i == j) {
					arr[i][j] = true;
				}
			}
		}
		
		for (int len = 1; len <= arr.length; len++) {
			  //System.out.print("len = " + len);
			for (int idx = 0; idx + len - 1 < arr.length; idx++) {
				int si = idx;
				int ei = idx + len - 1;
				if(ei < arr.length) {
					arr[si][ei] = true;
				}
				//System.out.print(" si= " + si + " ei= " + ei + " ");
			} 
			//System.out.println();
		}
		//Display(arr);
	}
}

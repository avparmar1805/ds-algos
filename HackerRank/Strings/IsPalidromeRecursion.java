package Strings;

public class IsPalidromeRecursion {
	public static void main(String[] args) {
		String str = "abccba";
		boolean isPal = isPalidrome(str, 0, str.length() - 1);
		System.out.println(isPal);
	}

	private static boolean isPalidrome(String str, int lo, int hi) {

		if(lo >= hi) {
			return true;
		}
		
		boolean isPal = isPalidrome(str, lo + 1, hi - 1);

		if (!isPal) {
			return false;
		} else {
			if (str.charAt(lo) == str.charAt(hi)) {
				return true;
			} 
			return false;
		}
	}
}

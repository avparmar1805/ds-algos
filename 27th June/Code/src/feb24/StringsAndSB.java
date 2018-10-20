package feb24;

public class StringsAndSB {

	public static void main(String[] args) {
//		printallSS("abcd");
//
//		String s1 = "abcd";
//		String s2 = "def";
//		System.out.println(s1.equals(s2));
		stringUnderStress(100000);
	}

	public static void printallSS(String s) {
		for (int si = 0; si < s.length(); si++) {
			for (int ei = si + 1; ei <= s.length(); ei++) {
				System.out.println(s.substring(si, ei));
			}
		}
	}

	public static boolean IsPlaindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	public static void printAllPalindromicSS(String s) {
		for (int si = 0; si < s.length(); si++) {
			for (int ei = si + 1; ei <= s.length(); ei++) {
				String ss = s.substring(si, ei);
				boolean res = IsPlaindrome(ss);

				if (res == true) {
					System.out.println(ss);
				}
			}
		}
	}

	public static void stringUnderStress(int n) {
		long start = System.currentTimeMillis();

		StringBuilder sb = new StringBuilder();
//		String s = "";
//		int j = 0;
		for (int i = 0; i < n; i++) {
			sb.append(i);
//			s = s + i;
//			 j = j + i;
		}

		long end = System.currentTimeMillis();
		System.out.println(end - start);
		// System.out.println(s);
	}

}

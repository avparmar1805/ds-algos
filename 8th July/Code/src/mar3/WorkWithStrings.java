package mar3;

public class WorkWithStrings {

	public static void main(String[] args) {
		// String s = "hello";
		// System.out.println(s);
		// System.out.println(s.length());
		// System.out.println(s.charAt(2));
		// System.out.println(s.substring(1, 3));
		// printAllPalindromicSS1("abaaba");

		// Conceptual Theory
//		String s1 = "hello";
//		String s2 = "hello";
//		String s3 = s1;
//		String s4 = new String("hello");
//
//		System.out.println((s2 == s1) + " " + s2.equals(s1));
//		System.out.println((s3 == s1) + " " + s3.equals(s1));
//		System.out.println((s4 == s1) + " " + s4.equals(s1));
//		
//		System.out.println(s1);
//		s1 = "bye";
//		System.out.println(s1);
		stringsPerformanceTest(100000);
	}

	public static void printChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}

	public static void printAllSubstrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}

	public static boolean IsPalindrome(String str) {
		int li = 0;
		int ri = str.length() - 1;

		while (li < ri) {
			if (str.charAt(li) != str.charAt(ri)) {
				return false;
			}
			li++;
			ri--;
		}

		return true;
	}

	public static void printAllPalindromicSS(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String stocheck = str.substring(i, j);
				boolean ispalin = IsPalindrome(stocheck);
				if (ispalin == true) {
					System.out.println(stocheck);
				}
			}
		}
	}

	public static void printAllPalindromicSS1(String str) {
		boolean[][] strg = new boolean[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0; i + gap < str.length(); i++) {
				if (gap == 0) {
					strg[i][i + gap] = true;
				} else if (gap == 1) {
					strg[i][i + gap] = str.charAt(i) == str.charAt(i + gap);
				} else {
					strg[i][i + gap] = (str.charAt(i) == str.charAt(i + gap)) && strg[i + 1][i + gap - 1] == true;
				}

				if (strg[i][i + gap] == true) {
					System.out.println(i + " " + (i + gap));
				}
			}
		}

	}

	public static void stringsPerformanceTest(int n){
//		String s = "";
		StringBuilder sb = new StringBuilder();
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
//			s = s + i;
			sb.append(i);
		}
		long end = System.currentTimeMillis();
		
//		System.out.println(sb);
		System.out.println(end - start);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

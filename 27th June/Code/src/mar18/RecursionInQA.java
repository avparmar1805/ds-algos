package mar18;

public class RecursionInQA {

	public static void main(String[] args) {


		// printSS("abc", "");
		// printKPWords("157", "");
//		printPermutations("abc", "");
		printBP(0, 10, "");
	}

	public static void printSS(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, asf + ch); // yes
		printSS(roq, asf + ""); // no
	}

	public static void printSSWAscii(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSSWAscii(roq, asf + (int) ch); // ascii
		printSSWAscii(roq, asf + ch); // yes
		printSSWAscii(roq, asf + ""); // no

	}

	static String[] codes = { "abc", "de", "fgh", "ijkl", "m", "nop", "qrs", "tuv", "wxyz", "." };

	public static void printKPWords(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String chOptions = codes[ch - '0'];
		for (int i = 0; i < chOptions.length(); i++) {
			char option = chOptions.charAt(i);
			printKPWords(roq, asf + option);
		}

	}

	public static void printPermutations(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= asf.length(); i++) {
			StringBuilder sb = new StringBuilder(asf);
			sb.insert(i, ch);
			printPermutations(roq, sb.toString());
		}
	}

	public static void printBP(int s, int d, String asf) {
		if(s == d){
			System.out.println(asf);
			return;
		}
		
		
		for (int dice = 1; dice <= 6; dice++) {
			if (s + dice <= d) {
				printBP(s + dice, d, asf + dice);
			}
		}
	}

}

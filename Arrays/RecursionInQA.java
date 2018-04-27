package Arrays;

public class RecursionInQA {

	public static void main(String[] args) {
		// printSubSeq("abc", "");
		// printSSeqAscii("ab", "");
		// printKPWords("157", "");
		permutations("abc", "");
	}

	static String[] codes = { "abc", "de", "fgh", "ijkl", "m", "nop", "qrs", "tuv", "wxyz" };

	public static void permutations(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char currChar = ques.charAt(i);
			StringBuilder strB = new StringBuilder(ques);
			String roq = strB.deleteCharAt(i).toString();

			permutations(roq, asf + currChar);
		}

	}

	public static void printKPWords(String ques, String asf) {

		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}

		char currChar = ques.charAt(0);
		String roq = ques.substring(1);
		String currStr = codes[currChar - '0'];

		for (int i = 0; i < currStr.length(); i++) {
			printKPWords(roq, asf + currStr.charAt(i));
		}

	}

	public static void printSubSeq(String ques, String asf) {

		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}

		char currChar = ques.charAt(0);
		String roq = ques.substring(1);

		printSubSeq(roq, asf + ""); // no case
		printSubSeq(roq, asf + currChar); // yes case
	}

	public static void printSSeqAscii(String inputString, String answerSoFar) {

		if (inputString.length() == 0) {
			System.out.println(answerSoFar);
			return;
		}

		char firstChar = inputString.charAt(0);
		String ros = inputString.substring(1);

		printSSeqAscii(ros, answerSoFar + ""); // no case
		printSSeqAscii(ros, answerSoFar + firstChar); // yes case
		printSSeqAscii(ros, answerSoFar + (int) firstChar);
	}
}

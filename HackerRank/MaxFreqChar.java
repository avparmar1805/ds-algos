
public class MaxFreqChar {
	public static void main(String[] args) {
		MFC("aaaabbccccc");
	}

	public static void MFC(String str) {

		char mFChar = str.charAt(0);
		int countMFChar = 1;

		char currChar = str.charAt(0);
		int countCurrChar = 1;

		int counter = 1;
		for (counter = 1; counter < str.length(); counter++) {

			if (str.charAt(counter) == currChar) {
				countCurrChar++;
			} else {
				if (countCurrChar > countMFChar) {
					countMFChar = countCurrChar;
					mFChar = currChar;
				}
				countCurrChar = 1;
			}
			currChar = str.charAt(counter);
		}
		if (counter == str.length()) {
			if (countCurrChar > countMFChar) {
				countMFChar = countCurrChar;
				mFChar = currChar;
			}
		}
		System.out.println(mFChar);
	}
}

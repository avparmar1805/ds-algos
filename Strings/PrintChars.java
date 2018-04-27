package Strings;

public class PrintChars {
	public static void main(String[] args) {
		String strToPrint = "abnitincd";

		// printCharacters(strToPrint);
		// printAllSubStrings(strToPrint);
		// isPalindrome(strToPrint);
		findPalindromicSubStrings(strToPrint);

	}

	public static void findPalindromicSubStrings(String strToPrint) {
		for (int i = 0; i < strToPrint.length(); i++) {
			for (int j = i + 1; j <= strToPrint.length(); j++) {
				String s = strToPrint.substring(i, j);
				if (isPalindrome(s) && s.length() > 1) {
					System.out.println(s);
				}
			}
		}
	}

	public static boolean isPalindrome(String strToPrint) {
		int startIndex = 0;
		int endIndex = strToPrint.length() - 1;
		while (startIndex < endIndex) {
			if (strToPrint.charAt(startIndex) != strToPrint.charAt(endIndex)) {
				// System.out.println("Not palindrome");
				return false;

			}
			startIndex++;
			endIndex--;
		}

		if (startIndex >= endIndex) {
			// System.out.println("palindrome");
			return true;
		}

		return false;
	}

	public static void printAllSubStrings(String strToPrint) {
		for (int i = 0; i < strToPrint.length(); i++) {
			for (int j = i + 1; j <= strToPrint.length(); j++) {
				System.out.println(strToPrint.substring(i, j));
			}
		}
	}

	public static void printCharacters(String strToPrint) {
		for (int i = 0; i < strToPrint.length(); i++) {
			System.out.println(strToPrint.charAt(i));
		}
	}
}

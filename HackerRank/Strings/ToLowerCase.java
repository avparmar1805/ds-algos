package Strings;

public class ToLowerCase {
	public static void main(String[] args) {
		ToLower("AbcFDE");
	}

	private static void ToLower(String str) {
		String retVal = "";
		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if ((int) currChar >= 65 & (int) currChar <= 90)
				retVal += (char) (currChar + 32);
			else
				retVal += currChar;
		}
		System.out.println(retVal);
	}
}

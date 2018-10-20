package Strings;

import java.util.HashMap;
import java.util.Map.Entry;

public class Anagrams {
	public static void main(String args[]) {
		System.out.println(AreAnagrams("geeks", "skesg"));
	}

	public static boolean AreAnagrams(String str1, String str2) {

		boolean retVal = true;

		if (str1.length() != str2.length()) {
			return false;
		}
		HashMap<Character, Integer> mapChars = new HashMap();

		for (int i = 0; i < str1.length(); i++) {
			char currChar = str1.charAt(i);
			if (mapChars.containsKey(currChar)) {
				int val = mapChars.get(currChar) + 1;
				mapChars.put(currChar, val);
			} else {
				mapChars.put(currChar, 1);
			}
		}
		int i = 0;
		for (i = 0; i < str2.length(); i++) {
			char currChar = str2.charAt(i);

			if (mapChars.containsKey(currChar)) {
				int val = mapChars.get(currChar) - 1;
				mapChars.put(currChar, val);
			} else {
				break;
			}
		}
		if (i != str2.length()) {
			return false;
		}
		for (Entry<Character, Integer> entry : mapChars.entrySet()) {
			if (entry.getValue() > 0) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				retVal = false;
			}
		}

		return retVal;
	}
}

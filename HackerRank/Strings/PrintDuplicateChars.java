package Strings;

import java.util.HashMap;
import java.util.Map.Entry;

public class PrintDuplicateChars {
	public static void main(String[] args) {
		String str = "JAVA";
		PrintDupChars(str);
	}

	public static void PrintDupChars(String str) {

		HashMap<Character, Integer> mapChars = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);

			if (mapChars.containsKey(currChar)) {
				int val = mapChars.get(currChar) + 1;
				mapChars.put(currChar, val);
			} else {
				mapChars.put(currChar, 1);
			}
		}

		for (Entry<Character, Integer> entry : mapChars.entrySet()) {
			if (entry.getValue() > 1)
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}
}

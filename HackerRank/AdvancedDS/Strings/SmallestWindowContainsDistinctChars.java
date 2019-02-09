package AdvancedDS.Strings;

import java.util.Arrays;
import java.util.HashMap;

public class SmallestWindowContainsDistinctChars {

	public static void main(String args[]) {
		String word = "aabcbcdbca";

		int distinctLettersLength = getDistinctLetters(word);
		System.out.println(gogImplementation(word, distinctLettersLength));
		// swcdc(word, distinctLettersLength);
	}

	public static int getDistinctLetters(String word) {

		int distinctLettersLength = 0;
		boolean[] visited = new boolean[256];
		Arrays.fill(visited, false);

		for (int i = 0; i < word.length(); i++) {

			char currChar = word.charAt(i);
			if (!visited[currChar]) {
				visited[currChar] = true;
				distinctLettersLength++;
			}
		}
		return distinctLettersLength;
	}

	public static String gogImplementation(String word, int distinctCount) {
		int start = 0;
		int startIndex = 0;
		int count = 0;
		int[] currCount = new int[256];
		int minLength = Integer.MAX_VALUE;

		for (int i = 0; i < word.length(); i++) {

			currCount[word.charAt(i)]++;

			if (currCount[word.charAt(i)] == 1) {
				count++;
			}
			
			if(count == distinctCount) {
				while(currCount[word.charAt(start)] > 1) {
					if(currCount[word.charAt(start)] > 1) {
						currCount[word.charAt(start)]--;
					}
					start++;
				}
				
				int currLength = i - start + 1;
				
				if(minLength > currLength) {
					minLength = currLength;
					startIndex = start;
				}
			}
		}
		return word.substring(startIndex, startIndex+minLength);
	}

	public static void swcdc(String word, int distinctLettersLength) {
		int cmins = 0;
		int cmine = 0;
		int omins = 0;
		int omine = 0;
		int wc = distinctLettersLength;
		HashMap<Character, Integer> hMap = new HashMap();
		for (int i = 0; i < word.length(); i++) {
			char currChar = word.charAt(i);
			if (!hMap.containsKey(currChar)) {
				hMap.put(currChar, 0);
				wc--;
			}

			cmine = i;
			if (wc == 0) {
				omins = cmins;
				omine = cmine;
				wc = distinctLettersLength - 1;
				hMap = new HashMap();
				cmins = cmine;
			}
		}

	}

}

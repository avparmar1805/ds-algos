package Arrays;

import java.util.HashMap;

public class HighestFrequencyChar {
	public static void main(String[] args) {

		String str = "abracadabra";
		HashMap<Character, Integer> hMap = new HashMap();
		for (int i = 0; i < str.length(); i++) {
			Character currChar = str.charAt(i);

			if (hMap.containsKey(currChar)) {
				hMap.put(currChar, hMap.get(currChar) + 1);
			} else {
				hMap.put(currChar, 1);
			}
		}
		int max = 0;
		Character maxChar = 0;
		for (Character key : hMap.keySet()) {
			if(hMap.get(key) > max) {
				max = hMap.get(key);
				maxChar = key;
			}
		}
		
		System.out.println("Max char = " + maxChar + " times " + max);
	}
}

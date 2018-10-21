package HashStory;

import java.util.HashMap;

//keySet

public class Client {
	public static void main(String[] args) {
		String str = "abracadabra";
		// highestFreqChar(str.toCharArray());
		Integer[] one = { 2, 1, 3, 2, 5, 2, 1 };
		Integer[] two = { 4, 5, 1, 2, 1, 2, 1 };
		// gec1(one, two);
		// gec2(one, two);
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		longestSubCount(arr);
	}

	public static void highestFreqChar(char[] str) {
		HashMap<Character, Integer> hmap = new HashMap();
		for (int i = 0; i < str.length; i++) {

			if (hmap.containsKey(str[i])) {
				int val = hmap.get(str[i]);
				hmap.put(str[i], ++val);
			} else {
				hmap.put(str[i], 1);
			}
		}

		System.out.println(hmap);
		int max = 0;
		char maxChar = 0;
		for (Character key : hmap.keySet()) {
			if (hmap.get(key) > max) {
				max = hmap.get(key);
				maxChar = key;
			}
		}

		System.out.println("maxChar => " + maxChar + " max =" + max);
	}

	public static void gec1(Integer[] one, Integer[] two) {
		HashMap<Integer, Integer> hmap1 = new HashMap();
		HashMap<Integer, Integer> hmap2 = new HashMap();

		for (int i = 0; i < one.length; i++) {
			hmap1.put(one[i], 1);
		}
		for (int i = 0; i < two.length; i++) {
			hmap2.put(two[i], 1);
		}

		for (Integer key : hmap1.keySet()) {
			if (hmap2.containsKey(key)) {
				System.out.println("Key => " + key);
			}
		}
	}

	public static void gec2(Integer[] one, Integer[] two) {
		HashMap<Integer, Integer> hmap1 = new HashMap();
		HashMap<Integer, Integer> hmap2 = new HashMap();

		for (int i = 0; i < one.length; i++) {
			hmap1.put(one[i], hmap1.containsKey(one[i]) ? hmap1.get(one[i]) + 1 : 1);
		}
		for (int i = 0; i < two.length; i++) {
			hmap2.put(two[i], hmap2.containsKey(two[i]) ? hmap2.get(two[i]) + 1 : 1);
		}

		for (Integer key : hmap1.keySet()) {
			if (hmap2.containsKey(key)) {
				if (hmap1.get(key) > hmap2.get(key)) {
					// System.out.println(key + "," + hmap2.get(key));
					for (int i = 0; i < hmap2.get(key); i++) {
						System.out.print(key + ",");
					}
				} else {
					// System.out.println(key + "," + hmap1.get(key));
					for (int i = 0; i < hmap1.get(key); i++) {
						System.out.print(key + ",");
					}
				}
			}
		}
	}

	public static void longestSubCount(int[] arr) {
		HashMap<Integer, Boolean> hmap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			hmap.put(arr[i], true);
		}

		for (Integer key : hmap.keySet()) {
			if (hmap.containsKey(key - 1)) {
				hmap.put(key, false);
			}
		}

		int oCount = 0;

		int maxKey = 0;
		for (Integer key : hmap.keySet()) {
			int currCount = 0;
			if (hmap.get(key)) {
				Integer newKey = key + 1;
				while (hmap.containsKey(newKey)) {
					currCount += 1;
					newKey++;
				}
				if (currCount > oCount) {
					maxKey = key;
					oCount = currCount;
				}
			}
		}

		for (int i = maxKey; i <= maxKey + oCount; i++) {
			System.out.println(i);
		}
	}
}

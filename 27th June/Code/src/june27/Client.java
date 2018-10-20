package june27;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
		// HashMap<String, Integer> popmap = new HashMap<>();
		//
		// popmap.put("China", 200);
		// popmap.put("India", 120);
		// popmap.put("Pakistan", 80);
		// popmap.put("US", 20);
		// popmap.put("UK", 15);
		// popmap.put("Nigeria", 50);
		//
		// System.out.println(popmap);
		//
		// System.out.println(popmap.get("India"));
		// System.out.println(popmap.get("Utopia"));
		//
		// popmap.put("US", 25);
		// System.out.println(popmap);
		//
		// popmap.put("Uganda", 30);
		// System.out.println(popmap);
		//
		// System.out.println(popmap.containsKey("India"));
		// System.out.println(popmap.containsKey("Utopia"));
		//
		// ArrayList<String> keys = new ArrayList<>(popmap.keySet());
		// System.out.println(keys);
		//
		// System.out.println(popmap.remove("Pakistan"));
		// System.out.println(popmap);
		//
		// System.out.println(popmap.remove("Pakistan"));
		// System.out.println(popmap);

//		System.out.println(highestFrequency("aabbbbccbcccdda"));
//		int[] one = { 1, 1, 2, 2, 2, 3, 5 };
//		int[] two = { 1, 1, 1, 2, 2, 4, 5 };
//		System.out.println(gce2(one, two));
		int[] nums = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
		lcseq(nums);
	}

	public static Character highestFrequency(String word) {
		HashMap<Character, Integer> fmap = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			fmap.put(ch, fmap.containsKey(ch) ? fmap.get(ch) + 1 : 1);
		}

		System.out.println(fmap);

		Character maxC = ' ';
		int maxf = Integer.MIN_VALUE;

		ArrayList<Character> keys = new ArrayList<>(fmap.keySet());
		for (Character key : keys) {
			int freqC = fmap.get(key);
			if (freqC > maxf) {
				maxf = freqC;
				maxC = key;
			}
		}

		return maxC;

	}

	public static ArrayList<Integer> gce1(int[] one, int[] two) {
		ArrayList<Integer> res = new ArrayList<>();

		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int val : one) {
			fmap.put(val, fmap.containsKey(val) ? fmap.get(val) + 1 : 1);
		}

		for (int val : two) {
			if (fmap.containsKey(val)) {
				res.add(val);
				fmap.remove(val);
			}
		}

		return res;
	}

	public static ArrayList<Integer> gce2(int[] one, int[] two) {
		ArrayList<Integer> res = new ArrayList<>();

		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (int val : one) {
			fmap.put(val, fmap.containsKey(val) ? fmap.get(val) + 1 : 1);
		}

		for (int val : two) {
			if (fmap.containsKey(val) && fmap.get(val) > 0) {
				res.add(val);
				fmap.put(val, fmap.get(val) - 1);
			}
		}

		return res;
	}

	public static void lcseq(int[] nums) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int val : nums) {
			map.put(val, true);
		}

		for (int val : nums) {
			map.put(val, !map.containsKey(val - 1));
		}

		int oseql = 0;
		int oseqsp = 0;

		for (int val : nums) {
			if (map.get(val) == true) { // only start of sequences
				int cseql = 0;
				int csesp = val;

				while (map.containsKey(csesp + cseql) == true) {
					cseql++;
				}
				
				if(cseql > oseql){
					oseqsp = csesp;
					oseql = cseql;
				}
			}
		}
		
		for(int i = 0; i < oseql; i++){
			System.out.println(oseqsp + i);
		}
	}
}

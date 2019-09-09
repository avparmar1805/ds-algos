package Arrays;

import java.util.HashMap;

public class LongestContinuousSubSequenceInArr {
	public static void main(String[] args) {
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };

		HashMap<Integer, Boolean> hMap = new HashMap();

		for (int i = 0; i < arr.length; i++) {
			hMap.put(arr[i], true);
		}
		int oCount = 0;
		int startingKey = 0;
		for (Integer key : hMap.keySet()) {
			if (hMap.get(key)) {
				int currKeyCount = 0;
				int nextKey = key + 1;
				while (hMap.containsKey(nextKey)) {
					currKeyCount++;
					nextKey++;
				}
				if (currKeyCount > oCount) {
					oCount = currKeyCount;
					startingKey = key;
				}
			}
		}
		for (int i = startingKey; i <= startingKey + oCount; i++) {
			System.out.println(i);
		}
	}
}

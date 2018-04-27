package Arrays;

public class PlaceZerosAndOnes {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 0, 1, 1, 0 };
		// arr = Sort01(arr);
		int[] arr2 = { 1, 2, 0, 1, 2 };
		// arr = Sort012(arr2);
		int[] arr3 = { 5, 0, 6, 0, 7, 0 };
		int[] preservedArray = preserveArray(arr3);
		for (int i = 0; i < preservedArray.length; i++) {
			// System.out.println(preservedArray[i]);
		}

		highestFrequency("abnnchdaaaaa");
	}

	public static void highestFrequency(String str) {

		int[] charArray = new int[26];
		int max = 0;
		int maxIndex = -1;

		for (int i = 0; i < str.length(); i++) {
			charArray[str.charAt(i) - 'a'] += 1;

		}
		for (int i = 0; i < charArray.length; i++) {
			if (max < charArray[i]) {
				max = charArray[i];
				maxIndex = i;
			}
		}
		System.out.println("Max char = " + (char) (maxIndex + 'a') + " occurs =>" + max);
	}

	public static int[] preserveArray(int[] arr) {

		int i = 0;
		int j = 0;

		while (i < arr.length) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
			i++;
		}

		return arr;
	}

	public static int[] Sort012(int[] arr) {
		int lo = 0; // where 0's are solved
		int mid = 0; // where 1's are solved
		int hi = arr.length - 1; // where 2's are solved

		// mid-high unresolved area
		while (mid <= hi) {
			if (arr[mid] == 0) {
				int temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;
				lo++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				int temp = arr[hi];
				arr[hi] = arr[mid];
				arr[mid] = temp;
				hi--;
			}
		}

		return arr;
	}

	public static int[] Sort01(int[] arr) {

		int leftCounter = 0;
		int rightCounter = arr.length - 1;

		while (leftCounter < rightCounter) {

			if (arr[leftCounter] == 0) {
				leftCounter++;
			}
			if (arr[rightCounter] == 1) {
				rightCounter--;
			}
			if (arr[leftCounter] == 1 && arr[rightCounter] == 0) {
				arr[leftCounter] = 0;
				arr[rightCounter] = 1;
				leftCounter++;
				rightCounter--;
			}
		}

		return arr;
	}
}

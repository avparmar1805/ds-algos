package Arrays;

public class Merge2SortedArrays {
	public static void main(String[] args) {
		int[] one = { 10, 20, 30, 40, 50 };
		int[] two = { 11, 21, 25, 35, 60 };
		// int[] third = merge2SortedArrays(one, two);

		int[] arrayToMergeSort = { 5, -4, 2, 3, 9, 10, 15, 7, 19 };
		// int[] sortedArray = mergeSort(arrayToMergeSort, 0, arrayToMergeSort.length -
		// 1);

		// System.out.println(getPolyVal(2, 3));

		int[] arr = { 55, 8, 6, 55, 2, 6, 8 };
		// System.out.println(getOnceOccuredNum(arr));
		int[] missingNumArray = { 1, 3, 2, 4, 4 };
		System.out.println(getMissingNum(missingNumArray));
	}

	public static int getMissingNum(int[] arr) {

		int shouldSumOfArray = (arr.length * (arr.length + 1)) / 2;

		int sumOfArray = 0;
		for (int value : arr) {
			sumOfArray += value;
		}

		int lessValue = arr.length - (shouldSumOfArray - sumOfArray);
		return lessValue;
	}

	public static int getOnceOccuredNum(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result ^= arr[i];
		}
		return result;
	}

	public static int getPolyVal(int x, int n) {
		int sum = 0;
		int coeff = n;
		int powx = x;
		for (int i = n; i >= 1; i--) {
			sum += coeff * powx;
			coeff--;
			powx *= x;
		}
		return sum;
	}

	public static int[] mergeSort(int[] arr, int low, int hi) {
		if (low == hi) {
			int[] ba = new int[1];
			ba[0] = arr[low];
			return ba;
		}

		int mid = (low + hi) / 2;
		int[] fHalf = mergeSort(arr, low, mid);
		int[] sHalf = mergeSort(arr, mid + 1, hi);

		int[] sortedArray = merge2SortedArrays(fHalf, sHalf);

		return sortedArray;
	}

	public static int[] merge2SortedArrays(int[] one, int[] two) {

		int sortedArrayLength = one.length + two.length;
		int[] sortedArray = new int[sortedArrayLength];

		int counter = 0;
		int oneCounter = 0;
		int twoCounter = 0;
		while (oneCounter < one.length && twoCounter < two.length) {
			if (one[oneCounter] < two[twoCounter]) {
				sortedArray[counter] = one[oneCounter];
				oneCounter++;
			} else {
				sortedArray[counter] = two[twoCounter];
				twoCounter++;
			}
			counter++;
		}

		while (oneCounter < one.length) {
			sortedArray[counter] = one[oneCounter];
			counter++;
			oneCounter++;
		}
		while (twoCounter < two.length) {
			sortedArray[counter] = two[twoCounter];
			counter++;
			twoCounter++;
		}

		return sortedArray;
	}
}

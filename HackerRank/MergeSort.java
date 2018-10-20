
public class MergeSort {
	public static void main(String[] args) {
		int[] arrToSort = { 9, 3, 2, 4, 1, 5, 7, 0, -1, -3 };
		int[] sortedArray = mergeSort(arrToSort, 0, arrToSort.length - 1);
		Display(sortedArray);
	}

	public static void Display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
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

	public static int[] merge2SortedArrays(int[] firstArr, int[] secondArr) {
		int firstCounter = 0;
		int secondCounter = 0;

		int[] sortedArray = new int[firstArr.length + secondArr.length];
		int sortedArrCounter = 0;

		while (firstCounter < firstArr.length && secondCounter < secondArr.length) {

			if (firstArr[firstCounter] < secondArr[secondCounter]) {
				sortedArray[sortedArrCounter] = firstArr[firstCounter];
				firstCounter++;
			} else {
				sortedArray[sortedArrCounter] = secondArr[secondCounter];
				secondCounter++;
			}
			sortedArrCounter++;
		}

		while (firstCounter < firstArr.length) {
			sortedArray[sortedArrCounter] = firstArr[firstCounter];
			firstCounter++;
			sortedArrCounter++;
		}
		while (secondCounter < secondArr.length) {
			sortedArray[sortedArrCounter] = secondArr[secondCounter];
			secondCounter++;
			sortedArrCounter++;
		}

		return sortedArray;
	}
}

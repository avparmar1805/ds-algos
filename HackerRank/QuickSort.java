
public class QuickSort {
	public static void main(String[] args) {
		int[] arrToSort = { 9, 3, 2, 4, 1, 5, 7, 0, -1, -3 };
		quickSort(arrToSort, 0, arrToSort.length - 1);
		MergeSort.Display(arrToSort);
	}

	private static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int pivot = arr[hi];
		int pivIdx = partition(arr, lo, hi, pivot);
		quickSort(arr, lo, pivIdx - 1);
		quickSort(arr, pivIdx + 1, hi);
	}

	private static int partition(int[] arr, int lo, int hi, int pivot) {
		int parIdx = lo;
		int itr = lo;

		while (itr <= hi) {
			if (arr[itr] <= pivot) {
				int temp = arr[itr];
				arr[itr] = arr[parIdx];
				arr[parIdx] = temp;

				itr++;
				parIdx++;
			} else {
				itr++;
			}
		}

		return parIdx - 1;
	}
}

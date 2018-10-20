package Arrays;

public class QuicksortAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -1, 3, -10, 4, -100, 10, 7 };
		quicksort(arr, 0, arr.length - 1);
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	private static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int pivotIdx = partition(arr, lo, hi);
		quicksort(arr, lo, pivotIdx - 1);
		quicksort(arr, pivotIdx + 1, hi);
	}

	private static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];
		int pIdx = 0;
		int itr = 0;

		while (itr <= hi) {
			if (arr[itr] <= pivot) { // area where numbers less than pivot are. 0 to pIdx-1
				int temp = arr[itr];
				arr[itr] = arr[pIdx];
				arr[pIdx] = temp;
				pIdx++;
				itr++;
			} else {
				itr++; // area where nums greater than pivot are. pIdx+1 to itr
			}
		}

		return pIdx - 1;
	}

}

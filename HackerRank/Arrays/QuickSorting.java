package Arrays;

public class QuickSorting {

	public static int arr[] = { 2, 10, 18, 4, 5, 8, 9, 7 };

	public static void main(String[] args) {

		quickSort(arr, 0, arr.length - 1);
		for (int a : arr) {
			System.out.print(" " + a);
		}
	}

	public static void quickSort(int arr[], int low, int high) {

		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1); // before Pi
			quickSort(arr, pi + 1, high); // before Pi
		}
	}

	public static int partition(int[] arr, int low, int high) {

		int pi = low, itr = low;
		int pivot = arr[high];

		while (itr <= high) {
			if (arr[itr] <= pivot) {
				swap(itr, pi);
				itr++;
				pi++;
			} else {
				itr++;
			}
		}
		System.out.println("partition index " + pi);
		return pi-1;
	}

	public static void swap(int a, int b) {

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

}

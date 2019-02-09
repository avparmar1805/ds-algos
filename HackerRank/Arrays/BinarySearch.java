package Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 0, 1, 2 };
		int data = 40;
		int pivot = findPivot(arr, 0, arr.length - 1);//findPivot(arr);//
		System.out.println(pivot);
//		if (arr[0] < data) {
//			BinarySearch(arr, data, 0, pivot - 1);
//		} else {
//			BinarySearch(arr, data, pivot + 1, arr.length - 1);
//		}
	}

	public static int findPivot(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] < arr[i]) {
				return i;
			}
		}
		return -1;
	}

	public static int findPivot(int[] arr, int lo, int hi) {

		if (hi < lo) {
			return 0;
		}

		if (hi == lo) {
			return lo;
		}

		int mid = lo + (hi - lo) / 2;

		if (mid < hi && arr[mid + 1] < arr[mid]) {
			return mid + 1;
		}

		if (mid > lo && arr[mid - 1] > arr[mid]) {
			return mid - 1;
		}

		if (arr[hi] > arr[mid]) {
			return findPivot(arr, lo, mid - 1);
		} else {
			return findPivot(arr, mid + 1, hi);
		}
	}

	public static void BinarySearch(int[] arr, int data, int lo, int hi) {

		int mid = (lo + hi) / 2;
		while (lo <= hi) {

			if (data > arr[mid]) {
				lo = mid + 1;
			} else if (data < arr[mid]) {
				hi = mid - 1;
			} else {
				System.out.println(mid);
				return;
			}
			mid = (lo + hi) / 2;
		}
		System.out.println(-1);
	}
}

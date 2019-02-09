package Arrays;

public class NewMergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 25, 7, 9 };
		int arr2[] = { 1, 15, 17, 99 };
		int newArr[] = { 2, 6, 3, 1, 0, 9 };

//		int[] mergedArr = mergeTwoArray(arr, arr2);
//		System.out.println("Merged array ");
//		for (int i : mergedArr) {
//			System.out.print(" " + i);
//		}
		int[] sorted = mergeSort(newArr, 0, newArr.length - 1);

		for (int i : sorted) {
			System.out.print(" " + i);
		}
	}

	public static int[] mergeSort(int[] arr, int low, int high) {

		if (low == high) {
			int barr[] = new int[1];
			barr[0] = arr[low];
			return barr;
		}

		int mid = (low + high) / 2;

		int[] fHalf = mergeSort(arr, low, mid);
		int[] sHalf = mergeSort(arr, mid + 1, high);

		int[] sorted = mergeTwoArray(fHalf, sHalf);
		return sorted;

	}

	public static int[] mergeTwoArray(int[] one, int[] two) {

		int merged[] = new int[one.length + two.length];

		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				merged[k] = one[i];
				k++;
				i++;
			} else {
				merged[k] = two[j];
				k++;
				j++;
			}
		}
		while (i < one.length) {
			merged[k] = one[i];
			k++;
			i++;
		}

		while (j < two.length) {
			merged[k] = two[j];
			k++;
			j++;
		}

		return merged;
	}

}

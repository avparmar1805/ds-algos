package Arrays;

public class MaxDifferenceBwElements {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 7, 10, 6, 12, 8, 1 };

		int maxDiff = arr[1] - arr[0];
		int minElement = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] - minElement > maxDiff) {
				maxDiff = arr[i] - minElement;
			}

			if (minElement > arr[i]) {
				minElement = arr[i];
			}
		}
		System.out.println("maxDiff => " + maxDiff);
	}

}

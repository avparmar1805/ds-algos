package Arrays;

public class LargestSumSubArrayWithKNums {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, -10, -3 };
		int[] maxSum = new int[arr.length];

		int currMax = arr[0];
		maxSum[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			currMax = Math.max(arr[i], currMax + arr[i]);
			maxSum[i] = currMax;
		}
	}

}

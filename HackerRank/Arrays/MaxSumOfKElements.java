package Arrays;

public class MaxSumOfKElements {
	public static void main(String args[]) {
		int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 10 };
		int max = SlidingWindow(arr, 3);
		//System.out.println("max=> " + max);
		MaxSumSubArrWithSumLessThanK();
	}

	public static int SlidingWindow(int[] arr, int k) {
		int mSum = 0;
		int wSum = 0;

		for (int i = 0; i < k; i++) {
			mSum += arr[i];
		}

		wSum = mSum;

		for (int i = k; i < arr.length; i++) {
			wSum += arr[i] - arr[i - k];

			mSum = Math.max(wSum, mSum);
		}

		return mSum;
	}

	public static void MaxSumSubArrWithSumLessThanK() {
		int[] arr = { 5, 4, 3, 2, 1 };
		int k = 11;

		int wSum = 0;
		int mSum = Integer.MIN_VALUE;

		for (int start = 0, end = 0; end < arr.length; end++) {

			wSum += arr[end];

			while (start < end && wSum >= k) {
				wSum -= arr[start++];
			}

			mSum = Math.max(wSum, mSum);
		}
		System.out.println("Max Sum => "+ mSum);
	}
}

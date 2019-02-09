package Arrays;

public class MaxSumOfKElements2 {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		 MaxSum(arr);

//		int[] arr1 = { 1, 2, 3, 4, 5 };
//		MaxSumOfSubArrayWithSumlessThanK(arr1, 11);
	}

	private static void MaxSumOfSubArrayWithSumlessThanK(int[] arr, int sum) {
		int wSum = arr[0];
		int maxSum = arr[0];
		int wStart = 0;

		for (int i = 1; i < arr.length; i++) {
			wSum += arr[i];
			while(wSum > sum && wStart <= i) {
				wSum -= arr[wStart];
				wStart++;
			}
			maxSum = Math.max(wSum, maxSum);
			
		}
		
		System.out.println("Max Sum =" + maxSum);
	}

	private static void MaxSum(int[] arr) {
		int k = 4;
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i = 0; i < k; i++) {
			currSum += arr[i];
		}
		maxSum = Math.max(currSum, maxSum);

		for (int i = k; i < arr.length; i++) {
			currSum = currSum + arr[i] - arr[i - k];
			maxSum = Math.max(currSum, maxSum);
		}

		System.out.println("Max Sum =" + maxSum);
	}

}

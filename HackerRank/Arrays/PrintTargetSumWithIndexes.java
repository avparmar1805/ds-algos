package Arrays;

public class PrintTargetSumWithIndexes {
	public static void main(String[] args) {
		int[] arr = { 70, 40, 50, 60, 10, 20 };
		printTargetSum(arr, 30);
	}

	private static void printTargetSum(int[] arr, int target) {

		int currSum = arr[0];
		int start = 0;
		int noe = arr.length;

		for (int i = 1; i <= noe; i++) {

			while (currSum > target && start < i - 1) {
				currSum = currSum - arr[start];
				start++;
			}
			if (currSum == target) {
				System.out.println("Start=" + start + "END=> " + (i - 1));
			}
			if (i < noe)
				currSum += arr[i];
		}
	}
}

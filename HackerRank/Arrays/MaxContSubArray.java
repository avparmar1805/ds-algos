package Arrays;

public class MaxContSubArray {
	public static void main(String[] args) {
		int[] arr = {  -2, 2, -3, 4, 5, 0, -1 };
		
		System.out.println(maxContSubArr(arr));
	}

	private static int maxContSubArr(int[] arr) {

		int currSum = arr[0];
		int oSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (currSum > 0) {
				currSum += arr[i];	
			} 
			else if (currSum < 0) {
				currSum = arr[i];
			}
			if (currSum > oSum) {
				oSum = currSum;
			}
		}
		return oSum;
	}
}

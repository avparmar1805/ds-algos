package Arrays;

public class ElementIndexWithLeftRightEqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 4, 6, 8, 3, 4, 5 };
		int lIndex = 1;
		int lSum = arr[0];
		int rIndex = 2;
		int rSum = 0;
		for(int i = rIndex; i< arr.length;  i++) {
			rSum += arr[i];
		}

		while (rIndex < arr.length) {

			if (lSum == rSum) {
				System.out.println("Element => " + arr[lIndex] + " Index => " + lIndex);
				break;
			} else {
				rSum -= arr[rIndex];
			}
			lSum += arr[lIndex];

			lIndex++;
			rIndex++;
		}

	}

}

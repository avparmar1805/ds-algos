package Arrays;

public class PrintMaxInSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };

		int k = 3;

		for (int i = 0; i < arr.length; i++) {
			int counter = 1;
			int maxInWindow = arr[i];

			while (counter < k && i < arr.length - 2) {
				maxInWindow = Math.max(maxInWindow, arr[counter + i]);
				counter++;
			}

			System.out.print(maxInWindow + "");
		}
	}

}

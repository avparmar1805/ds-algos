package Arrays;

public class ContSubArraysProdLessThanK {
	public static void main(String args[]) {

		int[] arr = { 1, 9, 2, 8, 6, 4, 3 };

		int k = 100;
		int wProd = 1;
		int count = 0;
		// Assume elements are non-negative, non zero

		int start = 0;
		int end = 0;

		for (start = 0, end = 0; end < arr.length; end++) {
			wProd *= arr[end];

			while (start < end && wProd >= k) {
				wProd /= arr[start++];
			}

			if (wProd < k) {
				int len = end - start + 1;
				count += len;
			}
		}
		
		System.out.println("Count => " + count);
	}

}

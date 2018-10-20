package Arrays;

import java.util.Arrays;

public class PythagoreanTriplet {
	public static void main(String args[]) {
		int[] arr = { 70, 5, 12, 13, 10, 20 };

		int noe = arr.length;

		for (int i = 0; i < noe; i++) {
			arr[i] = arr[i] * arr[i];
		}

		Arrays.sort(arr);

		for (int i = noe - 1; i >= 2; i--) {
			int l = 0;
			int r = i - 1;

			while (l < r) {
				if (arr[l] + arr[r] == arr[i]) {
					System.out.println("1 = " + arr[l] + " 2 = " + arr[r] + " 3 = " + arr[i]);
					break;
				}

				if (arr[l] + arr[r] < arr[i]) {
					l++;
				} else {
					r--;
				}
			}
		}
	}
}

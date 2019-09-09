package Arrays;

public class MaxJMinusI {

	public static void main(String[] args) {

		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		int n = arr.length;
		int RMax[] = new int[n];
		int LMin[] = new int[n];
		int i, j;
		LMin[0] = arr[0];
		for (i = 1; i < n; ++i)
			LMin[i] = Math.min(arr[i], LMin[i - 1]);

		RMax[n - 1] = arr[n - 1];
		for (j = n - 2; j >= 0; --j)
			RMax[j] = Math.max(arr[j], RMax[j + 1]);

		int lCounter = 0;
		int rCounter = 0;
		int maxDiff = -1;
		while (lCounter < n && rCounter < n) {
			if (LMin[lCounter] < RMax[rCounter]) {
				maxDiff = Math.max(maxDiff, rCounter-lCounter);
				rCounter++;
			} else {
				lCounter++;
			}
		}

		System.out.println(maxDiff);

	}

}

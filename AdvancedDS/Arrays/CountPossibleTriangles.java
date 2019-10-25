package Arrays;

import java.util.Arrays;

public class CountPossibleTriangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 6, 3, 7, 5 , 8};
		int count = count(arr);
		System.out.println(count);
	}

	public static int count(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < arr.length; j++) {
				while (k < arr.length && arr[i] + arr[j] > arr[k])
					k++;
				if (k > j)
					count += k - j - 1;
			}
		}
		return count;
	}
}

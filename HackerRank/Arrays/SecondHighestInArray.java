package Arrays;

public class SecondHighestInArray {

	public static void main(String[] ars) {
		int[] arr = { 4, 3, 7, -1, 6, 2, 9 };

		int max = arr[0];
		int sMax = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				sMax = max;
				max = arr[i];
			} else if (arr[i] > sMax) {
				sMax = arr[i];
			}
		}
		
		System.out.println("Max = " + max+ " Smax =" + sMax);
	}

}

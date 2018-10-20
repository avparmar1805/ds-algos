
public class LargestSubArrayCOntElements {
	public static void main(String args[]) {

		int[] arr = { 1, 56, 58, 53, 57, 55, 54, 90, 92, 94, 93, 91, 45 };
		int maxLength = 0;
		for (int i = 0; i < arr.length - 1; i++) {

			int min = arr[i];
			int max = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);

				if (max - min == (j - i)) {
					maxLength = Math.max(maxLength, j - i + 1);
				}
			}
		}

		System.out.println("maxLength = " + maxLength);
	}
}

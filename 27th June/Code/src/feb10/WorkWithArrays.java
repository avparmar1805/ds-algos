package feb10;

public class WorkWithArrays {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, 55, 93, 61 };
		//
		// display(arr);
		// reverse(arr);
		// display(arr);

		// boolean result = IsPalindrome(arr);
		// System.out.println(result);

		display(arr);
		rotate(arr, 2);
		display(arr);
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(".");
	}

	private static void reverse(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
	}

	private static boolean IsPalindrome(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] != arr[right]) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	private static void reversePartial(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
	}

	public static void rotate(int[] arr, int d) {
		d = d % arr.length;
		if (d < 0) {
			d = d + arr.length;
		}

		reversePartial(arr, 0, arr.length - 1 - d); // p1
		reversePartial(arr, arr.length - d, arr.length - 1); // p2
		reversePartial(arr, 0, arr.length - 1); // whole
	}
}

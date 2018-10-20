
public class Sort01 {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 0, 1, 1, 0 };
		int[] sortedArray = Sort01s(arr);
		Display(sortedArray);
	}

	public static int[] Sort01s(int[] arr) {
		int si = 0;
		int li = arr.length - 1;

		while (si < li) {
			if (arr[si] == 0) {
				si++;
			}

			if (arr[li] == 1) {
				li--;
			}

			if (arr[si] == 1 && arr[li] == 0) {
				int temp = arr[si];
				arr[si] = arr[li];
				arr[li] = temp;
				si++;
				li--;
			}
		}
		return arr;
	}

	public static void Display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}

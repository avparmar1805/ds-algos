
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = { 9, 3, 2, 4, 1, 5, 7 };

		SelectionS(arr);
		Display(arr);
	}

	public static void Display(int[] arr) {
		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void SelectionS(int[] arr) {
		int jc = 1;

		while (jc < arr.length) {
			for (int i = jc; i < arr.length; i++) {
				if (arr[jc - 1] > arr[i]) {
					int temp = arr[jc - 1];
					arr[jc - 1] = arr[i];
					arr[i] = temp;
				}
			}
			jc++;
		}
	}
}

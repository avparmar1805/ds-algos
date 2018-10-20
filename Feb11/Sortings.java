package Feb11;

public class Sortings {
	public static void main(String[] args) {
		int[] arr = { 55, 22, 93, 73, 95 };

		insertionSort(arr);
		Display(arr);

	}

	public static void Display(int[] arr) {
		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void insertionSort(int[] arr) {
		int jc = 1;
		while (jc <= arr.length - 1) {
			for (int i = jc; i > 0; i--) {
				if (arr[i - 1] > arr[i]) {
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
				} else {
					break;
				}
			}
			jc++;
		}
	}

	public static void selectionSort(int[] arr) {
		int jc = 1;
		while (jc <= arr.length - 1) {
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

	public static void bubbleSort(int[] arr) {

		int journeyCounter = 1;
		while (journeyCounter <= arr.length - 1) {
			for (int i = 0; i < arr.length - journeyCounter; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			journeyCounter++;
		}
	}
}

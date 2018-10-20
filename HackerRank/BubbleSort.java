import java.util.Scanner;

public class BubbleSort {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int arrLength = in.nextInt();
		int[] arr = new int[arrLength];
		for (int i = 0; i < arrLength; i++) {
			arr[i] = in.nextInt();
		}
		
		int[] sortedArray = BubbleS(arr);
		for (int num : sortedArray) {
			System.out.print(num + " ");
		}
	}

	public static int[] BubbleS(int[] arrayToSort) {

		int si = 0;
		int li = arrayToSort.length - 1;

		int journeyCounter = 1;
		while (journeyCounter < arrayToSort.length) {
			while (si < li) {
				if (arrayToSort[si] > arrayToSort[si + 1]) {
					int temp = arrayToSort[si];
					arrayToSort[si] = arrayToSort[si + 1];
					arrayToSort[si + 1] = temp;
				}
				si++;
			}
			si = 0;
			li--;
			journeyCounter++;
		}
		return arrayToSort;
	}
}

import java.util.Scanner;

public class SortingProblem {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in;
		in = new Scanner(System.in);
		int arrLength = in.nextInt();
		int[] arrOne = new int[arrLength];
		int[] arrTwo = new int[arrLength];
		int[] arrThree = new int[arrLength];

		for (int i = 0; i < arrLength; i++) {
			arrOne[i] = in.nextInt();
		}
		for (int i = 0; i < arrLength; i++) {
			arrTwo[i] = in.nextInt();
		}
		for (int i = 0; i < arrLength; i++) {
			arrThree[i] = in.nextInt();
		}

		int[] sortedArray1 = BubbleS(arrOne);
		int[] sortedArray2 = InsertionSDec(arrTwo);
		int[] sortedArray3 = SelectionS(arrThree);
		Display(sortedArray1);
		Display(sortedArray2);
		Display(sortedArray3);
	}

	public static void Display(int[] arr) {
		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
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

	public static int[] InsertionSDec(int[] arr) {

		int jC = 1;
		while (jC < arr.length) {
			for (int i = jC; i > 0; i--) {
				if (arr[i - 1] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
			}
			jC++;
		}

		return arr;
	}

	public static int[] SelectionS(int[] arr) {
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
		return arr;
	}
}

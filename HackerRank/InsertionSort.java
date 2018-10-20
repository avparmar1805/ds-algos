
public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 5, 9, 4, 2, 0, 8 };
		int[] sortedArray = InsertionSDec(arr);
		for (int num : sortedArray) {
			System.out.print(num + " ");
		}
	}

	public static int[] InsertionS(int[] arr) {

		int jC = 1;
		while (jC < arr.length) {
			for (int i = jC; i > 0; i--) {
				if (arr[i - 1] > arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
			}
			jC++;
		}

		return arr;
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
}

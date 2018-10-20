package Arrays;

public class ZigZagDisplay {
	public static void main(String args[]) {

		int[] arr = { -2, -1, -5, -100, 3, 4, 10, -4, 5, 10 };
		boolean gtFlag = true;

		for (int i = 0; i < arr.length - 1; i++) {

			if (gtFlag) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			gtFlag = !gtFlag;
		}
		gtFlag = true;
		for (int num : arr) {
			System.out.print(num + " " + (gtFlag ? " < " : " > "));
			gtFlag = !gtFlag;
		}

	}
}

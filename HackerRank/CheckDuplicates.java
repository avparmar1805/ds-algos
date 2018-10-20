
public class CheckDuplicates {
	public static void main(String[] args) {
		int[] arr = { 9, 3, 5, 6, 3, 8 };
		int isDup = CheckD(arr, 3, 0);
		System.out.println(isDup);
	}

	public static int CheckD(int[] arr, int data, int vidx) {
		if (vidx == arr.length) {
			return -1;
		}

		int firstE = arr[vidx];
		int found = CheckD(arr, data, vidx + 1);
		if (found != -1) {
			if (data == firstE) {
				return vidx;
			}
		}

		return -1;
	}
}

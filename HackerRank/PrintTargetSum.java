
public class PrintTargetSum {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30 };
		printTargetSum(arr, 70, 0, 0, "");
		// int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
		// subArrayWithTargetSum(arr, 23, 0, 0, "", 0, 0);
	}

	public static void printTargetSum(int[] arr, int target, int vidx, int setSum, String psf) {

		if (vidx == arr.length) {
			if (setSum == target) {
				System.out.println("Set => " + psf);
			}
			return;
		}
		printTargetSum(arr, target, vidx + 1, setSum + arr[vidx], psf + " " + arr[vidx]);
		printTargetSum(arr, target, vidx + 1, setSum, psf);
	}

	private static void subArrayWithTargetSum(int[] arr, int target, int vidx, int setSum, String psf, int si, int li) {
		if (setSum == target) {
			System.out.println(psf);
			System.out.println("SI => " + si + " LI=>" + (li - 1));
			return;
		}
		if (vidx == arr.length) {
			return;
		}

		if (psf.length() == 0) {
			si = vidx;
		}

		subArrayWithTargetSum(arr, target, vidx + 1, setSum, psf, si, li + 1);
		subArrayWithTargetSum(arr, target, vidx + 1, setSum + arr[vidx], psf + " " + arr[vidx], si, li + 1);
	}
}

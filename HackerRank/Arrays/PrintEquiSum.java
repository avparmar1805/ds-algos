package Arrays;

public class PrintEquiSum {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30 };
		printEquiSum(arr, 0, 0, "", 0, "");
	}

	private static void printEquiSum(int[] arr, int vidx, int setSum1, String sum1, int setSum2, String sum2) {

		if (vidx == arr.length) {
			if (setSum1 == setSum2) {
				System.out.println("Set1 => " + sum1 + " Set2 => " + sum2);
			}
			//System.out.println("Set1 => " + sum1 + " Set2 => " + sum2);
			return;
		}

		printEquiSum(arr, vidx + 1, setSum1 + arr[vidx], sum1 + " " + arr[vidx], setSum2, sum2);

		printEquiSum(arr, vidx + 1, setSum1, sum1, setSum2 + arr[vidx], sum2 + " " + arr[vidx]);
	}
}

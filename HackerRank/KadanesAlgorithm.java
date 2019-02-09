
public class KadanesAlgorithm {
	public static void main(String[] args) {

		int[] arr = {  -2, 2, -3, 4, 5, 0, -1 };

		int cSum = arr[0];
		int oSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (cSum > 0) {
				cSum += arr[i];
			} else if (cSum < 0) {
				cSum = arr[i];
			}
			if (cSum > oSum) {
				oSum = cSum;
			}
		}

		System.out.println(oSum);
	}
}

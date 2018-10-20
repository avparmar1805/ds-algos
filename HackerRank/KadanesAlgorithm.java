
public class KadanesAlgorithm {
	public static void main(String[] args) {

		int[] arr = {  56, -451, -222, 80, -57, -85, -304, -108, 95, -377, -282, -260, -497, -471, -97, -350, -147, 62, -447, -229, 78, -165, -333, -427, -59, -338, 60, -207, -247, -431, -54, -240, -426, -123, -209, 57, -74, -287, -70, -292, 45, -278, -408, -129, -35, 65, -77, -230, -426, 20, -402, -375, -449, -280, -125, -15, -21, -327, -366, 64, -211, -414, -307 };;

		int cSum = arr[0];
		int oSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (cSum > 0) {
				cSum += arr[i];
				if (cSum > oSum) {
					oSum = cSum;
				}
			} else if (cSum < 0) {
				cSum = arr[i];
			}
		}
		
		System.out.println(oSum);
	}
}

package Arrays;

public class WaveDisplay1DArray {
	public static void main(String args[]) {
		int[] A = { -1, -4, -5, 0, 4, 3, 5, 1, 9 };

		waveDisplay(A);
	}

	private static void waveDisplay(int[] A) {
		sort(A);
		int i = 0;
//		while (i < A.length - 1) {
//			int temp = A[i];
//			A[i] = A[i + 1];
//			A[i + 1] = temp;
//			i += 2;
//		}
	}

	private static void sort(int[] A) {
		int jC = 1;
		while (jC < A.length) {
			int i = 0;
			for (i = 0; i < A.length - jC; i++) {
				if (A[i] > A[i + 1]) {
					int temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;
				}
			}
			if(jC % 2 == 0) {
				i = A.length - jC;
				int temp = A[i];
				A[i] = A[i + 1];
				A[i + 1] = temp;
			}
			jC++;
		}
	}
}

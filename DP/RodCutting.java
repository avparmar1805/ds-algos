package DP;

public class RodCutting {
	public static void main(String[] args) {

		int[] rod = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		RCT(rod);
	}

	public static void RCT(int[] rod) {
		int[] storage = new int[rod.length];
		String[] psf = new String[rod.length];

		storage[0] = 0;
		storage[1] = rod[1];
		psf[0] = "";
		psf[1] = "1";

		for (int i = 2; i < rod.length; i++) {
			storage[i] = rod[i];
			psf[i] = i + "";

			int leftCut = 1;
			int rightCut = i - 1;

			while (leftCut <= rightCut) {
				if (storage[leftCut] + storage[rightCut] > storage[i]) {
					storage[i] = storage[leftCut] + storage[rightCut];

					psf[i] = psf[leftCut] + psf[rightCut];
				}

				leftCut++;
				rightCut--;
			}
		}

		System.out.println(storage[rod.length - 1]);
		System.out.println(psf[rod.length - 1]);
	}

}


public class Factorization {
	public static void main(String args[]) {
		int[] retArr = factorizationRootN(72);

		for (int i = 0; i < retArr.length; i++) {
			if (retArr[i] != 0)
				System.out.println((i) + " " + retArr[i]);
		}
	}

	public static void factorizationUsingSieve(int n) {
		int[] arr = new int[n + 1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}

		for (int f = 2; f * f <= n; f++) {
			for (int i = f; f * i <= n; i++) {
				if(arr[f*i] % f == 0) {
					arr[f*i] = f;
				}
			}
		}
	}

	public static int[] factorizationRootN(int n) {
		int[] arr = new int[(int) Math.sqrt(n) + 1];

		for (int f = 2; f * f <= n; f++) {
			while (n % f == 0) {
				arr[f]++;
				n = n / f;
			}
		}
		if (n != 1) {
			arr[n]++;
		}
		return arr;
	}
}

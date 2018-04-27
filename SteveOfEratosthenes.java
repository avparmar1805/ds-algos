import java.util.*;

public class SteveOfEratosthenes {
	public static void main(String[] args) {
		boolean[] arrTillN = allPrimeTillN(49);
		for (int i = 0; i < arrTillN.length; i++) {
			if (arrTillN[i]) {
				System.out.println("Index i => " + i);
			}
		}
	}

	public static boolean[] allPrimeTillN(int n) {

		boolean[] arrTillN = new boolean[n];
		Arrays.fill(arrTillN, true);

		arrTillN[0] = false;
		arrTillN[1] = false;
		int i = 2;

		while (i * i <= arrTillN.length) {
			for (int j = 2; i * j < arrTillN.length; j++) {
				arrTillN[i * j] = false;
			}
			i++;
		}

		return arrTillN;
	}
}

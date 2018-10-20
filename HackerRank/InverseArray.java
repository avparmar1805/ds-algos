import java.util.Scanner;

public class InverseArray {
	private static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int arrLength = in.nextInt();
		int[] arr = new int[arrLength];
		for (int i = 0; i < arrLength; i++) {
			arr[i] = in.nextInt();
		}
		int idxToShow = in.nextInt();
		int[] inv = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inv[arr[i]] = i;
		}

		for (int j = 0; j < inv.length; j++) {
			System.out.print(inv[j]);
		}
		System.out.print(inv[idxToShow]);
	}
}

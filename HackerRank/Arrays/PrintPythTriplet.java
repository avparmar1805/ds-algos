package Arrays;

import java.util.ArrayList;

public class PrintPythTriplet {
	public static void main(String[] args) {
		int[] arr = { 70, 5, 12, 13, 10, 20 };
		printPyTrip(arr, 0, new ArrayList<Integer>());
	}

	private static void printPyTrip(int[] arr, int vidx, ArrayList<Integer> subArr) {

//		if (subArr.size() == 4) {
//			for (int num : subArr) {
//				System.out.print("Num =" + num);
//			}
//			int a = subArr.get(0);
//			int b = subArr.get(1);
//			int c = subArr.get(2);
//			if (a * a + b * b == c * c) {
//				//System.out.println("a =" + a + " b" + b + " c" + c);
//			}
//			System.out.println();
//			return;
//		}
		for (int num : subArr) {
			System.out.print("Num =" + num);
		}
		System.out.println();
		if (vidx == arr.length) {
			return;
		}

		subArr.add(arr[vidx]);
		printPyTrip(arr, vidx + 1, subArr);
		subArr.remove(subArr.size() - 1);
		printPyTrip(arr, vidx + 1, subArr);
	}
}

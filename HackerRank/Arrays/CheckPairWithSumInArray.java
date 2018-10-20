package Arrays;

import java.util.HashSet;

public class CheckPairWithSumInArray {
	public static void main(String args[]) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int sum = 16;

		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < A.length; ++i) {
			int temp = sum - A[i];
			
			if(set.contains(temp)) {
				System.out.println("Pair = "+ temp + " " + A[i]);
			}
			set.add(A[i]);
		}
	}
}

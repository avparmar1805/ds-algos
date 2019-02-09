package Arrays;

import java.util.PriorityQueue;

public class MaxTripletSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 0, -1, 8, 10} ;
		FindMaxSumOfTriplet(arr);
	}

	private static void FindMaxSumOfTriplet(int[] arr) {
		PriorityQueue<Integer> mpq = new PriorityQueue<Integer>();

		for (int i = 0; i < 3; i++) {
			mpq.add(arr[i]);
		}
		
		for (int i = 3; i < arr.length; i++) {
			if(arr[i] > mpq.peek()) {
				mpq.remove();
				mpq.add(arr[i]);
			}
		}
		int sum = 0;
		while(mpq.size() >0) {
			sum+= mpq.remove();
		}
		System.out.println("Sum " + sum);
	}

}

package Arrays;

import java.util.Scanner;

public class SubSequence {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i< n; i++) {
			arr[i] = in.nextInt();
		}
		byte bitMask = 0;
		
		for(int i=0; i< (1 << arr.length) ; i++) {
			System.out.print("[");
			for(int j=0; j< (arr.length) ; j++) {
				bitMask = (byte)( 1 << j);
				
				if((i & bitMask) != 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println("]");
		}
	}
}

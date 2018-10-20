package Arrays;

public class plusOneToArray {
	public static void main(String args[]) {
		int[] A = { 0,0,0,0 };

		int carry = 1;

		for (int i = A.length - 1; i >= 0; i--) {
			int num = A[i] + carry;
			A[i] = num % 10;
			carry = num / 10;
		}

		if(A[0] == 0 && carry == 0) {
			int[] B = new int[A.length - 1];
			for (int i = 1; i < A.length; i++) {
				B[i-1] = A[i];
			}
		}
		
		if (carry == 1) {
			int[] B = new int[A.length + 1];
			B[0] = carry;
			for (int i = 1; i < B.length; i++) {
				B[i] = A[i-1];
			}
		}
	}
}

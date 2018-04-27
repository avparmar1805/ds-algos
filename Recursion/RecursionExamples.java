package Recursion;

public class RecursionExamples {
	public static void main(String[] args) {
		// int fac = factorial(4);
		// System.out.println(fac);

		int x = 2;
		int n = 11;
		// int result = power(x,n);
		int result = smarterPower(x, n);
		System.out.println(result);
	}

	public static int smarterPower(int x, int n) {
		if (n == 0) {
			return 1;
		}
		
		int xpb2 = smarterPower(x, n/2);
		int xpn = 1;
		if(n%2 == 0) {
			xpn = xpb2*xpb2;
		} else {
			xpn = xpb2*xpb2*x;
		}
		return xpn;
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		return x * power(x, n - 1);
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}

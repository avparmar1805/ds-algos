package mar4;

public class RecursionBegins {

	public static void main(String[] args) {
//		PD(5);
//		System.out.println(factorial(5));
		System.out.println(power(2, 7));
	}
	
	// expect it to print - > n, n - 1, n - 2, ... 3, 2, 1
	public static void PD(int n){
		if(n == 0){
			return;
		}
		
		System.out.println(n);
		// believe it to print -> n - 1, n - 2, n - 3, ... , 3, 2, 1
		PD(n - 1);
	}
	
	
	public static void PI(int n){
		if(n == 0){
			return;
		}
		
		PI(n - 1);
		System.out.println(n);
	}

	// 4 => 4 3 2 1 1 2 3 4
	public static void PDI(int n){
		if(n == 0){
			return;
		}
		
		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
		
	}

	public static int factorial(int n){
		if(n == 0){
			return 1;
		}
		
		int fnm1 = factorial(n - 1);
		int fn = fnm1 * n;
		return fn;
	}
	
	public static int power(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpm1 = power(x, n - 1);
		int xpn = x * xpm1;
		return xpn;
	}
	
	
	
	
}

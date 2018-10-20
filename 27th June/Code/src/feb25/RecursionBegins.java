package feb25;

public class RecursionBegins {

	public static void main(String[] args) {
//		pdi(4);
//		System.out.println(Power(3, 5));
//		System.out.println(Power(1, 2048));
//		System.out.println(PowerSmart(1, 2048));
//		System.out.println(PowerFakeSmart(1, 2048));
//		System.out.println(pc + " " + psc + " " + pfsc);
		toh("A", "B", "C", 3);
	}
	
	public static void pdi(int n){
		if(n == 0){
			return;
		}
		
		System.out.println(n);
		pdi(n - 1);
		System.out.println(n);
	}

	public static int factorial(int n){
		if(n == 0){
			return 1;
		}
		
		int fm1 = factorial(n - 1);
		int fn = n * fm1;
		return fn;
	}
	
	
	static int pc = 0; 
	public static int Power(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpm1 = Power(x, n - 1);
		int xpn = x * xpm1;
		pc++;
		
		return xpn;
	}

	static int psc = 0;
	public static int PowerSmart(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpb2 = PowerSmart(x, n / 2);
		int xpn = 1;
		
		if(n % 2 == 0){
			xpn = xpb2 * xpb2;
			psc++;
		} else {
			xpn = xpb2 * xpb2 * x;
			psc += 2;
		}
		
		return xpn;
	}
	
	static int pfsc = 0; 
	public static int PowerFakeSmart(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpn = 1;
		
		if(n % 2 == 0){
			xpn = PowerFakeSmart(x, n / 2) * PowerFakeSmart(x, n / 2);
			pfsc++;
		} else {
			xpn = PowerFakeSmart(x, n / 2) * PowerFakeSmart(x, n / 2) * x;
			pfsc += 2;
		}
		
		return xpn;
	}
	
	public static void toh(String src, String des, String aux, int n){
		if(n == 0){
			return;
		}

		System.out.println("pre " + src + des + aux + n); // 1`
		toh(src, aux, des, n - 1); // 1
		System.out.println("in " + src + des + aux + n); // 2
		toh(aux, des, src, n - 1); // 3
		System.out.println("post " + src + des + aux + n); // 3`
	}
	
	
	
}


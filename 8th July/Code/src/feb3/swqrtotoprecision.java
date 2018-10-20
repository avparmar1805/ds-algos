package feb3;

public class swqrtotoprecision {

	public static void main(String[] args) {
		int num = 46;
		int maxp = 3;
		
		double sqrt = 0;
		double power = 1;
		for(int p = 0; p <= maxp; p++){
			double inc = Math.pow(10, -p);
			power = Math.pow(10, p);
		
			while(sqrt * sqrt <= num){
				sqrt = sqrt + inc;
				sqrt = Math.round(sqrt * power) / power;
				System.out.println(sqrt);
			}
			
			sqrt = sqrt - inc;
			sqrt = Math.round(sqrt * power) / power;
			System.out.println(sqrt);
		}
		
	}

}

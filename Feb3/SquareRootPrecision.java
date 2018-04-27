package Feb3;

public class SquareRootPrecision {
	public static void main (String[] args) {
		int sqNum = 46;
		int precision = 3;
		double sqrt = 0;
		double factor = 1.0f;
		double power = 1;
		for(int p = 0; p <= precision; p++) {	
			while(sqrt*sqrt <= sqNum) {
				sqrt += factor;
			}
			sqrt -= factor;
			factor = factor/10;
		}
		factor = Math.pow(10,precision);
		sqrt = Math.round(sqrt*factor)/factor;
		System.out.println(sqrt);
	}
}

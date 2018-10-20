package jan21;

public class RotateANumber {

	public static void main(String[] args) {
		// inputs
		int n = 92543;
		int r = -57;
		
		// number of digits
		int nod = 0;
		int temp = n;
		while(temp != 0){
			temp = temp / 10;
			nod++;
		}
		
		// adjust r
		r = r % nod;
		if(r < 0){
			r = r + nod;
		}
		
		// divider and multiplier
		int divider = (int) Math.pow(10, r);
		int multiplier = (int) Math.pow(10, nod - r);
		
		// quo & rem
		int quo = n / divider;
		int rem = n % divider;
		
		// final
		int rotated = rem * multiplier + quo;
		System.out.println(rotated);
	}

}

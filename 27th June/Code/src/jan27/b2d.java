package jan27;

public class b2d {

	public static void main(String[] args) {
		int sn = 111001;
		int sb = 2;
		int dn = 0;
		int db = 10;
		
		int pow = 1; // sb ^ 0;
		while(sn != 0){
			int quo = sn / db;
			int rem = sn % db;
			
			dn = dn + rem * pow;
			
			sn = quo;
			pow = pow * sb;
		}
		
		System.out.println(dn);
	}

}

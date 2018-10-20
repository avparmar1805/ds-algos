package jan27;

public class d2b {

	public static void main(String[] args) {
		int sn = 57;
		int sb = 10;
		int dn = 0;
		int db = 2;
		
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

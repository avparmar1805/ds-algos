package jan27;

public class o2b {

	public static void main(String[] args) {
		int sn = 572;
		int dn = 0;
		
		int pow = 1;
		while(sn != 0){
			int quo = sn / 10;
			int rem = sn % 10;
			
			if(rem == 0){
				rem = 0;
			} else if(rem == 1){
				rem = 1;
			} else if(rem == 2){
				rem = 10;
			} else if(rem == 3){
				rem = 11;
			} else if(rem == 4){
				rem = 100;
			} else if(rem == 5){
				rem = 101;
			} else if(rem == 6){
				rem = 110;
			} else if(rem == 7){
				rem = 111;
			}
			
			dn = dn + rem * pow;
			
			pow = pow * 1000;
			sn = quo;
		}
		
		System.out.println(dn);
	}

}

import java.util.*;

public class OctalToBinary {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter");
        int Sn = in.nextInt();
		
		int Dn = 0;
		
		int rem = 0;
		int pow = 1;
		while(Sn != 0)
		{
			rem = Sn%10;
			
			switch(rem) {
				case 0:{
					rem = 0;
					break;
				}
				case 1:{
					rem = 1;
					break;
				}
				case 2:{
					rem = 10;
					break;
				}
				case 3:{
					rem = 11;
					break;
				}
				case 4:{
					rem = 100;
					break;
				}
				case 5:{
					rem = 101;
					break;
				}
				case 6:{
					rem = 110;
					break;
				}
				case 7:{
					rem = 111;
					break;
				}
			}
			Sn = Sn/10;
			Dn = Dn+rem*pow;
			pow = pow*1000;
		}
		in.close();
		System.out.println(Dn);
    }
}

package jan28;

public class IsBitOn {

	public static void main(String[] args) {
		byte b = (byte)57;
		int idx = 0; // 0 to 7
		
		int bitmask = 1 << idx;
		int op = b & bitmask;
		
		if(op == bitmask){
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

}

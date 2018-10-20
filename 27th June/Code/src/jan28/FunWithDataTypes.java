package jan28;

public class FunWithDataTypes {

	public static void main(String[] args) {
		// 4 whole numbers
		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;
		
		lo = in;
		lo = sh;
		lo = by;
		
//		in = lo;
		in = sh;
		in = by;
		
		// Part 2
		by = 10;
		by = 127;
		by = (byte)128;
		System.out.println(by);
		
		// Part 3
		in = 1000000000;
		in = (int)10000000000L;
		
		// 2 decimal numbers
		float fl = 4.4f;
		double db = 5.2;
		
//		fl = db;
		db = fl;
		
		in = (int)fl;
		fl = in;
		
		// 1 character
		
		// 1 true/false
	}

}

package feb10;

public class ArraysCtd {

	public static void main(String[] args) {
		// Part 1 - Normal Function
		// System.out.println("Hello World");
		// HelloFun();

		// Part 2 - Multiple calls
		// System.out.println("Hello World");
		// HelloFun();
		// System.out.println("Hello World");
		// HelloFun();

		// Part 3 - Multiple functions
		// System.out.println("Hello World");
		// HelloFun();
		// HelloGun();

		// Part 4 - Function making call to another function
		// System.out.println("Hello World");
		// HelloNestedFun();
		// System.out.println("Hello World");
		// HelloNestedFun();

		// Part 6 - Function with return value
		// System.out.println("Hello World");
		// String value = HelloFunWithReturns("Hello from main");
		// System.out.println(value);

		// Part 7 - Swap 1
//		int one = 10;
//		int two = 20;
//		System.out.println(one + " " + two);
//		Swap1(one, two);
//		System.out.println(one + " " + two);
		
		// Part 8 - Swap 2
//		int[] arr = {10, 20, 30};
//		System.out.println(arr[0] + " " + arr[2]);
//		Swap2(arr[0], arr[2]);
//		System.out.println(arr[0] + " " + arr[2]);
		
		// Part 9 - Swap 3
//		int[] one = {10, 20, 30};
//		int[] two = {100, 200, 300};
//		System.out.println(one[0] + " " + two[0]);
//		Swap3(one, two);
//		System.out.println(one[0] + " " + two[0]);
		
		// Part 10 - Swap 4
		int[] one = {10, 20, 30};
		int i = 0, j = 2;
		System.out.println(one[i] + " " + one[j]);
		Swap4(one, i, j);
		System.out.println(one[i] + " " + one[j]);
	}
	
	public static void Swap4(int[] one, int i, int j){
		System.out.println(one[i] + " " + one[j]);
		
		int temp = one[i];
		one[i] = one[j];
		one[j] = temp;
		
		System.out.println(one[i] + " " + one[j]);
	}

	public static void Swap3(int[] one, int[] two) {
		System.out.println(one[0] + " " + two[0]);

		int[] temp = one;
		one = two;
		two = temp;

		System.out.println(one[0] + " " + two[0]);
	}
	
	public static void Swap2(int one, int two) {
		System.out.println(one + " " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + " " + two);
	}
	
	public static void Swap1(int one, int two) {
		System.out.println(one + " " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + " " + two);
	}

	public static void HelloFunWithParams(String msg) {
		System.out.println("Your message is : " + msg);
	}

	public static String HelloFunWithReturns(String msg) {
		String retVal = "I did your work";

		HelloFunWithParams(msg);

		return retVal;
	}

	public static void HelloNestedFun() {
		System.out.println("Hello Nested Fun");
		HelloFun();

		System.out.println("Hello Nested Fun");
		HelloGun();
	}

	public static void HelloFun() {
		System.out.println("Hello Fun");
	}

	public static void HelloGun() {
		System.out.println("Hello Gun");
	}

}

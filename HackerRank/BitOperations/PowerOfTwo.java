package BitOperations;

public class PowerOfTwo {
	public static void main(String args[]) {
		
		int num = 7;
		
		if((num & -num) == num)  {
			System.out.println("num =" + num +" is power of 2");
		} else {
			System.out.println("num =" + num +" is not power of 2");
		}
		
		int number = 11;
		
		while(number > 2) {
			number = number >> 2;
		}
		if(number == 1) {
			System.out.println("num =" + num +" is odd");
		} else {
			System.out.println("number =" + number +" is even");
		}
	}
}

package Feb11;

public class OctalManipulation {
	public static void main(String[] args) {
		int num1 = 576;
		int num2 = 335;
		
		//add(num1,num2);
		subtraction(num1,num2);
		
	}
	
	public static void subtraction(int num1, int num2) {
		int rem1 = 0;
		int rem2 = 0;
		int pow = 0;
		
		int displayNum = 0;
		int carry = 0;
		
	}
	
	public static void add(int num1, int num2) {
		int rem1 = 0;
		int rem2 = 0;
		int pow = 1;
		
		int displayNum = 0;
		int carry = 0;
		int sum = 0;
		
		while(num1 !=0) {
			rem1 = num1%10;
			rem2 = num2%10;
			
			displayNum = rem1+rem2;
			
			sum = sum + ((carry + displayNum)%8)*pow;
			carry = displayNum/8;
			
			num1 = num1/10;
			num2 = num2/10;
			pow = pow*10;
		}
		if(carry > 0) {
			sum = sum + (carry)*pow;
		}
		System.out.println("sum => "+sum);
	}
	
	public static void multiply(int num1, int num2) {
		
		int rem1 = 0;
		int rem2 = 0;
		int pow = 0;
		
		int displayNum = 0;
		int carry = 0;
		while(num1 !=0) {
			rem1 = num1%10;
			rem2 = num2%10;
			
			int mul = rem1*rem2;
			
			int sum = carry + mul%8;
			sum = mul/8;
			
			num1 = num1/10;
			num2 = num2/10;
		}
	}
}

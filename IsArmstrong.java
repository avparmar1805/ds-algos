import java.util.*;
import java.math.*;

public class IsArmstrong {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number");
		int arn = in.nextInt();
		System.out.println("Enter start range");
		int sr = in.nextInt();
		System.out.println("Enter end range");
		int er = in.nextInt();
		
		System.out.println(IsArmstrongNumber(arn));
		
		while(sr <= er) {
			String op = "";
			if(IsArmstrongNumber(sr)) {
				op = op + sr + " ";
				System.out.print(op);
			}
			sr++;
		}
	}
	
	public static boolean IsArmstrongNumber(int arn) {
		boolean retVal = false;
		int number = arn;
		int sum = 0;
		int degree = 2;
		degree = (int) Math.log10(number) + 1;
		if(degree == 1) {
			degree = 2;
		}
		
		while(number !=0) {
			int remainder = number % 10;
			sum = sum + (int)Math.pow(remainder, degree);
			number = number/10;
		}
		if(arn == sum) {
			retVal = true;
		}
		return retVal;
	}
}

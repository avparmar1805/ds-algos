import java.util.*;

public class GCDLCM {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		//System.out.println("Enter 1st number");
		int num1 = in.nextInt();
		//System.out.println("Enter 2nd number");
		int num2 = in.nextInt();
		int originalNum1 = num1;
		int originalNum2 = num2;
		int temp = 0;
		if(num1 < num2)
		{
			temp = num2;
			num2 = num1;
			num1 = temp;
		}
		int rem = 1;

		while(rem > 0)
		{
			rem = num1 % num2;
			num1=num2;
			num2=rem;
		}

		System.out.println(num1);
		System.out.println((originalNum1*originalNum2)/num1);
	}
}
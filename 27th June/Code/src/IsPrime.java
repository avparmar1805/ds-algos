import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int num = scn.nextInt();
		
		int divisor = 2;
		while(divisor * divisor <= num){
			if(num % divisor == 0){
				System.out.println("Not Prime");
				return;
			}
			
			divisor++;
		}
		
		System.out.println("Prime");
	}

}

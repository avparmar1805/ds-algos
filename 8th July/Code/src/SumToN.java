import java.util.Scanner;

public class SumToN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int counter = 1;
		System.out.println("Enter a number ");
		int n = scn.nextInt();
		
		int sum = 0;
		
		while(counter <= n){
			sum = sum + counter;
			counter++;
		}
		
		System.out.println(sum);
	}

}

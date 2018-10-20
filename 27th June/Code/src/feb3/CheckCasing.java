package feb3;

import java.util.Scanner;

public class CheckCasing {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a char");
		char ch = scn.next().charAt(0);

		
		if(ch >= 'a' && ch <= 'z'){
			System.out.println("Lower case");
		} else if(ch >= 'A' && ch <= 'Z'){
			System.out.println("Upper case");
		} else {
			System.out.println("Invalid");
		}
	}

}

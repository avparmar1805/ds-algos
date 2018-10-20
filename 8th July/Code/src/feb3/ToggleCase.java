package feb3;

import java.util.Scanner;

public class ToggleCase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter a char");
		char ch = scn.next().charAt(0);

		if(ch >= 'a' && ch <= 'z'){
			ch = (char)(ch - 'a' + 'A');
			System.out.println(ch);
		} else if(ch >= 'A' && ch <= 'Z'){
			ch = (char)(ch - 'A' + 'a');
			System.out.println(ch);
		} else {
			System.out.println("Invalid");
		}


	}

}

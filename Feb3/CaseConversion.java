package Feb3;

import java.util.Scanner;

public class CaseConversion {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a char");
		char ch = in.next().charAt(0);
		
		char chToCheckSmalla = 'a';
		char chToCheckSmallz = 'z';
		char chToCheckCapa = 'A';
		char chToCheckCapz = 'Z';
				
		if(ch >= chToCheckSmalla && ch <= chToCheckSmallz ) {
			System.out.println("Lowercase");
			System.out.print((char)(ch - 'a' + 'A'));
			
		} else if(ch >= chToCheckCapa && ch <= chToCheckCapz ){
			System.out.println("Uppercase");
			System.out.print((char)(ch - 'A' + 'a'));
		}
		else {
			System.out.println("Invalid");
		}
	}
}

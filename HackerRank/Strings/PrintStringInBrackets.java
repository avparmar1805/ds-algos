package Strings;

public class PrintStringInBrackets {
	public static void main(String[] args) {
		PrintStrInBrackets("xyz(pepcoding)def", 0, "", false);
	}

	private static void PrintStrInBrackets(String str, int vidx, String strSoFar, boolean bracketOpen) {

		if(str.length() == vidx) {
			System.out.println(strSoFar);
			return;
		}
		
		if (str.charAt(vidx) == ')') {
			strSoFar = strSoFar + ')';
			bracketOpen = false;
		}
		if (str.charAt(vidx) == '(') {
			bracketOpen = true;
		}
		if(bracketOpen) {
			strSoFar = strSoFar + str.charAt(vidx);
		}
		PrintStrInBrackets(str, vidx + 1, strSoFar, bracketOpen);
	}
}

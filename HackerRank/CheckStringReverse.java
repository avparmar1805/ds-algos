import java.util.Scanner;

public class CheckStringReverse {
	private static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		String str = in.next();
		String inputRevStr = in.next();
		String revStr = ReverseString(str, "");
		System.out.println(revStr.equals(inputRevStr));
	}

	public static String ReverseString(String str, String revStr) {

		if (str.length() == 0) {
			return "";
		}

		char firstChar = str.charAt(0);
		String rest = str.substring(1);
		String cRes = ReverseString(rest, revStr);

		revStr = cRes + firstChar;

		return revStr;
	}
}

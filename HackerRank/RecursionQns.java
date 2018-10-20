import java.util.Scanner;

public class RecursionQns {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in;
		in = new Scanner(System.in);
		System.out.println(SumOfDigits(in.next()));
		System.out.println(StrToNum("2345"));
	}

	public static int SumOfDigits(String str) {

		if (str.length() == 0) {
			return 0;
		}

		int firstChar = str.charAt(0) - 48;
		String restStr = str.substring(1);
		int sum = SumOfDigits(restStr);

		sum += firstChar;

		return sum;
	}

	static int counter = 0;
	static int pow = 0;

	public static int StrToNum(String str) {

		if (str.length() == 0) {
			return 0;
		}
		int firstChar = str.charAt(0) - 48;
		String restStr = str.substring(1);

		int num = StrToNum(restStr);
		pow = (int) Math.pow(10, counter);
		counter++;
		num = firstChar * pow + num;

		return num;
	}
}

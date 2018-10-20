
public class RemoveConsDuplicates {
	public static void main(String[] args) {
		String conDupRem = RemoveConsDup("aabbbcccccccds");
		System.out.println(conDupRem);
	}

	private static String RemoveConsDup(String str) {
		String newStr = "";
		int counter = 1;
		int i = 1;
		for (i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				counter++;
			} else {
				newStr +=  str.charAt(i - 1) + String.valueOf(counter);
				counter = 1;
			}
		}
		newStr +=  str.charAt(i-1) + String.valueOf(counter);
		return newStr;
	}
}

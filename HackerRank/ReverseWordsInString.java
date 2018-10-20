
public class ReverseWordsInString {
	public static void main(String[] args) {

		String str = "i.like.this.program.very.much";

		int k = 0;

		for (int i = str.length() - 1; i >= 0; i--) {

			k += 1;

			if (str.charAt(i) == '.') {
				for (int j = i + 1; j <= i + k - 1; j++) {
					System.out.print(str.charAt(j));
				}
				System.out.print('.');
				k = 0;
			} else if (i == 0) {
				for (int j = 0; j <= i + k - 1; j++) {
					System.out.print(str.charAt(j));
				}
			}
		}
	}
}

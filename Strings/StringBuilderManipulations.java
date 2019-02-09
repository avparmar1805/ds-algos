package Strings;

public class StringBuilderManipulations {
	public static void main(String[] args) {
		String str = "aaabbaaaccdeeedd";
		// toggleCase(str);
		// modify1(str);
		// modify2(str);

		compress1(str);
		compress2(str);
	}

	public static void compress2(String str) {
		StringBuilder sb = new StringBuilder(str);
		StringBuilder sb1 = new StringBuilder();
		int noOfTimes = 0;
		for (int i = 0; i < sb.length() - 1; i++) {
			char currCh = sb.charAt(i);
			char nextCh = sb.charAt(i + 1);

			if (currCh != nextCh) {
				noOfTimes++;
				sb1.append(currCh);
				sb1.append(noOfTimes);
				noOfTimes = 0;
			} else {
				noOfTimes++;
			}
		}

		System.out.println(sb1);

	}

	public static void compress1(String str) {
		StringBuilder sb = new StringBuilder(str);
		StringBuilder sb1 = new StringBuilder();

		for (int i = 0; i < sb.length() - 1; i++) {
			char currCh = sb.charAt(i);
			char nextCh = sb.charAt(i + 1);

			if (currCh != nextCh) {
				sb1.append(currCh);
			}
		}
		sb1.append(sb.charAt(sb.length() - 1));
		System.out.println(sb1);

	}

	public static void modify2(String str) {
		StringBuilder sb = new StringBuilder(str);
		StringBuilder sb1 = new StringBuilder();

		for (int i = 0; i < sb.length() - 1; i++) {
			char currCh = sb.charAt(i);
			char nextCh = sb.charAt(i + 1);

			sb1.append(currCh);
			sb1.append(nextCh - currCh);
		}
		sb1.append(sb.charAt(sb.length() - 1));
		System.out.println(sb1);
	}

	public static void modify1(String str) {
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (i % 2 == 0) {
				ch = (char) (ch - 1);
			} else {
				ch = (char) (ch + 1);
			}
			System.out.print(ch);
		}
	}

	public static void toggleCase(String str) {
		StringBuilder sb = new StringBuilder(str);

		char smallA = 'a';
		char capA = 'A';
		char smallZ = 'z';
		char capZ = 'Z';

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (ch >= smallA && ch <= smallZ) {
				ch = (char) (ch - smallA + capA);
			} else if (ch >= capA && ch <= capZ) {
				ch = (char) (ch - capA + smallA);
			}
			System.out.print(ch);
		}
	}
}

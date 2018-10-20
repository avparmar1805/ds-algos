package feb24;

public class SBDemo {

	public static void main(String[] args) {
		// declare and init
		// StringBuilder sb = new StringBuilder();
		// StringBuilder sb1 = new StringBuilder("hello");
		// System.out.println(sb1.length());
		// System.out.println(sb1.charAt(0));
		// sb1.setCharAt(0, 'b');
		// sb1.deleteCharAt(0);
		// sb1.append('f');
		// sb1.insert(3, 'z');
		// String s = sb1.toString();
		// System.out.println(s);
//		toggleCase("pRtlM");
//		modify1("bgrd");
//		modify2("adbec");
		compress2("aaabbaaaccdeeedd");
	}

	public static void toggleCase(String s) {
		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < sb.length(); i++) {
			char och = sb.charAt(i);
			char nch = ' ';
			if (och >= 'a' && och <= 'z') {
				nch = (char) (och - 'a' + 'A');
			} else if (och >= 'A' && och <= 'Z') {
				nch = (char) (och - 'A' + 'a');
			}
			sb.setCharAt(i, nch);
		}

		System.out.println(sb);
	}

	public static void modify1(String s) {
		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < sb.length(); i++) {
			char och = sb.charAt(i);
			char nch = ' ';
			if (i % 2 == 0) {
				nch = (char) (och - 1);
			} else {
				nch = (char) (och + 1);
			}
			sb.setCharAt(i, nch);
		}

		System.out.println(sb);
	}

	public static void modify2(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			char chp1 = s.charAt(i + 1);

			sb.append(ch);
			sb.append(chp1 - ch);
		}
		sb.append(s.charAt(s.length() - 1));

		System.out.println(sb);
	}

	public static void compress1(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			char chp1 = s.charAt(i + 1);
			if(ch != chp1){
				sb.append(ch);
			}
		}

		sb.append(s.charAt(s.length() - 1));
		System.out.println(sb);
	}
	
	public static void compress2(String s) {
		StringBuilder sb = new StringBuilder();

		int count = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			char chp1 = s.charAt(i + 1);
			if(ch != chp1){
				sb.append(ch);
				if (count > 1) {
					sb.append(count);
				}
				count = 1;
			} else {
				count++;
			}
		}

		sb.append(s.charAt(s.length() - 1));
		if (count > 1) {
			sb.append(count);
		}
		System.out.println(sb);
	}
}

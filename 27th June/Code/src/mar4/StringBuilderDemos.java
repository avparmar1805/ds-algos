package mar4;

public class StringBuilderDemos {

	public static void main(String[] args) {
		// StringBuilder sb = new StringBuilder();
		// StringBuilder sb1 = new StringBuilder("hello");
		// System.out.println(sb1.length());
		// System.out.println(sb1);
		// System.out.println(sb1.charAt(2));
		// sb1.setCharAt(2, 'z');
		// sb1.deleteCharAt(2);
		// sb1.insert(2, 't');
		// String str = sb1.toString();
		// System.out.println(str);

		toggleCase("ABBcdeFF");
		Modify1("zbrtc");
	}

	public static void toggleCase(String str) {
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch - 'a' + 'A');
				sb.setCharAt(i, ch);
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch - 'A' + 'a');
				sb.setCharAt(i, ch);
			}
		}

		System.out.println(sb);
	}

	public static void Modify1(String str) {
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);

			if (i % 2 == 0) {
				ch = (char) (ch - 1);
				sb.setCharAt(i, ch);
			} else {
				ch = (char) (ch + 1);
				sb.setCharAt(i, ch);
			}
		}

		System.out.println(sb);
	}

	public static void Modify2(String str) {
		StringBuilder sb = new StringBuilder();

		// acbda => a-2c1b-2d3
		for (int i = 0; i < str.length() - 1; i++) {
			char ch = str.charAt(i);
			char ch1 = str.charAt(i + 1);
			int gap = ch - ch1;

			sb.append(ch);
			sb.append(gap);
		}

		sb.append(str.charAt(str.length() - 1));
		System.out.println(sb);
	}

	public static void Compress1(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length() - 1; i++) {
			char ch = str.charAt(i);
			char ch1 = str.charAt(i + 1);

			if (ch != ch1) {
				sb.append(ch);
			}
		}

		sb.append(str.charAt(str.length() - 1));
		System.out.println(sb);
	}

	public static void Compress2(String str) {
		StringBuilder sb = new StringBuilder();

		int counter = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			char ch = str.charAt(i);
			char ch1 = str.charAt(i + 1);

			if (ch != ch1) {
				sb.append(ch);
				if (counter != 1) {
					sb.append(counter);
				}
				counter = 1;
			} else {
				counter++;
			}
		}

		sb.append(str.charAt(str.length() - 1));
		if (counter != 1) {
			sb.append(counter);
		}
		System.out.println(sb);
	}

}

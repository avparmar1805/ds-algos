package Arrays;

import java.util.ArrayList;

public class GetPermutations {
	public static void main(String[] args) {
		ArrayList<String> resultWords = getPermutations("abc");
		for(String rKp: resultWords) {
			System.out.println(rKp);
		}
	}

	public static ArrayList<String> getPermutations(String str) {

		if (str.equals("")) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		char currChar = str.charAt(0);
		ArrayList<String> resultPerm = getPermutations(str.substring(1));
		ArrayList<String> mresult = new ArrayList<String>();

		for (String rStr : resultPerm) {
			for (int i = 0; i <= rStr.length(); i++) {
				StringBuilder sb = new StringBuilder(rStr);
				sb.insert(i, currChar);
				mresult.add(sb.toString());
			}
		}
		return mresult;
	}
}

import java.util.ArrayList;

public class GetPermutations {
	public static void main(String[] args) {
		ArrayList<String> subsq = getPerm("abc");

		for (String rs : subsq) {
			System.out.println(rs);
		}
	}

	public static ArrayList<String> getPerm(String str) {
		if (str.length() == 0) {
			ArrayList<String> b = new ArrayList<String>();
			b.add("");
			return b;
		}

		char firstChar = str.charAt(0);
		String rest = str.substring(1);

		ArrayList<String> result = getPerm(rest);
		ArrayList<String> mResult = new ArrayList<String>();

		for (String res : result) {
			for (int i = 0; i <= res.length(); i++) {
				String leftSide = res.substring(0, i);
				String rightSide = res.substring(i);
				mResult.add(leftSide + firstChar + rightSide);
			}
		}
		return mResult;
	}
}

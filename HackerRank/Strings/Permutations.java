package Strings;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> retAL = getPermutations("abc");
		for (String mStr : retAL) {
			System.out.println(mStr + " ");
		}
	}

	private static ArrayList<String> getPermutations(String str) {

		if(str.length() == 0) {
			ArrayList<String> retAL = new ArrayList<String>();
			retAL.add("");
			return retAL;
		}
		
		char firstChar = str.charAt(0);
		String restOfString = str.substring(1);

		ArrayList<String> mResult = getPermutations(restOfString);
		ArrayList<String> fResult = new ArrayList<String>();

		for (String mStr : mResult) {
			for (int i = 0; i <= mStr.length(); i++) {
				String newStr = mStr.substring(0, i) + firstChar + mStr.substring(i);
				fResult.add(newStr);
			}
		}
		
		return fResult;
	}

}

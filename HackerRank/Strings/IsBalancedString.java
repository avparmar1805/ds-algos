package Strings;

import java.util.LinkedList;

public class IsBalancedString {
	public static void main(String[] args) {
		String str = "{ a + { b + (c + d) + e } + f }";
		System.out.println(IsBalanced(str));
	}

	private static boolean IsBalanced(String str) {
		LinkedList<String> list = new LinkedList<String>();

		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (currChar == '{' || currChar == '(') {
				list.addLast(Character.toString(currChar));
			}
			if (currChar == '}' || currChar == ')') {
				list.removeLast();
			}
		}
		if(list.size() != 0) {
			return false;
		}
		return true;
	}
}

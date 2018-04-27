package Recursion;

import java.util.*;

public class RecursionTheConclusion {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30 };
		// printTargetSumSet(arr, 60, 0, "", 0);
		// printTargetSumSet(arr, 30, 0, new ArrayList<>(), 0);
		int[] arr1 = { 10, 20, 30, 40, 50, 60, 70 };
		// printEquiSets(arr1, 0, "", 0, "", 0);
		// printEquiSets(arr1, 0, new ArrayList<>(), 0, new ArrayList<>(), 0);
		// printPermutations("abc", "");
		// printPermutations(new StringBuilder("abc"), new StringBuilder(""));
		printPermutationsAlternate("abc", "");
	}

	public static void printPermutationsAlternate(String ques, String asf) {

		if (ques.equals("")) {
			counter++;
			System.out.println(counter);
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char currChar = ques.charAt(i);
			String left = ques.substring(0, i);
			String right = ques.substring(i + 1);
			printPermutationsAlternate(left + right, asf + currChar);
		}
	}

	public static void printPermutations(String ques, String asf) {

		if (ques.equals("")) {
			counter++;
			System.out.println(counter);
			System.out.println(asf);
			return;
		}

		char currChar = ques.charAt(0);
		String ros = ques.substring(1);

		for (int i = 0; i <= asf.length(); i++) {
			String left = asf.substring(0, i);
			String right = asf.substring(i);
			printPermutations(ros, left + currChar + right);
		}
	}

	public static void printPermutations(StringBuilder ques, StringBuilder asf) {

		if (ques.length() == 0) {
			counter++;
			System.out.println(counter);
			System.out.println(asf);
			return;
		}

		char currChar = ques.charAt(0);
		ques.deleteCharAt(0);

		for (int i = 0; i <= asf.length(); i++) {
			asf.insert(i, currChar);
			printPermutations(ques, asf);
			asf.deleteCharAt(i);
		}
		ques.insert(0, currChar);
	}

	static int counter = 0;

	public static void printEquiSets(int[] arr, int vidx, ArrayList<Integer> set1, int sumOfSet1,
			ArrayList<Integer> set2, int sumOfSet2) {

		if (vidx == arr.length) {
			if (sumOfSet1 == sumOfSet2) {
				counter++;
				System.out.println("counter" + counter);
				System.out.println("set1 => " + set1);
				System.out.println("set2 => " + set2);
				return;
			}
			return;
		}

		set1.add(arr[vidx]);
		printEquiSets(arr, vidx + 1, set1, sumOfSet1 + arr[vidx], set2, sumOfSet2);
		set1.remove(set1.size() - 1);
		set2.add(arr[vidx]);
		printEquiSets(arr, vidx + 1, set1, sumOfSet1, set2, sumOfSet2 + arr[vidx]);
		set2.remove(set2.size() - 1);
	}

	public static void printEquiSets(int[] arr, int vidx, String set1, int sumOfSet1, String set2, int sumOfSet2) {

		if (vidx == arr.length) {
			if (sumOfSet1 == sumOfSet2) {
				counter++;
				System.out.println("counter" + counter);
				System.out.println("set1 => " + set1);
				System.out.println("set2 => " + set2);
				return;
			}
			return;
		}

		printEquiSets(arr, vidx + 1, set1 + arr[vidx], sumOfSet1 + arr[vidx], set2, sumOfSet2);

		printEquiSets(arr, vidx + 1, set1, sumOfSet1, set2 + arr[vidx], sumOfSet2 + arr[vidx]);
	}

	public static void printTargetSumSet(int[] arr, int tar, int vidx, String set, int sumOfSet) {

		if (sumOfSet == tar) {
			System.out.println(set);
			return;
		}
		if (vidx == arr.length) {
			return;
		}

		printTargetSumSet(arr, tar, vidx + 1, set, sumOfSet);

		printTargetSumSet(arr, tar, vidx + 1, set + arr[vidx], sumOfSet + arr[vidx]);
	}

	public static void printTargetSumSet(int[] arr, int tar, int vidx, ArrayList<Integer> set, int sumOfSet) {

		if (sumOfSet == tar) {
			System.out.println(set);
			return;
		}
		if (vidx == arr.length) {
			return;
		}

		printTargetSumSet(arr, tar, vidx + 1, set, sumOfSet);
		set.add(arr[vidx]);
		printTargetSumSet(arr, tar, vidx + 1, set, sumOfSet + arr[vidx]);
		set.remove(set.size() - 1);
	}
}

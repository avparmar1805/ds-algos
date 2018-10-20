package apr1;

import java.util.ArrayList;

public class RecursionConclusion {

	public static void main(String[] args) {
//		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
//		printEquiSets(arr, 0, new ArrayList<>(), 0, new ArrayList<Integer>(), 0);
		// printTargetSumSet(arr, 60, 0, "", 0);
		// printTargetSumSet(arr, 60, 0, new ArrayList<>(), 0);
		printPermutation1(new StringBuilder("abc"), new StringBuilder(""));
//		printPermutation1("abc", "");
	}

	public static void printTargetSumSet(int[] arr, int tar, int vidx, String set, int sumofset) {
		if (vidx == arr.length) {
			if (sumofset == tar) {
				System.out.println(set);
			}
			return;
		}

		printTargetSumSet(arr, tar, vidx + 1, set, sumofset);
		printTargetSumSet(arr, tar, vidx + 1, set + " " + arr[vidx], sumofset + arr[vidx]);
	}

	public static void printTargetSumSet(int[] arr, int tar, int vidx, ArrayList<Integer> set, int sumofset) {
		if (vidx == arr.length) {
			if (sumofset == tar) {
				System.out.println(set);
			}
			return;
		}

		// no
		printTargetSumSet(arr, tar, vidx + 1, set, sumofset);

		// yes
		set.add(arr[vidx]);
		printTargetSumSet(arr, tar, vidx + 1, set, sumofset + arr[vidx]);
		set.remove(set.size() - 1);
	}

	public static void printEquiSets(int[] arr, int vidx, String set1, int sumofset1, String set2, int sumofset2) {
		if (vidx == arr.length) {
			if (sumofset1 == sumofset2) {
				System.out.println(set1 + " " + set2);
				return;
			}
			return;
		}

		printEquiSets(arr, vidx + 1, set1 + " " + arr[vidx], sumofset1 + arr[vidx], set2, sumofset2);
		printEquiSets(arr, vidx + 1, set1, sumofset1, set2 + " " + arr[vidx], sumofset2 + arr[vidx]);
	}

	public static void printEquiSets(int[] arr, int vidx, ArrayList<Integer> set1, int sumofset1,
			ArrayList<Integer> set2, int sumofset2) {
		if (vidx == arr.length) {
			if (sumofset1 == sumofset2) {
				System.out.println(set1 + " " + set2);
				return;
			}
			return;
		}

		set1.add(arr[vidx]);
		printEquiSets(arr, vidx + 1, set1, sumofset1 + arr[vidx], set2, sumofset2);
		set1.remove(set1.size() - 1);
		
		set2.add(arr[vidx]);
		printEquiSets(arr, vidx + 1, set1, sumofset1, set2, sumofset2 + arr[vidx]);
		set2.remove(set2.size() - 1);
	}

	public static void printPermutation(String ques, String asf){
		if(ques.length() == 0){
			System.out.println(asf);
			return;
		}
		
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		
		for(int i = 0; i <= asf.length(); i++){
			String left = asf.substring(0, i);
			String right = asf.substring(i);
			printPermutation(roq, left +  ch + right);
		}
	}
	
	public static void printPermutation(StringBuilder ques, StringBuilder asf){
		if(ques.length() == 0){
			System.out.println(asf);
			return;
		}
		
		char ch = ques.charAt(0);
		ques.deleteCharAt(0);
		
		for(int i = 0; i <= asf.length(); i++){
			asf.insert(i, ch);
			printPermutation(ques, asf);
			asf.deleteCharAt(i);
		}
		
		ques.insert(0, ch);
	}
	
	public static void printPermutation1(String ques, String asf){
		if(ques.length() == 0){
			System.out.println(asf);
			return;
		}
		
		for(int i = 0; i < ques.length(); i++){
			char ch = ques.charAt(i);
			String left = ques.substring(0, i);
			String right = ques.substring(i + 1);
			
			printPermutation1(left + right, asf + ch);
		}
	}
	
	public static void printPermutation1(StringBuilder ques, StringBuilder asf){
		if(ques.length() == 0){
			System.out.println(asf);
			return;
		}
		
		for(int i = 0; i < ques.length(); i++){
			char ch = ques.charAt(i);
			ques.deleteCharAt(i);
			asf.append(ch);
			printPermutation1(ques, asf);
			asf.deleteCharAt(asf.length() - 1);
			ques.insert(i, ch);
		}
	}
}

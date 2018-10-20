package Strings;

import java.util.Arrays;

public class AreAnagrams {
	public static void main(String[] args) {
		System.out.println(AreAnagrams1("geeks".toCharArray(), "skeeg".toCharArray()));
	}

	public static boolean AreAnagrams1(char str1[], char str2[]) {
		int count1[] = new int[256];
		Arrays.fill(count1, 0);
		int count2[] = new int[256];
		Arrays.fill(count2, 0);
		int i;

		for (i = 0; i < str1.length && i < str2.length; i++) {
			count1[str1[i]]++;
			count2[str2[i]]++;
		}
		
		if (str1.length != str2.length)
            return false;
		
		for (i = 0; i < 256; i++)
            if (count1[i] != count2[i])
                return false;
		
		return true;
	}
}

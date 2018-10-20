package apr7;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		StringBuilder[] matrix = new StringBuilder[10];
		for(int i = 0; i < 10; i++) {
			matrix[i] = new StringBuilder(scn.nextLine());
		}
		
		String[] words = scn.nextLine().split(";");
		printCrossword(matrix, words, 0);
	}
	
	public static void printCrossword(StringBuilder[] matrix, String[] words, int wpsf) {
		if(wpsf == words.length) {
			for(int r = 0; r < matrix.length; r++) {
				System.out.println(matrix[r]);
			}
			
			return;
		}
		
		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[0].length(); c++) {
				// try horizontally
				if((matrix[r].charAt(c) == '-' || matrix[r].charAt(c) == words[wpsf].charAt(0)) && 
				   IsTheSpotValidHoriz(matrix, r, c, words[wpsf]) == true) {
					// place the word horiz
					PlaceTheWordHoriz(matrix, r, c, words[wpsf]);
					
					// make a call
					printCrossword(matrix, words, wpsf + 1);
					
					// unplace the word horiz
					UnplaceTheWordHoriz(matrix, r, c, words[wpsf]);
				}
				
				// try vertically
				if((matrix[r].charAt(c) == '-' || matrix[r].charAt(c) == words[wpsf].charAt(0)) && 
				   IsTheSpotValidVert(matrix, r, c, words[wpsf]) == true) {
					// place the word vert
					PlaceTheWordVert(matrix, r, c, words[wpsf]);
					
					// make a call
					printCrossword(matrix, words, wpsf + 1);
					
					// unplace the word vert
					UnplaceTheWordVert(matrix, r, c, words[wpsf]);
				}
			}
		}
	}
	
	private static void PlaceTheWordHoriz(StringBuilder[] matrix, int r, int c, String word) {
		for(int i = 0; i < word.length(); i++) {
			matrix[r].setCharAt(c + i, word.charAt(i));
		}
	}
	
	private static void PlaceTheWordVert(StringBuilder[] matrix, int r, int c, String word) {
		for(int i = 0; i < word.length(); i++) {
			matrix[r + i].setCharAt(c, word.charAt(i));
		}
	}
	
	private static void UnplaceTheWordHoriz(StringBuilder[] matrix, int r, int c, String word) {
		for(int i = 0; i < word.length(); i++) {
			matrix[r].setCharAt(c + i, '-');
		}
	}
	
	private static void UnplaceTheWordVert(StringBuilder[] matrix, int r, int c, String word) {
		for(int i = 0; i < word.length(); i++) {
			matrix[r + i].setCharAt(c, '-');
		}
	}

	private static boolean IsTheSpotValidHoriz(StringBuilder[] matrix, int r, int c, String word) {
		if(c + word.length() - 1 >= 10) {
			return false;
		} else {
			for(int i = 0; i < word.length(); i++) {
				if(matrix[r].charAt(c + i) == '-' || matrix[r].charAt(c + i) == word.charAt(i)) {
					continue;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}

	private static boolean IsTheSpotValidVert(StringBuilder[] matrix, int r, int c, String word) {
		if(r + word.length() - 1 >= 10) {
			return false;
		} else {
			for(int i = 0; i < word.length(); i++) {
				if(matrix[r + i].charAt(c) == '-' || matrix[r + i].charAt(c) == word.charAt(i)) {
					continue;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
}

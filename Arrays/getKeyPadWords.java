package Arrays;
import java.util.*;
public class getKeyPadWords {
	public static void main(String[] args) {
		ArrayList<String> resultWords = getKPWords("157");
		for(String rKp: resultWords) {
			System.out.println(rKp);                               
		}
	}
	static String[] codes = {"abc", "de", "fgh", "ijkl", "m", "nop", "qrs", "tuv", "wxyz"};
	public static ArrayList<String> getKPWords(String str){
	
		if(str.equals("")) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");  
			return br;
		}
		char currChar = str.charAt(0);
		String currKPWords = codes[currChar - (int)'0'];
		ArrayList<String> resultKP = getKPWords(str.substring(1));
		ArrayList<String> mresult = new ArrayList<String>();
		
		for(int i = 0; i< currKPWords.length(); i++) {
			for(String rKp: resultKP) {
				char ch = currKPWords.charAt(i);
				mresult.add(ch+rKp);
			}
		}
		
		return mresult;
	}
}

package Arrays;
import java.util.*;

public class SubSequenceArrayList {
	public static void main(String[] args) {
		ArrayList<String> sses = getSS("ab");
		System.out.println(sses);   
	}
	
	public static ArrayList<String> getSS(String str){
		if(str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		
		char ch = str.charAt(0);
		
		String ros = str.substring(1);
		
		ArrayList<String> rresult = getSS(ros);
		ArrayList<String> mresult = new ArrayList<String>();
		
		for(String rStr: rresult) {
			mresult.add(rStr);
			mresult.add(ch + rStr);
			mresult.add((int)ch + rStr);
		}
		
		return mresult;
	}
}

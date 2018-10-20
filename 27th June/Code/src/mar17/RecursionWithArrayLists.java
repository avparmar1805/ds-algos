package mar17;

import java.util.ArrayList;

public class RecursionWithArrayLists {

	public static void main(String[] args) {
//		ArrayList<String> sses = getSSWAscii("ab");
//		System.out.println(sses);
//		System.out.println(getBoardPaths(0, 10));
		System.out.println(getKPWords("157"));
	}
	
	public static ArrayList<String> getSS(String str){
		if(str.length() == 0){
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
	
		char ch = str.charAt(0); // a
		String ros = str.substring(1); // bc
		
		// faith -> gss("bc") == ["", "c", "b", "bc"]
		ArrayList<String> rresult = getSS(ros); 
		ArrayList<String> mresult = new ArrayList<String>();
		
		// ["", "a", "c", "ac", "b", "ab", "bc", "abc"]
		for(String rstr: rresult){
			mresult.add(rstr);
			mresult.add(ch + rstr);
		}
		
		return mresult;
	}

	public static ArrayList<String> getSSWAscii(String str){
		if(str.length() == 0){
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
	
		char ch = str.charAt(0); // a
		String ros = str.substring(1); // bc
		
		ArrayList<String> rresult = getSSWAscii(ros); 
		ArrayList<String> mresult = new ArrayList<String>();
		
		for(String rstr: rresult){
			mresult.add(rstr);
			mresult.add(ch + rstr);
			mresult.add((int)ch + rstr);
		}
		
		return mresult;
	}

	public static ArrayList<String> getBoardPaths(int s, int d){
		if(s == d){
			ArrayList<String> br = new ArrayList<String>();
			br.add("\n");
			return br;
		}
		
		if(s > d){
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}
		
		ArrayList<String> pathsfromstod = new ArrayList<String>();
		for(int dice = 1; dice <= 6; dice++){
			int i = s + dice;
			ArrayList<String> pathsfromitod = getBoardPaths(i, d);
			for(String pathfromitod: pathsfromitod){
				pathsfromstod.add(dice + pathfromitod);
			}
		}
		
		return pathsfromstod;
	}
	
	static String[] codes = {"abc", "de", "fgh", "ijkl", "m", "nop", 
			"qrs", "tuv", "wxyz", "."};
	public static ArrayList<String> getKPWords(String str){
		if(str.length() == 0){
			ArrayList<String> bresult = new ArrayList<String>();
			bresult.add("");
			return bresult;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rresult = getKPWords(ros);
		ArrayList<String> mresult = new ArrayList<String>();
		
		String chcode = codes[ch - '0'];
		for(String rstr: rresult){
			for(int i = 0; i < chcode.length(); i++){
				String mstr = chcode.charAt(i) + rstr;
				mresult.add(mstr);
			}
		}
		
		return mresult;
	}
	
	// abc => abc, acb, bac, bca, cab, cba
	public static ArrayList<String> getPermutations(String str){
		if(str.length() == 0){
			ArrayList<String> bresult = new ArrayList<String>();
			bresult.add("");
			return bresult;
		}

		char ch = str.charAt(0); // a
		String ros = str.substring(1); // bc
		
		// bc => bc, cb
		ArrayList<String> rresult = getPermutations(ros);
		ArrayList<String> mresult = new ArrayList<String>();
		
		for(String rstr: rresult){
			for(int i = 0; i <= rstr.length(); i++){
				StringBuilder sb = new StringBuilder(rstr);
				sb.insert(i, ch);
				mresult.add(sb.toString());
			}
		}
		
		return mresult;
	}
	
	
	
	
	
}

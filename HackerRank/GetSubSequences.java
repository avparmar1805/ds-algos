import java.util.ArrayList;

public class GetSubSequences {
	public static void main(String[] args) {
		ArrayList<String> subsq = getSS("abcd");

		for(String rs: subsq) {
			System.out.println(rs);
		}
	}
	
	public static ArrayList<String> getSS(String str) {
		
		if(str.length() == 0) {
			ArrayList<String> b = new ArrayList<String>();
			b.add("");
			return b;
		}
		
		char firstCh = str.charAt(0);
		String ssf = str.substring(1);
		
		ArrayList<String> result = getSS(ssf);
		ArrayList<String> mResult = new ArrayList<String>();
		for(String rs: result) {
			
			mResult.add(firstCh+rs);
			mResult.add(rs);
		}
		
		return mResult;
	}
}

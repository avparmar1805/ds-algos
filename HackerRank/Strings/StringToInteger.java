package Strings;

public class StringToInteger {
	public static void main(String[] args) {
		Result res = stringToInt("2345", 0);
		System.out.println(res.num);
	}

	private static class Result {
		int num;
		int mulFactor;
	}

	private static Result stringToInt(String str, int mulFactor) {
		
		if(str.length() == 0) {
			Result mRes = new Result();
			mRes.mulFactor = 1;
			mRes.num = 0;
			return mRes;
		}
		
		char currChar = str.charAt(0);
		String resStr = str.substring(1);
		
		Result result = stringToInt(resStr, mulFactor);
		
		Result retResult = new Result();
		retResult.mulFactor = result.mulFactor*10;
		int currCharInInt = currChar -'0';
		retResult.num = currCharInInt  * result.mulFactor   + result.num;
		
		return retResult;
	}
}

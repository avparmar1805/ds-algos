package apr21;

import java.util.ArrayList;

public class CoinChangeCombination {

	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 6 };
		int pay = 10;

		int[] strg = new int[pay + 1];
		ArrayList[] ways = new ArrayList[pay + 1];
		for (int i = 0; i < ways.length; i++) {
			ways[i] = new ArrayList<String>();
		}

		strg[0] = 1;
		ways[0].add("");

		for (int i = 0; i < strg.length; i++) {
			for (int ci = 0; ci < coins.length; ci++) {

				if (i - coins[ci] >= 0) {
					strg[i] = strg[i] + strg[i - coins[ci]];

					ArrayList<String> destList = ways[i];
					ArrayList<String> srcList = ways[i - coins[ci]];
					for (String srcString : srcList) {
						destList.add(srcString + coins[ci]);
					}
				}
			}
		}

		System.out.println(strg[pay]);
		System.out.println(ways[pay]);
	}

}

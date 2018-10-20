package DP;

import java.util.*;

public class CoinChangeTabulation {
	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 6 };
		CoinChangePermutation(coins, 10);
	}

	public static void CoinChangePermutation(int[] coins, int amount) {

		int[] container = new int[amount + 1];

		container[0] = 1;

		ArrayList[] ways = new ArrayList[amount + 1];
		for (int i = 0; i < ways.length; i++) {
			ways[i] = new ArrayList<String>();
		}

		ways[0].add("");
		
		for (int x = 0; x < container.length; x++) {
			for (int i = 0; i < coins.length; i++) {
				
				if(x - coins[i] >= 0) {
					container[x] = container[x] + container[x - coins[i]];

					ArrayList<String> destList = ways[x];
					ArrayList<String> srcList = ways[x - coins[i]];

					for (String src : srcList) {
						destList.add(src + coins[i]);
					}
				}
							
			}
		}
		System.out.println(container[10]);
		System.out.println(ways[10]);
	}

	@SuppressWarnings("unchecked")
	public static void CoinChange(int[] coins, int amount) {

		int[] container = new int[amount + 1];

		container[0] = 1;

		@SuppressWarnings("rawtypes")
		ArrayList[] ways = new ArrayList[amount + 1];
		for (int i = 0; i < ways.length; i++) {
			ways[i] = new ArrayList<String>();
		}

		ways[0].add("");

		for (int i = 0; i < coins.length; i++) {
			for (int x = coins[i]; x < container.length; x++) {
				container[x] = container[x] + container[x - coins[i]];

				ArrayList<String> destList = ways[x];
				ArrayList<String> srcList = ways[x - coins[i]];

				for (String src : srcList) {
					destList.add(src + coins[i]);
				}
			}
		}
		System.out.println(container[10]);
		System.out.println(ways[10]);
	}
}

package org.handsoncoder.leetcode.medium;

import java.util.*;

public class CoinChange {
	int min = Integer.MAX_VALUE;

	public int coinChange(int[] coins, int amount) {
		Integer[] coinsI = new Integer[coins.length];
		for (int i = 0; i < coins.length; i++) {
			coinsI[i] = coins[i];
		}
		Arrays.sort(coinsI, Collections.reverseOrder());
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, coinsI, new ArrayList<Integer>(), amount, 0);
		return (min == Integer.MAX_VALUE ? -1 : min);
	}

	private void backtrack(List<List<Integer>> list, Integer[] coinsI, ArrayList<Integer> tempList, int remains,
			int start) {
		if (remains < 0 || tempList.size() > min) {
			return;
		} else if (remains == 0) {
			list.add(new ArrayList<>(tempList));
			min = Math.min(min, tempList.size());
		} else {
			for (int i = start; i < coinsI.length; i++) {
				tempList.add(coinsI[i]);
				backtrack(list, coinsI, tempList, remains - coinsI[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CoinChange testObj = new CoinChange();
		int[] coins = new int[] { 1, 2, 5 }; // 11
		coins = new int[] { 429, 171, 485, 26, 381, 31, 290 };

		int res = testObj.coinChange(coins, 8440);
		System.out.println(res);

	}

	public int coinChange2(int[] coins, int amount) {
		Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for (int i : coins) {
			if (i <= amount)
				set.add(i);
		}

		return amount;

	}

}

package org.handsoncoder.leetcode.easy;

public class BestTimeToBuyAndSellStocks {

	public int maxProfit(int prices[]) {
		if (prices == null || prices.length == 0)
			return 0;

		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if ((prices[i] - minPrice) > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

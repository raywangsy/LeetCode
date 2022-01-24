package 剑指Offer.剑指Offer63股票的最大利润;

public class Solution {
	public static void main(String[] args) {
		int[] prices = new int[]{7, 1, 5, 3, 6, 4};
		System.out.println(new Solution().maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 1) {
			return 0;
		}
		int maxValue = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxValue = Math.max(maxValue, price - minPrice);
		}
		return maxValue;
	}
}

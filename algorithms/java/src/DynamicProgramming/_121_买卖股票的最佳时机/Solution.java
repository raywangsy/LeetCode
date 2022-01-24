package DynamicProgramming._121_买卖股票的最佳时机;

public class Solution {
	public static void main(String[] args) {
		int[] prices = new int[]{7, 1, 5, 3, 6, 4};
		System.out.println(new Solution().maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 1) {
			return 0;
		}
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		return maxProfit;
	}
}

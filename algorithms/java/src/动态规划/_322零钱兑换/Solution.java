package 动态规划._322零钱兑换;

/**
 * Source: https://leetcode-cn.com/problems/coin-change/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/22 14:12
 */
public class Solution {
	public static void main(String[] args) {
		int[] coins = new int[]{2};
		System.out.println(new Solution().coinChange(coins, 3));
	}
	// dp(n) 是凑到 n 分钱需要最少的硬币个数
	// 第一个选择 25 分，dp(n) = dp(n - 25) + 1
	// 第一个选择 20 分，dp(n) = dp(n - 20) + 1
	// 第一个选择 5 分，dp(n) = dp(n - 5) + 1
	// 第一个选择 1 分，dp(n) = dp(n - 1) + 1
	// dp(n) = min { dp(n - 25), dp(n - 20), dp(n - 5), dp(n - 1) } + 1
	public int coinChange(int[] coins, int amount) {
		if (coins.length < 1) return -1;

		int[] dp = new int[amount + 1];
		for (int i = 1; i < amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i < coin || dp[i - coin] < 0) continue;
				min = Math.min(min, dp[i - coin]);
			}
			if (min == Integer.MAX_VALUE) {
				dp[i] = -1;
			} else {
				dp[i] = min + 1;
			}
		}
		return dp[amount];
	}
}
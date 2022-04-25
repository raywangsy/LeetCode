package 动态规划刷题指南._746使用最小花费爬楼梯;

public class Solution02 {
	public int minCostClimbingStairs(int[] cost) {
		// cost[i] 表示离开第 i 个台阶时需要支付的费用
		// dp[i] 表示到达第 i 级台阶需要支付的费用
		// dp[0] 表示到达第 0 个台阶需要支付 0
		// dp[1] 表示到达第 1 个台阶需要支付 Math.mix(0, dp[i]) = 0; 因为可以从下标为 0 或 1 的台阶开始
		// dp[2] 可以是从 0 爬到 2，也可以从 1 爬到 2
		// 	1. 从 0 爬到 2，dp[2] 应该是到达 0 的费用 + 离开 0 的费用，即 dp[0] + cost[0]
		// 	2. 从 1 爬到 2，dp[2] 应该是到达 1 的费用 + 离开 1 的费用，即 dp[1] + cost[1]
		// 所以：dp[2] = Math.min(dp[0] + cost[0], dp[1] + cost[1])
		// dp[3] 表示到达下标为 3 的台阶需要的花费 = min(dp[1] + cost[1], dp[2] + cost[2])
		// dp[n] 表示到达下标为 n 的台阶需要的花费 = min(dp[n - 2] + cost[n - 2], dp[n - 1] + cost[n - 1])
		int[] dp = new int[cost.length + 1];
		dp[0] = dp[1] = 0;
		for (int i = 2; i <= cost.length; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		return dp[cost.length];
	}
}

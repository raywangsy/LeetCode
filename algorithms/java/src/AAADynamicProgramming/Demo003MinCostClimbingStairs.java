package AAADynamicProgramming;

/**
 * 746. 使用最小花费爬楼梯
 * source: https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/18 22:12
 */
public class Demo003MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n + 1];
		// 因为可以从下标为 `0` 或 下标为 `1` 开始，所以 dp[0] = dp[1] = 0;
		dp[0] = 0;
		dp[1] = 0;
		// dp[0] 表示到达下标为 0 的台阶需要的花费 = 0
		// dp[1] 表示到达下标为 1 的台阶需要的花费 = 0
		// dp[2] 表示到达下标为 2 的台阶需要的花费 = min(dp[0] + cost[0], dp[1] + cost[1])
		// dp[3] 表示到达下标为 3 的台阶需要的花费 = min(dp[1] + cost[1], dp[2] + cost[2])
		// dp[n] 表示到达下标为 n 的台阶需要的花费 = min(dp[n - 2] + cost[n - 2], dp[n - 1] + cost[n - 1])
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i -2] + cost[i - 2]);
		}
		return dp[n];
	}
}

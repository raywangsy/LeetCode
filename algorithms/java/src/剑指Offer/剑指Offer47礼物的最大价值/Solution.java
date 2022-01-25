package 剑指Offer.剑指Offer47礼物的最大价值;

public class Solution {
	public static void main(String[] args) {
		int[][] grid = new int[][]{
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};
		System.out.println(new Solution().maxValue(grid));
	}
	
	public int maxValue(int[][] grid) {
		// int[][] grid = new int[][]
		// 从 grid[0][0] 到 grid[m][n]
		// 到达 grid[m][n] 的上一步只有两种方式：
		// - 1): 从 grid[m-1][n] 移动
		// - 2): 从 grid[m][n-1] 移动
		// dp[m][n] = Math.max(dp[m-1][n], dp[m][n-1]) + grid[m][n]
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < grid[0].length; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < grid.length; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < grid.length; i++) {
			int[] gridy = grid[i];
			for (int j = 1; j < gridy.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[grid.length - 1][grid[0].length - 1];
	}
}

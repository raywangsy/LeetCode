package DynamicProgramming._300_最长递增子序列;

public class Solution {
	public static void main(String[] args) {
		/*
		 * 输入：nums = [10,9,2,5,3,7,101,18]
		 * 输出：4
		 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
		 */
		int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(new Solution().lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}

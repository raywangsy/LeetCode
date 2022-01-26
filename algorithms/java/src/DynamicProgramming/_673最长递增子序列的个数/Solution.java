package DynamicProgramming._673最长递增子序列的个数;

public class Solution {
	public static void main(String[] args) {

	}

	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		int max = dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			}
		}
		return 0;
	}
}

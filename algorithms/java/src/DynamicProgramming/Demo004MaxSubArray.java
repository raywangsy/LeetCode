package DynamicProgramming;

public class Demo004MaxSubArray {

	public static void main(String[] args) {

	}

	//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
	//输出：6
	//解释：连续子数组[4,-1,2,1] 的和最大，为6 。
	public int maxSubArray(int[] nums) {
		// dp[0] = -2
		// dp[1] = 1
		// dp[2] = dp[1] + (-3)
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = dp[i - 1] + nums[i];
			} else {
				dp[i] = nums[i];
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}

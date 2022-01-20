package AAADynamicProgramming;

@SuppressWarnings("DuplicatedCode")
public class Demo006RobberII {
	public int rob(int[] nums) {
		if (nums.length < 1) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		int[] dp1 = new int[nums.length];
		int[] dp2 = new int[nums.length];

		return Math.max(getMax(nums, dp1, 0), getMax(nums, dp2, 1));
	}

	private int getMax(int[] nums, int[] dp, int zero) {
		if (zero == 0) {
			dp[0] = nums[0];
			dp[1] = dp[0];
		} else {
			dp[0] = 0;
			dp[1] = nums[1];
		}
		for (int i = 2; i < nums.length; i++) {
			if (zero == 0 && i == nums.length - 1) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
			}
		}
		return dp[nums.length - 1];
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,3,1};
		System.out.println(new Demo006RobberII().rob(nums));;
	}
}

package AAADynamicProgramming;

import AddTwoNumbers.ListNode;

/**
 * source: https://leetcode-cn.com/problems/house-robber/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * @author tsingyun
 * @version V1.0 
 * @date 2022/1/19 22:08
 */
public class Demo005RobberI {

	/**
	 * 假设有数组 [1, 2, 3, 1, ...., n]
	 * 数组下标 0 表示 0 号房屋中对应有现金是 1
	 * 数组下标 1 表示 1 号房屋中对应的现金是 2
	 * 以此类推
	 *
	 * 数组 dp[n] 表示如果偷第 n 号房屋对应有总金额
	 * dp[0] 表示偷第 0 号房屋得到的现金是 nums[0] = 1
	 * dp[1] 表示偷第 1 号房屋得到的现金是 nums[1] = 2, 因为 0 号和 1 号房屋是相邻，所以如果偷 1 号就不能偷 0 号
	 * dp[2] 表示偷第 2 号房屋得到的现金，
	 * 		如果只偷 2 号，则dp[2] = nums[2]
	 * 		但 0 号和 2 号不相邻，所以再偷 0 号房屋，金额会更多即 dp[2] = dp[0] + nums[2]
	 * 		所以最大的是 dp[2] = dp[0] + nums[2]
	 * dp[3] 表示偷第 3 号房屋，由于 3 号房屋和 0，1 号房屋都不相邻，但 0 号和 1 号相邻，所以不能同时偷 0 和 1 号
	 * 		如果是偷 0 号和 3 号，则 dp[3] = dp[0] + nums[3]
	 * 		如果是偷 1 号和 3 号，则 dp[3] = dp[1] + nums[3]
	 * 		因为要获取最大金额，所以 dp[3] = Max(dp[0] + nums[3], dp[1] + nums[3])
	 * 同理，如果偷第 n 号房屋，则 dp[n] 是第 n 号房屋的现金加上 前面 n - 2 个房屋的金额的最大的一个，即：
	 * 		dp[n] = nums[n] + dp[n-2]
	 * 		dp[n] = nums[n] + dp[n-3]
	 * 		...
	 * 		dp[n] = nums[n] + dp[0]
	 * 		再从上面的所以结果中，选择最大的一个即可
	 *
	 * @param nums 数组，每个房屋内的现金
	 * @return 返回最高金额
	 */
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];
		int max = Math.max(dp[0], dp[1]);

		for (int i = 2; i < nums.length; i++) {
			int subMax = nums[i];
			for (int j = i - 2; j >=0; j--) {
				subMax = Math.max(nums[i] + dp[j], subMax);
			}
			dp[i] = subMax;
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 9, 3, 1};
		System.out.println(new Demo005RobberI().rob(nums));;
	}
}

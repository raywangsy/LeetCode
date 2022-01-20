package AAADynamicProgramming;


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
@SuppressWarnings("DuplicatedCode")
public class Demo005RobberI {

	/**
	 * 假设有数组 [1, 2, 3, 1, ...., n]
	 * 数组下标 0 表示 0 号房屋中对应有现金是 1
	 * 数组下标 1 表示 1 号房屋中对应的现金是 2
	 * 以此类推
	 * <p>
	 * 数组 dp[n] 表示前 n 个房屋能偷到的最大总金额
	 * 1. 数组长度为 1 时，dp[0] = nums[0]
	 * 2. 数组长度为 2 时，dp[1] = Math(nums[0], nums[1])
	 * 3. 数组长度为 3 时:
	 * a). 如果偷第 3 个房屋，则 dp[2] = dp[0] + nums[2]
	 * b). 如果不偷第 3 个房屋，则 dp[2] = dp[1]
	 * 所以：dp[2] = max(dp[0] + nums[2], dp[1])
	 *
	 * @param nums 数组，每个房屋内的现金
	 * @return 返回最高金额
	 */
	public int rob(int[] nums) {
		if (nums.length < 1) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		int first = nums[0];
		int second = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int temp = second;
			second = Math.max(first + nums[i], second);
			first = temp;
		}
		return second;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 9, 3, 1};
		System.out.println(new Demo005RobberI().rob(nums));
	}
}

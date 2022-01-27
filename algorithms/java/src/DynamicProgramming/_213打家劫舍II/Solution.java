package DynamicProgramming._213打家劫舍II;

@SuppressWarnings("DuplicatedCode")
public class Solution {
	public int rob(int[] nums) {
		if (nums.length < 1) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);

		return Math.max(getMax(nums, nums[0], nums[0], 0), getMax(nums, 0, nums[1], 1));
	}

	private int getMax(int[] nums, int first, int second, int zero) {
		for (int i = 2; i < nums.length; i++) {
			int val = nums[i];
			if (zero == 0 && i == nums.length - 1) {
				val = 0;
			}
			int temp = second;
			second = Math.max(first + val, second);
			first = temp;
		}
		return second;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2, 3, 2};
		System.out.println(new Solution().rob(nums));
	}
}

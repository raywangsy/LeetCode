package 剑指Offer.剑指Offer57和为s的两个数字;

public class Solution {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 7, 11, 15};
		System.out.println(new Solution().twoSum(arr, 9));
	}
	public int[] twoSum(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			if (nums[l] + nums[r] < target) {
				l++;
			} else if (nums[l] + nums[r] > target) {
				r--;
			} else {
				return new int[]{nums[l], nums[r]};
			}
		}
		return new int[0];
	}
}

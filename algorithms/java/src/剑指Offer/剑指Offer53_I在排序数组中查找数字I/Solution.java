package 剑指Offer.剑指Offer53_I在排序数组中查找数字I;

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[]{2,2};
		System.out.println(new Solution().search(nums, 3));
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1  ) {
			if (target == nums[0]) return 1;
			else return 0;
		}
		int index = getIndex(nums, target);
		if (index == -1) return 0;
		int count = 1;
		for (int i = index - 1; i >= 0; i--) {
			if (nums[i] == target) count++;
		}
		for (int i = index + 1; i < nums.length; i++) {
			if (nums[i] == target) count++;
		}
		return count;
	}

	private int getIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while (left <= right) {
			int mid = (right + left) >> 1;
			if (nums[mid] < target) {
				left = mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
package 剑指Offer.剑指Offer53_I在排序数组中查找数字I;

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[]{2,2};
		System.out.println(new Solution().search(nums, 2));
	}

	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		int end = left;
		if (right >= 0 && nums[right] != target) {
			return 0;
		}
		left = 0;
		right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return end - right - 1;
	}
}
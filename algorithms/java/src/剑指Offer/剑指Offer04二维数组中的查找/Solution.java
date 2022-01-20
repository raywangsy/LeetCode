package 剑指Offer.剑指Offer04二维数组中的查找;

public class Solution {
	public static void main(String[] args) {
		int[][] nums = new int[5][5];
		nums[0] = new int[]{1,   4,  7, 11, 15};
		nums[1] = new int[]{2,   5,  8, 12, 19};
		nums[2] = new int[]{3,   6,  9, 16, 22};
		nums[3] = new int[]{10, 13, 14, 17, 24};
		nums[4] = new int[]{18, 21, 23, 26, 30};
		System.out.println(new Solution().findNumberIn2DArray(nums, 20));
	}
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		for (int[] matrix1 : matrix) {
			int j = binarySearch(matrix1, target);
			if (j < 0) {
				continue;
			}
			return true;
		}
		return false;
	}

	private int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			int mid = (left + right) >> 1;
			if (target > nums[mid]) {
				left = mid + 1;
			} else if (target < nums[mid]){
				right = mid;
			} else {
				return mid;
			}
		}
		return -1;
	}
}

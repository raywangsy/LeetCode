package 剑指Offer.剑指Offer21调整数组顺序使奇数位于偶数前面;

public class Solution {
	public int[] exchange(int[] nums) {
		int p1 = 0;
		int p2 = nums.length - 1;
		while (p1 < p2) {
			if (nums[p1] % 2 == 1) {
				p1++;
				continue;
			}
			if (nums[p2] % 2 == 0) {
				p2--;
				continue;
			}
			int temp = nums[p1];
			nums[p1++] = nums[p2];
			nums[p2--] = temp;
		}
		return nums;
	}
}

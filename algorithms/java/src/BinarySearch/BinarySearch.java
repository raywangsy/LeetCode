/*
 * @class BinarySearch
 * @package BinarySearch
 * @date 2022/1/5 22:37
 */
package BinarySearch;

/**
 * source:  https://leetcode-cn.com/problems/binary-search/
 * <p>
 * ******************************************************************
 * Given an array of integers `nums` which is sorted in ascending order,
 * and an integer `target`, write a function to search `target` in `nums`.
 * if `target` exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with ``O(log n) runtime complexity.
 * ******************************************************************
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/5 22:37
 */
public class BinarySearch {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}

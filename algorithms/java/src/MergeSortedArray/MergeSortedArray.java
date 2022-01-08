/*
 * @class MergeSortedArray
 * @package MergeSortedArray
 * @date 2022/1/8 21:59
 */
package MergeSortedArray;

/**
 * source: https://leetcode-cn.com/problems/merge-sorted-array/
 * ******************************************************************
 * You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order (非递减),
 * and two integers `m` and `n`, representing the number of non-zero elements in `nums1` and `nums2` respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order
 * <p>
 * Example:
 * Input: nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3
 * Output: [1, 2, 3, 4, 5, 6]
 * ******************************************************************
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/8 21:59
 */
public class MergeSortedArray {

	/**
	 * merge two array
	 *
	 * @param nums1 integer array
	 * @param m     the number of non-zero element in nums1
	 * @param nums2 integer array
	 * @param n     the number of element in nums2
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p = nums1.length - 1;    // pointer to last element in nums1
		int p1 = m - 1;                // pointer to last non-zero element in nums1
		int p2 = n - 1;                // pointer to last element in nums2
		// traverse the nums2 in reverse order
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p--] = nums1[p1--];
			} else {
				nums1[p--] = nums2[p2--];
			}
		}
	}
}

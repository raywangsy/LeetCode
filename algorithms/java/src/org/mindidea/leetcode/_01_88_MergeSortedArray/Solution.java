package org.mindidea.leetcode._01_88_MergeSortedArray;


import org.mindidea.leetcode.Utils;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * time: 2021-11-03 第44周 00:00:33
 */
@SuppressWarnings("DuplicatedCode")
public class Solution {

	public static void main(String[] args) {
		Integer[] nums1 = new Integer[]{1, 2, 3, 0, 0, 0};
		Integer[] nums2 = new Integer[]{2, 5, 6};
		merge9(nums1, 3, nums2, 3);
		Utils.printArr(nums1);
	}

	/**
	 * @param nums1 第一个数组
	 * @param m     第一个数组中的非零元素个数
	 * @param nums2 每二个数组
	 * @param n     第二个数组中元素的个数
	 * @author tsingyun
	 * @time 2021-11-30 10:54
	 */
	private static void merge0(Integer[] nums1, int m, Integer[] nums2, int n) {
		int p0 = nums1.length - 1;    // 指向 nums1 数组的最后一个元素
		int p1 = m - 1;                // 指向 nums1 数组的最后一个非零元素
		int p2 = nums2.length - 1;    // 指向 nums2 数组的最后一个元素

		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] < nums2[p2]) {
				nums1[p0--] = nums2[p2--];
			} else {
				nums1[p0--] = nums1[p1--];
			}
		}
	}

	/**
	 * nums1 和 nums2 中的数字都是有序的（从大到小），所以倒着比较，
	 * 将两个数组中较大的元素放到最后
	 *
	 * @param nums1 数组 1
	 * @param m     数组 1 中元素的个数
	 * @param nums2 数组 2
	 * @param n     数组 2 中元素的个数
	 */
	private static void merge1(Integer[] nums1, int m, Integer[] nums2, int n) {
		// 指向 nums1 数组的最后一个元素
		int p0 = nums1.length - 1;
		// 指向 nums1 数组的最后一个非零元素
		int p1 = m - 1;
		// 指向 nums2 数组的最后一个元素
		int p2 = nums2.length - 1;

		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p0--] = nums1[p1--];
			} else {
				nums1[p0--] = nums2[p2--];
			}
		}
	}

	private static void merge2(Integer[] nums1, int m, Integer[] nums2, int n) {
		int p0 = nums1.length - 1;
		int p1 = m - 1;
		int p2 = nums2.length - 1;

		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p0--] = nums1[p1--];
			} else {
				nums1[p0--] = nums2[p2--];
			}
		}
	}

	private static void merge3(Integer[] nums1, int m, Integer[] nums2, int n) {
		int p0 = nums1.length - 1;
		int p1 = m - 1;
		int p2 = nums2.length - 1;
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p0--] = nums1[p1--];
			} else {
				nums1[p0--] = nums2[p2--];
			}
		}
	}

	private static void merge4(Integer[] nums1, int m, Integer[] nums2, int n) {
		int p0 = nums1.length - 1;
		int p1 = m - 1;
		int p2 = nums2.length - 1;
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p0--] = nums1[p1--];
			} else {
				nums1[p0--] = nums2[p2--];
			}
		}
	}

	private static void merge5(Integer[] nums1, int m, Integer[] nums2, int n) {
		int p0 = nums1.length - 1;
		int p1 = m - 1;
		int p2 = nums2.length - 1;
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] >= nums2[p2]) {
				nums1[p0--] = nums1[p1--];
			} else {
				nums1[p0--] = nums2[p2--];
			}
		}
	}

	private static void merge6(Integer[] nums1, int m, Integer[] nums2, int n) {
		int p0 = nums1.length - 1;
		int p1 = m - 1;
		int p2 = nums2.length - 1;
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p0--] = nums1[p1--];
			} else {
				nums1[p0--] = nums2[p2--];
			}
		}
	}

	private static void merge7(Integer[] nums1, int m, Integer[] nums2, int n) {
		int p0 = nums1.length - 1;
		int p1 = m - 1;
		int p2 = nums2.length - 1;
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p0--] = nums1[p1--];
			} else {
				nums1[p0--] = nums2[p2--];
			}
		}
	}

	private static void merge8(Integer[] nums1, int m, Integer[] nums2, int n) {
		int p0= nums1.length - 1;
		int p1 = m - 1;
		int p2 = nums2.length - 1;
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p0--] = nums1[p1--];
			} else {
				nums1[p0--] = nums2[p2--];
			}
		}
	}

	private static void merge9(Integer[] nums1, int m, Integer[] nums2, int n) {
		int p0 = nums1.length - 1;
		int p1 = m - 1;
		int p2 = nums2.length - 1;

		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p0--] = nums1[p1--];
			} else {
				nums1[p0--] = nums2[p2--];
			}
		}
	}
}

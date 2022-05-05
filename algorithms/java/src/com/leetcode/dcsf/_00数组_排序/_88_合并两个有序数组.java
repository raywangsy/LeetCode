package com.leetcode.dcsf._00数组_排序;

@SuppressWarnings("ALL")
public class _88_合并两个有序数组 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p = nums1.length - 1;
		int p1 = m - 1;
		int p2 = n - 1;

		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p--] = nums1[p1--];
			} else {
				nums1[p--] = nums2[p2--];
			}
		}
    }
}

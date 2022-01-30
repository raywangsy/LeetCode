package org.mindidea.leetcode._05_面试题16_16_部分排序;

import org.mindidea.leetcode.Utils;

/**
 * 部分排序
 * 假设数组 [1, 5, 4, 3, 2, 6, 7 ]
 * 从上述的无序数组中，找出一段数据进行排序，从而使得整个数组有序
 * 比如将 5, 4, 3, 2 排序后，整个数组就成为有序数组
 * 并保证该段数组尽量最小
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021/11/30 23:00
 */
public class Solution {
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{1, 5, 4, 3, 2, 6, 7};
		Utils.printArr(subSort3(arr));
	}

	public static Integer[] subSort3(Integer[] nums) {
		int max = nums[0];
		int r = -1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			} else {
				r = i;
			}
		}

		int min = nums[nums.length - 1];
		int l = -1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < min) {
				min = nums[i];
			} else {
				l = i;
			}
		}
		return new Integer[]{l, r};
	}

	public static Integer[] subSort2(Integer[] nums) {
		int max = nums[0];
		int r = -1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			} else {
				r = i;
			}
		}

		int min = nums[nums.length - 1];
		int l = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < min) {
				min = nums[i];
			} else {
				l = i;
			}
		}
		return new Integer[]{l, r};
	}

	public static Integer[] subSort1(Integer[] array) {
		if (array == null || array.length == 0) {
			return new Integer[]{-1, -1};
		}
		int max = array[0];
		int r = -1;
		for (int i = 1; i < array.length; i++) {
			Integer v = array[i];
			if (v > max) {
				max = v;
			} else {
				r = i;
			}
		}

		if (r == -1) {
			return new Integer[]{-1, -1};
		}

		int min = array[array.length - 1];
		int l = -1;
		for (int i = array.length - 1; i >= 0; i--) {
			Integer v = array[i];
			if (v < min) {
				min = v;
			} else {
				l = i;
			}
		}
		return new Integer[]{l, r};
	}

	/**
	 * 返回排序部分的数据的开头索引和结尾索引
	 *
	 * @param array 要排序的数组
	 * @return 开头索引和结尾索引 比如 new int[1, 4]
	 */
	public static Integer[] subSort(Integer[] array) {
		if (array == null || array.length == 0) {
			return new Integer[]{-1, -1};
		}
		// 记录从左到右扫描的逆序对
		int max = array[0];
		// 记录最右边的逆序对位置
		int r = -1;

		for (int i = 1; i < array.length; i++) {
			Integer v = array[i];
			if (v >= max) {
				max = v;
			} else {
				r = i;
			}
		}

		if (r == -1) {
			return new Integer[]{-1, -1};
		}
		int min = array[array.length - 1];
		int l = -1;
		for (int i = array.length - 2; i >= 0; i--) {
			Integer v = array[i];
			if (v <= min) {
				min = v;
			} else {
				l = i;
			}
		}
		return new Integer[]{l, r};
	}
}

package org.mindidea.leetcode._02_75_SortColors;


import org.mindidea.leetcode.Utils;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021-11-30 12:06
 */
@SuppressWarnings("DuplicatedCode")
public class Solution {
	public static void main(String[] args) {
		Solution s1 = new Solution();
		Integer[] nums = new Integer[]{2, 0, 2, 1, 1, 0};
		s1.sortColors7(nums);
		Utils.printArr(nums);
	}

	/**
	 * 对数组 [2, 0, 2, 1, 1, 0] 进行原地排序，使相等的数字相邻并且数字从小到大排序
	 *
	 * @param nums 数组
	 */
	private void sortColors3(Integer[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int p = 0;

		while (p <= right) {
			Integer num = nums[p];
			if (num == 0) {
				swap(nums, p++, left++);
			} else if (num == 1) {
				p++;
			} else {
				swap(nums, p, right--);
			}
		}
	}

	private void sortColors4(Integer[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int p = 0;
		while (p <= right) {
			if (nums[p] == 2) {
				swap(nums, p, right--);
			} else if (nums[p] == 1) {
				p++;
			} else {
				swap(nums, p++, left++);
			}
		}
	}

	private void sortColors5(Integer[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int p = 0;
		while (p <= right) {
			if (nums[p] == 0) {
				swap(nums, left++, p++);
			} else if (nums[p] == 1) {
				p++;
			} else {
				swap(nums, right--, p);
			}
		}
	}
	private void sortColors2(Integer[] nums) {
		int left = 0;                // 指向头元素
		int right = nums.length - 1;    // 指向尾元素
		int p = 0;                    // 用来遍历元素

		while (p <= right) {
			Integer num = nums[p];
			// 如果是 0 则和头指针指向的元素交换, 并且指针要指向下一个元素
			if (num == 0) {
				swap(nums, p++, left++);
			}
			// 如果是 1 则不用交换元素，只需将指针 p 向后移动
			else if (num == 1) {
				p++;
			}
			// 如果是 2 则和尾指针指向的元素交换，且尾指针向前移到
			else {
				swap(nums, p, right--);
			}
		}
	}

	public void sortColors1(Integer[] nums) {
		int i = 0;
		int l = 0;
		int r = nums.length - 1;

		while (i <= r) {
			Integer v = nums[i];
			if (v == 0) {
				swap(nums, i++, l++);
			} else if (v == 1) {
				i++;
			} else {
				swap(nums, i, r--);
			}
		}
	}

	public void sortColors6(Integer[] nums) {
		int i = 0;
		int l = 0;
		int r = nums.length - 1;
		while (i <= r) {
			if (nums[i] == 0) {
				swap(nums, i++, l++);
			} else if (nums[i] == 1) {
				i++;
			} else {
				swap(nums, i, r--);
			}
		}
	}

	public void sortColors7(Integer[] nums) {
		int l = 0;
		int r = nums.length - 1;
		int p = 0;
		while (p <= r) {
			Integer v = nums[p];
			if (v == 0) {
				swap(nums, p++, l++);
			} else if (v == 1) {
				p++;
			} else {
				swap(nums, p++, r--);
			}
		}
	}

	private void swap(Integer[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

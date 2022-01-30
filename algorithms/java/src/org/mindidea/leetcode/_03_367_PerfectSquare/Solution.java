package org.mindidea.leetcode._03_367_PerfectSquare;

/**
 * 有效的完全平方数 如果 y 是一个完全平方数据，则存在一个正整数 x，使得 x * x = y
 * <p>
 * 1 <= x <= y
 * 使用 二分查找法，拿中间数字的平方 和 y 比较
 *
 * 注意点：注意数据溢出问题
 *
 * <p>
 * 2021-11-05 下午04:16
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().isPerfectSquare1(2147483647));
		System.out.println(new Solution().isPerfectSquare2(18));
	}

	public boolean isPerfectSquare2(int num) {
		int left = 0;
		int right = num;
		while (left <= right) {
			int mid = ((right - left) >> 1) + left;
			long square = (long)mid * mid;
			if (square > num) {
				right = mid - 1;
			} else if (square < num) {
				left = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean isPerfectSquare1(int num) {
		int left = 0;
		int right = num;
		while (left <= right) {
			// mid = (right + left) >> 1, 这种方法会造成溢出，比如 num = 2147483647 时
			int mid = ((right - left) / 2) + left;
			// 转成 long 防止溢出
			long square = (long) mid * mid;
			if (square < num) {
				left = mid + 1;
			} else if (square > num) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}

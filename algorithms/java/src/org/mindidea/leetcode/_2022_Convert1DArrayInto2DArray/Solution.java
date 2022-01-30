package org.mindidea.leetcode._2022_Convert1DArrayInto2DArray;


import org.mindidea.leetcode.Utils;

/**
 * https://leetcode-cn.com/problems/convert-1d-array-into-2d-array/
 * 2022. 将一维数组转变成二维数组
 *
 * @author tsingyun
 * @version V1.0
 * @time 2022/1/1 23:26
 */
public class Solution {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 9);
		int[] original = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			original[i]	 = nums[i];
		}
		int[][] ints = new Solution().construct2DArray(original, 3, 3);
		System.out.println(ints);
	}

	public int[][] construct2DArray(int[] original, int m, int n) {
		if (original == null || m * n != original.length) {
			return new int[][]{};
		}

		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = original[i * m + j];
			}
		}
		return res;
	}
}

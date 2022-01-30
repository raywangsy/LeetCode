package org.mindidea.leetcode._04_51_NQueens;

public class Solution4 {

	private static int[] cols;
	private static int count = 0;

	public static void main(String[] args) {
		int n = 8;
		cols = new int[n];
		place(0);
		System.out.println(count);
	}

	private static void place(int row) {
		if (row == cols.length) {
			count++;
			return;
		}
		for (int i = 0; i < cols.length; i++) {
			if (isValid(row, i)) {
				cols[row] = i;
				place(row + 1);
			}
		}
	}

	private static boolean isValid(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (cols[i] == col) {
				return false;
			}
			if (row - i == Math.abs(col - cols[i])) {
				return false;
			}
		}
		return true;
	}

}

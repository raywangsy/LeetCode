package org.mindidea.leetcode._04_51_NQueens;

public class Solution5 {

	private static int count;
	private static int[] cols;

	public static void main(String[] args) {
		int n = 8;
		cols = new int[n];
		placeQueen(0);
		System.out.println(count);
	}

	private static void placeQueen(int row) {
		if (row == cols.length) {
			count++;
			return;
		}
		for (int col = 0; col < cols.length; col++) {
			if (isValid(row, col)) {
				cols[row] = col;
				placeQueen(row + 1);
			}
		}

	}

	private static boolean isValid(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (cols[i] == col) {
				return false;
			}
			if (row - i == Math.abs(cols[i] - col)) {
				return false;
			}
		}
		return true;
	}
}

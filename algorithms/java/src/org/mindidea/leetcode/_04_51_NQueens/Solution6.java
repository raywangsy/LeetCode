package org.mindidea.leetcode._04_51_NQueens;

public class Solution6 {

	private static int[] cols;
	private static int counter;

	public static void main(String[] args) {
		int n = 8;
		cols = new int[n];
		placeQueue(0);
		System.out.println(counter);
	}

	private static void placeQueue(int row) {
		if (row == cols.length) {
			counter++;
			return;
		}
		for (int col = 0; col < cols.length; col++) {
			if (isValid(row, col)) {
				cols[row] = col;
				placeQueue(row + 1);
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

package org.mindidea.leetcode._04_51_NQueens;

public class Solution3 {

	private static int count;
	private static int[] cols;

	public static void main(String[] args) {
		int n = 8;
		cols = new int[n];
		place(0);
		System.out.println(count);
	}

	private static void place(int row) {
		if (row == cols.length) {
			count++;
			show();
			return;
		}
		for (int i = 0; i < cols.length; i++) {
			if (isValid(i, row)) {
				cols[row] = i;
				place(row + 1);
			}
		}
	}

	private static boolean isValid(int col, int row) {
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
	
	private static void show() {
		for (int row = 0; row < cols.length; row++) {
			for (int col = 0; col < cols.length; col++) {
				if (col == cols[row]) {
					System.out.print("O ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
		System.out.println("====================================");
	}
}

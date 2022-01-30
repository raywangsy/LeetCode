package org.mindidea.leetcode._04_51_NQueens;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {

	private static int[] cols;
	private static int count = 0;

	public static void main(String[] args) {
		int n = 8;
		cols = new int[n];
		place(0);
		System.out.println(count);
		System.out.println("==================");
	}

	private static void place(int row) {
		// 递归结束条件
		if (row == cols.length) {
			count++;
			show();
			System.out.println("==================");
			return;
		}
		// TODO:
		// 遍历第 row 行的每一列
		for (int col = 0; col < cols.length; col++) {
			if (isValid(col, row)) {
				cols[row] = col;
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
				if (cols[row] == col) {
					System.out.print("X ");
				} else {
					System.out.print("O ");
				}
			}
			System.out.println();
		}
	}
}

package org.mindidea.leetcode._04_51_NQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

	public static void main(String[] args) {
		List<List<String>> lists = new Solution1().solveNQueens(4);
		System.out.println(lists);
	}

	private static int[] cols;

	public List<List<String>> solveNQueens(int n) {
		cols = new int[n];
		List<List<String>> result = new ArrayList<>();
		placeQueens(0, result);
		return result;
	}

	private void placeQueens(int row, List<List<String>> result) {
		if (row == cols.length) {
			show(result);
			return;
		}
		for (int col = 0; col < cols.length; col++) {
			if (isValid(row, col)) {
				cols[row] = col;
				placeQueens(row + 1, result);
			}
		}
	}

	private boolean isValid(int row, int col) {
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

	private void show(List<List<String>> result) {
		List<String> list = new ArrayList<>(cols.length);
		for (int i : cols) {
			StringBuilder sb = new StringBuilder();
			for (int col = 0; col < cols.length; col++) {
				if (i == col) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			list.add(sb.toString());
		}
		result.add(list);
	}
}

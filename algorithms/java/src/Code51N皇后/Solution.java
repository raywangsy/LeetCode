package Code51N皇后;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		List<List<String>> res = new Solution().solveNQueens(8);
		System.out.println(res);
	}

	private static int[] cols;

	public List<List<String>> solveNQueens(int n) {
		cols = new int[n];
		List<List<String>> list = new ArrayList<>(n);
		placeQueues(0, list);
		return list;
	}

	private void placeQueues(int row, List<List<String>> list) {
		if (row == cols.length) {
			show(list);
			return;
		}
		for (int i = 0; i < cols.length; i++) {
			if (isValid(row, i)) {
				cols[row] = i;
				placeQueues(row + 1, list);
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

	private void show(List<List<String>> list) {
		List<String> subList = new ArrayList<>(cols.length);
		for (int col : cols) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cols.length; i++) {
				if (i == col) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			subList.add(sb.toString());
		}
		list.add(subList);
	}
}










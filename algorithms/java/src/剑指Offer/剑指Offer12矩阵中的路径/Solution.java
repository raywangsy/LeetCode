package 剑指Offer.剑指Offer12矩阵中的路径;

public class Solution {

	private static int[][] cols;

	public boolean exist(char[][] board, String word) {
		return exist(board, word, 0, 0);
	}

	/**
	 * 一行行遍历 board
	 *
	 * @param board   二维网格
	 * @param wordNum 当前查询的字符
	 * @param row     当前遍历的行号
	 * @return boolean
	 */
	private boolean exist(char[][] board, String word, int wordNum, int row) {
		char[] curRow = board[row];
		char[] chars = word.toCharArray();
		// 遍历第 row 行的每个网格
		for (int i = 0; i < curRow.length; i++) {
			if (board[row][i] == chars[wordNum] && isValid(row, i, wordNum, chars)) {
				cols[row][i] = 1;
				// 如果第 row 行找到了一个位置，则下一个字符还需要在该行找
				exist(board, word, wordNum + 1, row);
			}
		}
		// 该行全部遍历完成还没有找到合适的位置
		int[] col = cols[row];
		for (int j : col) {
			if (j == 1) {
				// 1. 如果该行已经找到了一个，则去下一行找
				exist(board, word, wordNum + 1, row + 1);
				break;
			} else {
				// 2. 如果该行一个没有，则结束
				return false;
			}
		}
		return true;
	}

	private boolean isValid(int row, int col, int wordNum, char[] chars) {
		if (wordNum == 0) return true;
		
		return false;
	}
}

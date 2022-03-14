package 动态规划刷题指南._509斐波那契数;

/**
 * Dynamic Programming
 * source: https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/18 1:39
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().fib(4));
	}

	public int fib(int n) {
		if (n < 2) {
			return n;
		}
		int first = 0, second = 1;
		for (int i = 2; i <= n; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}
}

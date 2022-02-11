package 动态规划._70爬楼梯;

public class Solution {
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int first = 1, second = 2;
		for (int i = 3; i <= n; i++) {
			second = first + second;
			first = second - first;
		}

		return second;
	}
}

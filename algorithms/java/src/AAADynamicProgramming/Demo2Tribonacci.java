package AAADynamicProgramming;

/**
 * Dynamic Programming
 * source: https://leetcode-cn.com/problems/n-th-tribonacci-number/submissions/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/18 1:41
 */
public class Demo2Tribonacci {
	public static void main(String[] args) {
		System.out.println(new Demo2Tribonacci().tribonacci(25));
	}

	public int tribonacci(int n) {
		if (n < 2) {
			return n;
		}

		if (n == 2) {
			return 1;
		}
		int x = 0, y = 1, z = 1;
		int res = 0;
		for (int i = 3; i <= n; i++) {
			res = x + y + z;
			x = y;
			y = z;
			z = res;
		}
		return res;
	}
}
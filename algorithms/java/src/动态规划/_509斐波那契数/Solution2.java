package 动态规划._509斐波那契数;

@SuppressWarnings("ALL")
public class Solution2 {
	public static void main(String[] args) {
		System.out.println(new Solution2().fib(4));
	}

	private int fib(int n) {
		if (n < 2) return n;

		int first = 0, second = 1;
		for (int i = 2; i <= n; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}
}

package 剑指Offer.剑指Offer46把数字翻译成字符串;

public class Solution {
	public static void main(String[] args) {
		int v = 1225812;
		System.out.println(new Solution().translateNum(v));
	}
	public int translateNum(int num) {
		String s = String.valueOf(num);
		if (s.length() == 1) {
			return 1;
		}
		int first = 1;
		int second = 1;
		int v = Integer.parseInt(s.substring(0, 2));
		if (v >= 10 && v <= 25) {
			second = first + second;
		}

		for (int i = 2; i < s.length(); i++) {
			String substr = s.substring(i - 1, i + 1);
			int val = Integer.parseInt(substr);
			if (val >= 10 && val <= 25) {
				second = first + second;
				first = second - first;
			} else {
				first = second;
			}
		}
		return second;
	}
}

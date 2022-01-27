package DynamicProgramming._5最长回文子串;

public class Solution {
	public static void main(String[] args) {
		String s = "babadab";
		System.out.println(new Solution().longestPalindrome(s));
	}
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return null;
		// dp[i] 以第 i 个字符结尾的字符串的最大长度
		int[] dp = new int[s.length()];
		dp[0] = 1;
		String palindrome = "";
		int max = 1;
		char[] chars = s.toCharArray();
		for (int i = 1; i < chars.length; i++) {
			int subMax = 1;
			String subStr = String.valueOf(chars[i]);
			for (int j = 0; j <= i; j++) {
				if (chars[j] != chars[i]) {
					continue;
				}
				if (!isPalindrome(chars, j, i)) {
					continue;
				}
			}
		}
		for (int i = 1; i < s.length(); i++) {
			String substr = s.substring(0, i + 1);
			int subMax = 1;
			String subPalindrome = "";
			for (int j = 0; j < substr.length(); j++) {
				if (substr.charAt(j) != substr.charAt(substr.length() - 1)) {
					continue;
				}
				if (!isPalindrome(substr.substring(j))) {
					continue;
				}
				if (substr.substring(j).length() > subMax) {
					subPalindrome = substr.substring(j);
				}
				subMax = Math.max(subMax, substr.substring(j).length());
			}
			dp[i] = subMax;

			if (dp[i] > max) {
				palindrome = subPalindrome;
			}
			max = Math.max(dp[i], max);
		}
		return palindrome;
	}
	private boolean isPalindrome(char[] chars, int l, int r) {
		while (l < r) {
			if (chars[l] != chars[r]) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	private boolean isPalindrome(String str) {
		int l = 0, r = str.length() - 1;
		while (l < r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
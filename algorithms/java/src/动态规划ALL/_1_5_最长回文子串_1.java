package 动态规划ALL;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
@SuppressWarnings("ALL")
public class _1_5_最长回文子串_1 {

	public String longestPalindrome1(String s) {
		if (s == null || s.length() == 0) return null;
		// dp[i] 表示以第 i 个字符结尾的字符串的最大长度
		int[] dp = new int[s.length()];
		dp[0] = 1;
		String palindrome = s.substring(0, 1);
		int max = 1;
		for (int i = 1; i < s.length(); i++) {
			String substr = s.substring(0, i + 1);
		}
		return "";
	}
}

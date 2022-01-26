package 剑指Offer.剑指Offer48最长不含重复字符的子字符串;

public class Solution {
	public static void main(String[] args) {
		String str = "pwwkew";
		System.out.println(new Solution().lengthOfLongestSubstring(str));
	}
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		int[] dp = new int[s.length()];
		dp[0] = 1;
		int max = 1;
		for (int i = 1; i < s.length(); i++) {
			int preLen = dp[i - 1];
			int end = i;
			int begin = i - preLen;
			String sub = s.substring(begin, end);
			if (!sub.contains(s.substring(i, i+ 1))) {
				dp[i] = dp[i - 1] + 1;
			} else {
				int idx = sub.indexOf(s.substring(i, i + 1));
				dp[i] = dp[i - 1] - (idx + 1) + 1;
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}

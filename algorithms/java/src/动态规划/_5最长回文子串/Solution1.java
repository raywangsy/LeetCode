package 动态规划._5最长回文子串;

public class Solution1 {
	public static void main(String[] args) {
		String s = "abadd";
		System.out.println(new Solution1().longestPalindrome(s));
	}
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return null;
		// dp[i] 以第 i 个字符结尾的字符串的最大长度
		int[] dp = new int[s.length()];
		String res = s.substring(0, 1);
		char[] charArr = s.toCharArray();
		for (int i = 1; i < charArr.length; i++) {
			String subRes = s.substring(0, 1);
			int subLen = 1;
			for (int j = 0; j < i; j++) {
				if (charArr[i] != charArr[j] || !isPalindrome(charArr, j, i)) {
					continue;
				}
				int len = i - j + 1;
				if (len > subRes.length()) {
					subRes = s.substring(j, i + 1);
				}
				subLen = Math.max(subLen, len);
			}
			dp[i] = subLen;
			if (subLen > res.length()) {
				res = subRes;
			}
		}
		return res;
	}
	public String longestPalindrome1(String s) {
		if (s == null || s.length() == 0) return null;
		// dp[i] 以第 i 个字符结尾的字符串的最大长度
		int[] dp = new int[s.length()];
		dp[0] = 1;
		String palindrome = "";
		int max = 1;
		char[] chars = s.toCharArray();
		for (int i = 1; i < chars.length; i++) {
			int subMax = 1;
			String subPalindrome = "";
			for (int j = 0; j <= i; j++) {
				if (chars[j] != chars[i] || !isPalindrome(chars, j, i)) {
					continue;
				}
				if (j - i > subMax) {
					subPalindrome = s.substring(j, i + 1);
				}
				subMax = Math.max(subMax, i - j);
			}
			dp[i] = subMax;
			if (dp[i] > max) {
				palindrome = subPalindrome;
			}
			max = Math.max(dp[i], max);
		}
		//for (int i = 1; i < s.length(); i++) {
		//	String substr = s.substring(0, i + 1);
		//	int subMax = 1;
		//	String subPalindrome = "";
		//	for (int j = 0; j < substr.length(); j++) {
		//		if (substr.charAt(j) != substr.charAt(substr.length() - 1)) {
		//			continue;
		//		}
		//		if (!isPalindrome(substr.substring(j))) {
		//			continue;
		//		}
		//		if (substr.substring(j).length() > subMax) {
		//			subPalindrome = substr.substring(j);
		//		}
		//		subMax = Math.max(subMax, substr.substring(j).length());
		//	}
		//	dp[i] = subMax;
		//	if (dp[i] > max) {
		//		palindrome = subPalindrome;
		//	}
		//	max = Math.max(dp[i], max);
		//}
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
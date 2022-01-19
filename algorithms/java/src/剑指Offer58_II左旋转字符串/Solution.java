package 剑指Offer58_II左旋转字符串;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().reverseLeftWords("helloworld", 3));
	}
	public String reverseLeftWords(String s, int n) {
		char[] chars = s.toCharArray();
		char[] substr = new char[n];
		int cur = 0;
		for (int i = 0; i < chars.length; i++) {
			if (i < n) {
				substr[i] = chars[i];
			} else {
				chars[cur++] = chars[i];
			}
		}
		cur = 0;
		for (int i = chars.length - n; i < chars.length; i++) {
			chars[i] = substr[cur++];
		}

		return String.valueOf(chars);
	}
}

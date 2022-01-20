package 剑指Offer.剑指Offer58_I翻转单词顺序;

public class Solution {
	public static void main(String[] args) {
		String s = new Solution().reverseWords("    Hello,    World!    ");
		System.out.println(s);
	}

	public String reverseWords(String s) {
		char[] chars = s.toCharArray();
		char[] c1 = reverseCharArray(chars, 0, chars.length - 1);
		int cur = 0;
		boolean isSpace = false;
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != ' ') {
				c1[cur++] = c1[i];
				isSpace = false;
			} else if (!isSpace && cur > 0) {
				c1[cur++] = ' ';
				isSpace = true;
			}
		}
		int length = isSpace ? (cur - 1) : cur;
		String s1 = String.valueOf(c1);
		s1 = s1.substring(0, length);
		c1 = s1.toCharArray();
		cur = 0;
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] == ' ') {
				reverseCharArray(c1, cur, i - 1);
				cur = i + 1;
			} else if (i == c1.length - 1) {
				reverseCharArray(c1, cur, i);
			}
		}

		return String.valueOf(c1);
	}

	private char[] reverseCharArray(char[] chars, int begin, int end) {
		while (begin < end) {
			char temp = chars[begin];
			chars[begin++] = chars[end];
			chars[end--] = temp;
		}
		return chars;
	}
}
//[' ', ' ', 'a', 'b', ' ', ' ', 'c', ' ']
//[!, d, l, r, o, W,  , ,, o, l, l, e, H]
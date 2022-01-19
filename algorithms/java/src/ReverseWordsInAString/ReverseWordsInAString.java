/*
 * @class ReverseWordsInAString
 * @package ReverseWordsInAString
 * @date 2022/1/7 22:51
 */
package ReverseWordsInAString;

/**
 * source: https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * ******************************************************************
 * <p>
 * ******************************************************************
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/7 22:51
 */
public class ReverseWordsInAString {

	public static void main(String[] args) {
		String res = new ReverseWordsInAString().reverseWords("   the sky   is  blue ");
		System.out.println(res);
	}

	public String reverseWords(String s) {
		// [t, h, e,  , s, k, y,  ,  ,  , i, s,  ,  , b, l, u, e,  ]
		char[] chars = s.toCharArray();
		int len;
		int cur = 0;
		boolean space = true;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') {
				chars[cur++] = chars[i];
				space = false;
			} else if (!space) { // chars[i] == ' ', and last one is not space
				chars[cur++] = ' ';
				space = true;
			}
		}
		len = space ? (cur - 1) : cur;
		// 截取多余字符
		s = String.valueOf(chars).substring(0, len);
		chars = s.toCharArray();
		// 对整个字符数组反转
		reverse(chars, 0, chars.length - 1);
		// 对每个单词进行反转
		int lastSpace = -1; // 上一个空格位置
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ' || i == chars.length - 1) {
				int end = i == chars.length - 1 ? i : i - 1;
				reverse(chars, lastSpace + 1, end);
				lastSpace = i;
			}
		}
		return String.valueOf(chars);
	}

	private void reverse(char[] chars, int left, int right) {
		while (left < right) {
			char temp = chars[left];
			chars[left++] = chars[right];
			chars[right--] = temp;
		}
	}
}

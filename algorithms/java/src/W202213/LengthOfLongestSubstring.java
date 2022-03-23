package W202213;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/3/23 23:48
 */
public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		int max = 0;
		// 滑窗的开始位置
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			String slice = s.substring(start, i);   // 滑窗内的字符串
			String next = s.substring(i, i + 1);    // 滑窗后面的第一个字符
			// 如果滑窗后面的第一个字符存在于滑窗内，则滑窗需要往后移动
			int idx = slice.indexOf(next);
			if (idx >= 0) {
				start = start + 1 + idx;
			}
			max = Math.max(max, i + 1 - start);
		}
		return max;
	}
}

package LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharacters {

	public int test(String s) {
		if (s == null || "".equals(s)) {
			return 0;
		}
		int n = s.length();
		int p = 0;
		int i = 0;
		int max = 0;
		for (i = 0; i < n; i++) {
			int idx = s.substring(p, i).indexOf(s.substring(i, i + 1));
			if (idx >= 0) {
				p = (p + 1) + idx;
			}
			max = Math.max(max, (i + 1 - p));
		}

		return i - p;
	}
}

package LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharacters {

	public int test(String s) {
		int dp = 1;
		int max = 1;
		char[] chars = s.toCharArray();
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < chars.length; i++) {
			if (str.toString().indexOf(String.valueOf(chars[i])) > 0) {
				str = new StringBuilder();
				dp = 1;
			} else {
				dp += 1;
				str = str.append(String.valueOf(chars[i]));
			}
			max = Math.max(dp, max);
		}

		return max;
	}
}

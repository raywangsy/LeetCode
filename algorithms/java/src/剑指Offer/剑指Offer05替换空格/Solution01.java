package 剑指Offer.剑指Offer05替换空格;

public class Solution01 {
	public static void main(String[] args) {
		String res = new Solution01().replaceSpace("hello world !");
		System.out.println(res);
	}

	public String replaceSpace(String s) {
		char[] chars = s.toCharArray();
		int spaceNumber = 0;
		for (char c : chars) {
			if (' ' == c) {
				spaceNumber++;
			}
		}
		int length = chars.length + spaceNumber * 3 - spaceNumber;
		char[] res = new char[length];
		int j = 0;
		for (char aChar : chars) {
			if (' ' == aChar) {
				res[j++] = '%';
				res[j++] = '2';
				res[j++] = '0';
			} else {
				res[j] = aChar;
			}
		}
		return String.valueOf(res);
	}
}

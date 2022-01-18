package 剑指Offer05替换空格;

public class Solution {
	public static void main(String[] args) {

	}

	public String replaceSpace(String s) {
		int spaceNumber = 0;
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (c == ' ') {
				spaceNumber++;
			}
		}
		int length = s.length() + spaceNumber * 3 - spaceNumber;
		char[] res = new char[length];
		int index = 0;
		for (char c : chars) {
			if (c == ' ') {
				res[index++] = '%';
				res[index++] = '2';
				res[index++] = '0';
			} else {
				res[index++] = c;
			}
		}
		return String.valueOf(res);
	}
}

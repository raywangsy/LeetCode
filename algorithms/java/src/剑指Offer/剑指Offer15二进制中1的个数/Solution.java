package 剑指Offer.剑指Offer15二进制中1的个数;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int res = s.hammingWeight(3);
		System.out.println(res);
	}

	public int hammingWeight(int n) {
		int res = 0;
		while (n != 0) {
			res += n & 1;
			n >>= 1;
		}
		return res;
	}
}

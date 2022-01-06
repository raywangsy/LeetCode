/*
 * @class ReverseInteger
 * @package ReverseInteger
 * @date 2022/1/6 23:34
 */
package ReverseInteger;

/**
 * source: https://leetcode-cn.com/problems/reverse-integer/
 * <p>
 * ******************************************************************
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer
 * range [-231, 231 - 1], then return 0.
 * ******************************************************************
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/6 23:34
 */
public class ReverseInteger {

	public int reverse1(int x) {
		int res = 0;

		while (x != 0) {
			int prevRes = res;
			res = res * 10 + x % 10;

			if ((res - x % 10)/10 != prevRes) {
				return 0;
			}

			x = x/10;
		}
		return res;
	}

	public int reverse2(int x) {
		long res = 0;

		while (x != 0) {
			res = res * 10 + x % 10;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
			x = x/10;
		}
		return (int) res;
	}
}

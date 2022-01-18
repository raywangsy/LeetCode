package 剑指Offer03数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {

	}

	public int findRepeatNumber(int[] nums) {
		int repeat = -1;
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.add(num)) {
				repeat = num;
				break;
			}
		}
		return repeat;
	}
}
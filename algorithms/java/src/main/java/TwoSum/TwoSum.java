/*
 * @class TwoSum
 * @package TwoSum
 * @date 2022/1/2 0:34
 */
package TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * source: https://leetcode-cn.com/problems/two-sum/
 * ******************************************************************
 * Given an array of integers `nums` and an integer `target`,
 * return indices of the two numbers such that they add up to `target`.
 * <p>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * ******************************************************************
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/2 0:34
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		int[] res = new TwoSum().twoSum(nums, 9);
		String s = Arrays.toString(res);
		System.out.println(s);
	}

	public int[] twoSum(int[] nums, int target) {
		if (nums == null) {
			return new int[]{};
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{nums[i], map.get(target - nums[i])};
			}
			map.put(nums[i], i);
		}
		return new int[]{};
	}
}

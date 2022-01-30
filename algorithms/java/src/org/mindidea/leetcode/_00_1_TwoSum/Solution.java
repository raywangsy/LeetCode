package org.mindidea.leetcode._00_1_TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("DuplicatedCode")
public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
		System.out.println(Arrays.toString(twoSum2(nums, 9)));
		System.out.println(Arrays.toString(twoSum3(nums, 9)));
		System.out.println(Arrays.toString(twoSum4(nums, 9)));
		System.out.println(Arrays.toString(towSum5(nums, 9)));
		System.out.println(Arrays.toString(towSum6(nums, 9)));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}

	private static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}

	private static int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}

	private static int[] twoSum4(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}

	private static int[] towSum5(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}

	private static int[] towSum6(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[]{0};
	}
}

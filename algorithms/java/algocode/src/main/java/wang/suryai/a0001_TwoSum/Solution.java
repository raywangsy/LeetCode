/*
 * @class Solution
 * @package wang.suryai.a0001_TwoSum
 * @date 2019/10/13 13:49
 * Copyright (c) 2019 SuryaiWang
 */
package wang.suryai.a0001_TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * 1. Two Sum
 *
 * Difficulty: Easy
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author SuryaiWang 2019/10/13 13:49
 * @version V1.0
 *
 */
public class Solution {

    /**
     * Program Entry
     * @param args
     */
    public static void main(String[] args) {
        int nums[] = new int[]{2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        System.out.println("[" + result[0] +", " + result[1] + "]");
    }

    /**
     * Algorithmic logic processing
     * @param nums array of integers
     * @param target specific value
     * @return result
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i=0; i<nums.length; i++) {
            int number1 = nums[i];
            int number2 = target - number1;

            if (map.containsKey(number2)) {
                result[0] = i;
                result[1] = map.get(number2);
            }
            map.put(number1, i);
        }
        return result;
    }
}

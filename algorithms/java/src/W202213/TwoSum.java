package W202213;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/3/23 23:19
 */
@SuppressWarnings("DuplicatedCode")
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}
}

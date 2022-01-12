package exercise1 

// 思路分析：
// 假设遍历数组的第一个元素是2，而 target = 9, 所以可以得知另一个值是 9-2 = 7
// 然后去判断数组中是否有 7 这个元素，以此类推
func TwoSum(nums []int, target int) []int {
	for i := 0; i < len(nums); i++ {
		another := target - nums[i]
		for j := i + 1; j < len(nums); j++ {
			if nums[j] == another {
				result := []int{i, j}
				return result
			}
		}
	}
	return nil
}

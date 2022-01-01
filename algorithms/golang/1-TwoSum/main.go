package main

import "fmt"

/**

两数之和

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

*
*/
func main() {
	nums := []int{2, 3, 4}
	target := 6
	result := twoSum(nums, target)
	fmt.Println(result)
}

// 思路分析：
// 假设遍历数组的第一个元素是2，而 target = 9, 所以可以得知另一个值是 9-2 = 7
// 然后去判断数组中是否有 7 这个元素，以此类推
func twoSum(nums []int, target int) []int {
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

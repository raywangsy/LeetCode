package main

import (
	"fmt"
)

// ListNode 链表
type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	//nums := []int{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
	nums := []int{9, 8, 5}
	list1 := generateLinkList(nums)
	nums = []int{5, 6, 4}
	list2 := generateLinkList(nums)

	numbers := addTwoNumbers(list1, list2)

	for numbers != nil {
		fmt.Print("->", numbers.Val)
		numbers = numbers.Next
	}
}

func addTwoNumbers(list1 *ListNode, list2 *ListNode) *ListNode {

	resultList := &ListNode{}
	currentList := resultList

	sum := 0
	for list1 != nil || list2 != nil || sum != 0 {
		// 获取第一个链表上的值
		if list1 != nil {
			sum += list1.Val
			list1 = list1.Next
		}
		// 获取第二个链表上的值
		if list2 != nil {
			sum += list2.Val
			list2 = list2.Next
		}

		currentList.Next = &ListNode{Val: sum % 10}
		currentList = currentList.Next

		sum = sum / 10
	}

	return resultList.Next
}

// func addTwoNumbers2(list1 *ListNode, list2 *ListNode) *ListNode {
// 	// 分别将两个链表转成切片
// 	slice1 := make([]int, 0)
// 	for list1 != nil {
// 		slice1 = append(slice1, list1.Val)
// 		list1 = list1.Next
// 	}
// 	fmt.Println("slice1 = ", slice1)

// 	slice2 := make([]int, 0)
// 	for list2 != nil {
// 		slice2 = append(slice2, list2.Val)
// 		list2 = list2.Next
// 	}
// 	fmt.Println("slice2 = {0},", slice2)

// 	len1 := len(slice1)
// 	len2 := len(slice2)
// 	// 长的切片，用来遍历
// 	longgerSlice := slice1
// 	shorterSlice := slice2
// 	// 如果第二个长则替换
// 	if len2 > len1 {
// 		longgerSlice = slice2
// 		shorterSlice = slice1
// 	}
// 	// 定义一个空的切片，用来存储结果
// 	resultSlice := make([]int, 0)
// 	// 记录是否需要进位
// 	hasMore := false
// 	// 遍历长的
// 	for i, v := range longgerSlice {
// 		// 同一位上的数之和
// 		temp := v
// 		if i < len(shorterSlice) {
// 			temp += shorterSlice[i]
// 		}
// 		if hasMore {
// 			temp++
// 		}
// 		resultSlice = append(resultSlice, temp%10)
// 		hasMore = temp >= 10
// 	}
// 	if hasMore {
// 		resultSlice = append(resultSlice, 1)
// 	}

// 	resultList := generateLinkList(resultSlice)
// 	fmt.Println(resultList)

// 	return resultList
// }

// 根据数组生成链表
func generateLinkList(nums []int) *ListNode {
	if len(nums) == 0 {
		return nil
	}
	listNode := make([]ListNode, len(nums))
	listNode[0] = ListNode{nums[0], nil}

	for i := 1; i < len(nums); i++ {
		listNode[i] = ListNode{nums[i], nil}
		listNode[i-1].Next = &listNode[i]
	}
	return &listNode[0]
}

// // 将整数转为数组
// func turnIntToSlice(num int) *[]int {
// 	strNum := strconv.Itoa(num)
// 	// 创建指定长度的数组
// 	arr := make([]int, len(strNum))
// 	for i := 0; i < len(strNum); i++ {
// 		mod := num % 10
// 		num = num / 10
// 		arr[i] = mod
// 	}

// 	return &arr
// }

// // 判断
// // 如果是 个位数 则乘以1
// // 如果是 十位数 则诚意10
// // 一次类推
// func getTen(num int) int {

// 	var result = 1

// 	if num == 0 {
// 		return result
// 	}
// 	for i := num; i > 0; i-- {
// 		result *= 10
// 	}
// 	return result
// }

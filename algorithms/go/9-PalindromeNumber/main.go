package main

import "fmt"

// 回文数
func main() {
	fmt.Println(isPalindrome(123211))
}

func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	result := 0
	temp := x
	// 将数字反转，123 经过反转后变成 321
	for x != 0 {
		result = result*10 + x%10
		x = x / 10
	}
	return result == temp
}

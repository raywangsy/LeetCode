package main

import (
	"fmt"
	"math"
)

// 7. 整数反转
// 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
func main() {
	result := reverse(1534236469)
	fmt.Println(result)
}

func reverse(x int) int {

	arr := []int{}
	i := 0
	for x != 0 {
		arr = append(arr, x%10)
		i++
		x = x / 10
	}
	// 获取切片的长度
	arrLen := len(arr)
	temp := 0
	for i, v := range arr {
		num := arrLen - (i + 1)
		temp += v * getTens(num)
	}

	if !(temp >= math.MinInt32 && temp <= math.MaxInt32) {
		return 0
	}
	return temp
}

func getTens(num int) int {
	tens := 1
	for i := 0; i < num; i++ {
		tens *= 10
	}
	return tens
}

package main

import "fmt"

var letters = []byte{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}

func main() {
	shifts := []int{3, 5, 9}
	S := shiftingLetters("abc", shifts)
	fmt.Println(S)
}

/*
	输入：S = "abc", shifts = [3,5,9]
	输出："rpl"
	解释：
		我们以 "abc" 开始。
		将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
		再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
		最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/shifting-letters
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func shiftingLetters(S string, shifts []int) string {
	bs := []byte(S)
	// 需要移动的位数，因为字母表是循环的，所以对26取模就是移动的次数
	move := 0
	for i := len(shifts) - 1; i >= 0; i-- {
		// 当前需要移动的次数
		move += (shifts[i] % 26)
		bs[i] = letters[(int(bs[i]-'a')+move)%26]
	}
	return string(bs)
}

package 剑指Offer.剑指Offer31栈的压入弹出序列;

import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

	}
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		for(int num : pushed) {
			stack.push(num); // num 入栈
			while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
				stack.pop();
				i++;
			}
		}
		return stack.isEmpty();
	}
}
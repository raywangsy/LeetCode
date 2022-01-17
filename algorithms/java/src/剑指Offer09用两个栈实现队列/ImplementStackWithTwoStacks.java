package 剑指Offer09用两个栈实现队列;

import java.util.Stack;

/**
 * source: https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/17 22:57
 */
public class ImplementStackWithTwoStacks {
	public static void main(String[] args) {
	}
}

class CQueue {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public CQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void appendTail(int value) {
		stack1.push(value);
	}

	public int deleteHead() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}
		if (stack1.isEmpty()) {
			return -1;
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
}

/*
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
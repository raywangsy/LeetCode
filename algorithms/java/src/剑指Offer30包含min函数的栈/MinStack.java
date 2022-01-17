package 剑指Offer30包含min函数的栈;

import java.util.Stack;

/**
 * source: https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/18 0:42
 */
public class MinStack {
	public static void main(String[] args) {
		MinStack myStack = new MinStack();
		myStack.push(46);
		myStack.push(46);
		myStack.push(47);
		System.out.println(myStack.top());
		myStack.pop();
		System.out.println(myStack.min());
		myStack.pop();
		System.out.println(myStack.min());
		myStack.pop();
		myStack.push(47);
		System.out.println(myStack.top());
		System.out.println(myStack.min());
		myStack.push(-48);
		System.out.println(myStack.top());
		System.out.println(myStack.min());
		myStack.pop();
		System.out.println(myStack.min());
	}

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	/**
	 * initialize your data structure here.
	 */
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		int s = stack.pop();
		if (s == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		return minStack.peek();
	}
}

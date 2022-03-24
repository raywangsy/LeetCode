package 剑指Offer.剑指Offer09用两个栈实现队列;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("DuplicatedCode")
public class CQueue2 {
	Deque<Integer> s1;
	Deque<Integer> s2;

	public CQueue2() {
		s1 = new ArrayDeque<>();
		s2 = new ArrayDeque<>();
	}

	public void appendTail(int value) {
		s1.push(value);
	}

	public int deleteHead() {
		if (!s2.isEmpty()) {
			return s2.pop();
		}
		if (s1.isEmpty()) {
			return -1;
		}
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		return s2.pop();
	}
}

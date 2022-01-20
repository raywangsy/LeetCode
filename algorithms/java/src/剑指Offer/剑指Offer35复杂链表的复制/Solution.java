package 剑指Offer.剑指Offer35复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * source: https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/18 21:11
 */
public class Solution {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node newHead = new Node(head.val);
		Node newNode = newHead;
		Node p = head.next;
		Map<Node, Node> nodeMap = new HashMap();
		nodeMap.put(head, newHead);
		while (p != null) {
			newNode.next = new Node(p.val);
			nodeMap.put(p, newNode.next);
			newNode = newNode.next;
			p = p.next;
		}

		newNode = newHead;
		p = head;
		while (p != null) {
			newNode.random = nodeMap.get(p.random);
			newNode = newNode.next;
			p = p.next;
		}
		return newHead;
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

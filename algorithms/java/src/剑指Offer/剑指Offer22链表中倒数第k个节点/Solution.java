package 剑指Offer.剑指Offer22链表中倒数第k个节点;

import AddTwoNumbers.ListNode;

public class Solution {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		System.out.println(new Solution().getKthFromEnd(head, 2));
	}

	public ListNode getKthFromEnd(ListNode head, int k) {
		int n = 0;
		ListNode node = head;
		while (node != null) {
			node = node.next;
			n++;
		}
		node = head;
		while (n > k) {
			n--;
			node = node.next;
		}
		return node;
	}
}

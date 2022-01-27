package 剑指Offer.剑指Offer18删除链表的节点;

import AddTwoNumbers.ListNode;

public class Solution {
	public static void main(String[] args) {

	}
	public ListNode deleteNode(ListNode head, int val) {
		if (head == null) return null;
		ListNode p1 = head;
		if (val == p1.val) return p1.next;
		ListNode p2 = p1.next;
		while (p2 != null) {
			if (p2.val == val) {
				p1.next = p2.next;
				p2.next = null;
				break;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return head;
	}
}

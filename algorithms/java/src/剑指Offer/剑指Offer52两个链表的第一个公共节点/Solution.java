package 剑指Offer.剑指Offer52两个链表的第一个公共节点;

import AddTwoNumbers.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		ListNode p1 = headA;
		while (p1 != null) {
			set.add(p1);
			p1 = p1.next;
		}
		ListNode p2 = headB;
		while (p2 != null) {
			if (!set.add(p2)) {
				return p2;
			}
			p2 = p2.next;
		}
		return null;
	}
}

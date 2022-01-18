package 剑指Offer25合并两个排序的链表;

import AddTwoNumbers.ListNode;

public class Solution {
	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 2, 4, 8, 10};
		int[] arr2 = new int[]{1, 3, 5, 6};
		ListNode l1 = ListNode.genLinkedListByArray(arr1);
		ListNode l2 = ListNode.genLinkedListByArray(arr2);
		ListNode res = new Solution().mergeTwoLists(l1, l2);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(0);
		ListNode p = newHead;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					p.next = l1;
					l1 = l1.next;
				} else {
					p.next = l2;
					l2 = l2.next;
				}
			} else if (l1 != null) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		return newHead.next;
	}
}
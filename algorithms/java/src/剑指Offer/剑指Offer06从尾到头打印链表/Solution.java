package 剑指Offer.剑指Offer06从尾到头打印链表;

import AddTwoNumbers.ListNode;

public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 2, 5};
		ListNode head = ListNode.genLinkedListByArray(nums);
		int[] res = new Solution().reversePrint(head);
		for (int re : res) {
			System.out.println(re);
		}
	}
	public int[] reversePrint(ListNode head) {
		ListNode newHead = null;
		ListNode cur = head;
		int size = 0;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = newHead;
			newHead = cur;
			cur = next;
			size++;
		}

		int[] res = new int[size];
		int i = 0;
		while (newHead != null) {
			res[i] = newHead.val;
			i++;
			newHead = newHead.next;
		}
		return res;
	}
}
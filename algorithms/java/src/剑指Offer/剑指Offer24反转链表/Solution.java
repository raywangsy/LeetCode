package 剑指Offer.剑指Offer24反转链表;

/**
 * source: https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/submissions/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/18 1:03
 */
public class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = newHead;
			newHead = cur;
			cur = next;
		}
		return newHead;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

}
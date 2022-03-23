package W202213;

import commons.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/3/23 23:16
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, p = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int v1 = l1 == null ? 0 : l1.val;
			int v2 = l2 == null ? 0 : l2.val;
			int sum = v1 + v2 + carry;
			if (head == null) {
				head = new ListNode(sum % 10);
				p = head;
			} else {
				p.next = new ListNode(sum % 10);
				p = p.next;
			}
			carry = sum / 10;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		if (carry > 0) {
			p.next = new ListNode(carry);
		}
		return head;
	}
}

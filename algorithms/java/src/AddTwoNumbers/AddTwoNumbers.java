/*
 * @class AddTwoNumbers
 * @package AddTwoNumbers
 * @date 2022/1/3 15:52
 */
package AddTwoNumbers;

/**
 * source: https://leetcode-cn.com/problems/add-two-numbers/
 * ******************************************************************
 * You are given two non-empty linked lists representing two no-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * for example:
 * Input l1 = [2, 4, 3], l2 = [5, 6, 4]
 * Output: [7, 0, 8]
 * Explanation: 342 + 465 = 807
 * ******************************************************************
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/1/3 15:53
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		int carry = 0; // 进位
		while (l1 != null || l2 != null) {
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			int sum = val1 + val2 + carry;

			if (sum >= 10) {
				carry = 1;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			p.next = new ListNode(sum);
			p = p.next;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		// Be attention, (example:999999 + 999)
		if (carry > 0) {
			p.next = new ListNode(carry);
		}
		return head.next;
	}
}


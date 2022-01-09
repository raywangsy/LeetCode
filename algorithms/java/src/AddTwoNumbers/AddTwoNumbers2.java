package AddTwoNumbers;

public class AddTwoNumbers2 {
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
		if (carry > 0) {
			p.next = new ListNode(carry);
		}
		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode res = new AddTwoNumbers2().addTwoNumbers(l1, l2);

		while (res != null) {
			System.out.print(res.val);
			res = res.next;
		}
	}
}

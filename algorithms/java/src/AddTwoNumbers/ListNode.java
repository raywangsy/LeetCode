package AddTwoNumbers;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public static ListNode genLinkedListByArray(int[] array) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		for (int j : array) {
			p.next = new ListNode(j);
			p = p.next;
		}
		return head.next;
	}
}

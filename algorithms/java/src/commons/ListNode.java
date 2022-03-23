package commons;

/**
 *
 * @author tsingyun
 * @version V1.0
 * @date 2022/3/23 23:18
 */
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
}

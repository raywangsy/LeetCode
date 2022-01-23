package 剑指Offer.剑指Offer26树的子结构;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(5);


		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(1);

		System.out.println(new Solution().isSubStructure(root, root2));
	}
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (A == null || B == null) {
			return false;
		}
		Queue<TreeNode> queue1 = new ArrayDeque<>();
		Queue<TreeNode> queue2 = new ArrayDeque<>();
		queue1.offer(A);
		queue2.offer(B);
		while (!queue1.isEmpty()) {
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.peek();
			if (node1 != null) {
				queue1.offer(node1.left);
				queue1.offer(node1.right);
			}
			if ((node1 == null && node2 == null) || (Objects.requireNonNull(node1).val == Objects.requireNonNull(node2).val)) {
				node2 = queue2.poll();
				if (node2 != null) {
					queue2.offer(node2.left);
					queue2.offer(node2.right);
				}
			}
		}
		return queue2.isEmpty();
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
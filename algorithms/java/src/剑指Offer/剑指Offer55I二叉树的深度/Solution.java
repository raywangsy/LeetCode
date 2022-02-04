package 剑指Offer.剑指Offer55I二叉树的深度;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int maxDepth1(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
	}

	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		List<TreeNode> queue = new ArrayList<>();
		queue.add(root);
		int res = 0;
		List<TreeNode> temp;
		while (!queue.isEmpty()) {
			temp = new ArrayList<>();
			for (TreeNode node : queue) {
				if (node.left != null)
					temp.add(node.left);
				if (node.right != null)
					temp.add(node.right);
			}
			queue = temp;
			res++;
		}
		return res;
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